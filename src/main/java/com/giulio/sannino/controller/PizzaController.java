package com.giulio.sannino.controller;

import java.util.ArrayList;
import java.util.List;
import com.giulio.sannino.constants.LibroConstants;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.giulio.sannino.bean.Libro;
import com.giulio.sannino.bean.Pizza;
import com.giulio.sannino.bean.StatoOrdine;

@RestController
public class PizzaController {
	private List<Pizza> pizze = new ArrayList();

	@GetMapping("/pizza")
	public List<Pizza> getPizza() {
		pizze.add(new Pizza(1, false, "Angelo", "Margherita,Wrustel e patatine"));
		pizze.add(new Pizza(2, false, "Pier", "Margherita con pepe e provola"));
		pizze.add(new Pizza(3, false, "Frank", "Mimosa"));
		pizze.add(new Pizza(4, false, "Anita", "Clazone Fritto"));
		return pizze;
	}

	@PutMapping("/stato/{codiceOrdine}")
	// VERIFICA DELLO STATO DELL'ORDINE.
	public StatoOrdine verificaStato(@PathVariable Integer codiceOrdine) {
		StatoOrdine stato = new StatoOrdine();
		for (Pizza pizza : pizze) {
			if (pizza.getCodiceOrdine() == codiceOrdine) {
				if (pizza.isStatoOrdine() == false) {
					pizza.isStatoOrdine();
					stato.isStatoOrdine();
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_OK5);
					return stato;
				} else {
					pizza.isStatoOrdine();
					stato.isStatoOrdine();
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_OK6);
					return stato;
				}
			}
		}
		return null;

	}

	@PutMapping("/statoOrdine/{codiceOrdine}")
//	MODIFICA LO STATO DELL'ORDINE
	public StatoOrdine verificaBoolean(@PathVariable Integer codiceOrdine, @RequestBody Pizza statoOrdine) {
		StatoOrdine stato = new StatoOrdine();
		for (Pizza pizza : pizze) {
			if (pizza.getCodiceOrdine() == codiceOrdine) {
				if (pizza.isStatoOrdine() == false) {
					pizza.setStatoOrdine(statoOrdine.isStatoOrdine());
					stato.setStatoOrdine(statoOrdine.isStatoOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_OK6);
					return stato;
				}
			}
		}

		return stato;
	}

	@GetMapping("/pizzeria/totali")
	@ResponseBody
	public List<Pizza> totali() {
		return pizze;
	}

	@DeleteMapping("/eliminaOrdine/{codiceOrdine}")
//	ELIMINA L'ORDINE SE LO STATO DELL'ORDINE E' TRUE.
	public String ordineTerminato(@PathVariable Integer codiceOrdine) {
//		StatoOrdine stato = new StatoOrdine();
		Pizza eliminaOrdine = null;
		for (Pizza pizza : pizze) {
			if (pizza.getCodiceOrdine() == codiceOrdine) {
				eliminaOrdine = pizza;
				break;
			}
		}
		if (eliminaOrdine != null) {
			pizze.remove(eliminaOrdine);
			return "Ordine già effettuato,passare al successivo";
		} else {
			pizze.remove(eliminaOrdine);
			return "Ordine da effettuare";
		}
	}
}
