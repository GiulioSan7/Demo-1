package com.giulio.sannino.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.giulio.sannino.bean.CercaProdottoInputBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.giulio.sannino.bean.Prodotto;
import com.giulio.sannino.constants.LibroConstants;

@RestController
public class ProdottoController {
	private List<Prodotto> prodotti = new ArrayList();

	@GetMapping("/prodotti")
	public List<Prodotto> getProdotto() {
		prodotti.add(new Prodotto(1, "Ps5", "Console di videogame", 2019, false, 22, 0));
		prodotti.add(new Prodotto(2, "PowerBag", "Caricatore portatile", 2019, false, 22, 0));
		prodotti.add(new Prodotto(3, "Ipad", "Tablet della Apple", 2019, true, 14, 0));
		prodotti.add(new Prodotto(4, "Fifa24", "Videogioco basato sul calcio", 2023, false, 22, 0));
		prodotti.add(new Prodotto(5, "Iphone 14 pro", "cellurare di marce Apple", 2022, true, 3, 0));
		return prodotti;
	}

	@PutMapping("/aggiornaQuantita/{id}")
	@ResponseBody
	// Aggiorna quantita prodotti.
	public String eliminaCopie(@PathVariable int id, @RequestBody Prodotto quantitaMagazzino) {
		Prodotto aggiornaQ = null;
		for (Prodotto prod : prodotti) {
			if (prod.getId() == id) {
				aggiornaQ = prod;
				break;
			}
		}
		if (aggiornaQ.getQuantitàMagazzino() >= aggiornaQ.getQuantitaDaVendere()) {
			aggiornaQ.setQuantitàMagazzino(aggiornaQ.getQuantitàMagazzino() - aggiornaQ.getQuantitaDaVendere());
			return "Acquisto effettuato";
		} else {
			return "L'acquisto non puo essere effettuato per mancanza di prodotti";
		}

	}

	@Async
	@PutMapping("/vendi/{id}")

	public CompletableFuture<String> vendi(@PathVariable Integer id, @RequestParam Integer quantitaDaVendere) {
		Prodotto prodotto = prodotti.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		if (prodotto.getQuantitàMagazzino() >= quantitaDaVendere) {
			int nuovoQuantitativo = prodotto.getQuantitàMagazzino() - quantitaDaVendere;
			prodotto.setQuantitàMagazzino(nuovoQuantitativo);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return CompletableFuture.completedFuture("L'acquisto è stato completato");
			}
		}
		return CompletableFuture.completedFuture("Non è possibile acquistare le quantita di prodotto richieste");
	}

	@PostMapping("/prodottox/nuovo")
	// Aggiunta nuovo Prodotto.
	public String modifica(@RequestBody Prodotto nuovoProdotto) {
		prodotti.add(nuovoProdotto);
		return "Prodotto aggiunto con successo allo scaffale elettronica";

	}

	@GetMapping("/prodotti/totali")
	@ResponseBody
	public List<Prodotto> totali() {
		return prodotti;
	}

	@Async
	@PutMapping("/vendita/{id}")
	public CompletableFuture<String> vendita(@PathVariable Integer id, @RequestBody Prodotto prodotto) {
		CompletableFuture<String> risultato = new CompletableFuture<>();
//		Integer quantitaDaVendere = prodotto.getQuantitaDaVendere();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Prodotto eliminaP = null;
//					Prodotto prodotto = prodotti.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
					for (Prodotto prodottox : prodotti) {
						if (prodottox.getId() == id) {
							eliminaP = prodottox;
							break;
						}
					}
					if (eliminaP != null) {
						if (eliminaP.getQuantitàMagazzino() >= prodotto.getQuantitaDaVendere()) {
							eliminaP.setQuantitàMagazzino(
									eliminaP.getQuantitàMagazzino() - prodotto.getQuantitaDaVendere());
							eliminaP.setQuantitaDaVendere(prodotto.getQuantitaDaVendere());
							risultato.complete("L'acquisto è stato completato");
						} else {
							risultato.complete("Non è possibile acquistare le quantità di prodotto richieste");
						}

					}

				} catch (Exception e) {
					Thread.currentThread().interrupt();
					risultato.complete("Chiamata fallita");
				}

			}
		}).start();
		return risultato;

	}

	@DeleteMapping("/cancellaP/{id}")
	@ResponseBody
	public String cancella(@PathVariable Integer id) {
		Prodotto eliminaP = null;
		for (Prodotto prodotto : prodotti) {
			if (prodotto.getId() == id) {
				eliminaP = prodotto;
				break;
			}
		}
		if (eliminaP != null) {
			if (eliminaP.getQuantitàMagazzino() >= eliminaP.getQuantitaDaVendere()) {
				eliminaP.setQuantitàMagazzino(eliminaP.getQuantitàMagazzino() - eliminaP.getQuantitaDaVendere());
				return "Modifica effettuata";
			} else {
				prodotti.remove(eliminaP);
				return "Prodotto terminato";
			}
		}
		return null;

	}

	@PutMapping("/aggiornaQ/{id}")
	public String contare(@PathVariable Integer id, @RequestBody Prodotto prodotto) {
		for (Prodotto prodottox : prodotti) {
			if (prodottox.getId() == id) {
				prodottox.setQuantitaDaVendere(prodotto.getQuantitaDaVendere());
				return LibroConstants.MODIFICA_PRODOTTO2;
			}
		}
		return "";
	}
}
