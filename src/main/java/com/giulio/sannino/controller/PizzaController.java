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
		pizze.add(new Pizza(1, 1, "Angelo", "Margherita,Wrustel e patatine"));
		pizze.add(new Pizza(2, 2, "Pier", "Margherita con pepe e provola"));
		pizze.add(new Pizza(3, 1, "Frank", "Mimosa"));
		pizze.add(new Pizza(4, 3, "Anita", "Clazone Fritto"));
		return pizze;
	}

	@PutMapping("/stato/{codiceOrdine}")
	// MODIFICA LO STATO DELL'ORDINE.
	public StatoOrdine verificaStato(@PathVariable Integer codiceOrdine, @RequestBody Pizza FaseCasualeOrdine) {
		StatoOrdine stato = new StatoOrdine();
		for (Pizza pizza : pizze) {
			pizza.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
			stato.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
			if (pizza.getCodiceOrdine() == codiceOrdine) {
				if (pizza.getFaseCasualeOrdine() == 1) {
					pizza.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
					stato.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA1);
					return stato;
				} else if (pizza.getFaseCasualeOrdine() == 2) {
					pizza.getFaseCasualeOrdine();
					stato.getFaseCasualeOrdine();
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA2);
					return stato;
				} else if (pizza.getFaseCasualeOrdine() == 3) {
					pizza.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
					stato.setFaseCasualeOrdine(FaseCasualeOrdine.getFaseCasualeOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA3);
					return stato;
				}
			}
		}
		return null;

	}

	@PutMapping("/statoOrdine/{codiceOrdine}")
// STATO DELL'ORDINE
	public StatoOrdine verificaBoolean(@PathVariable Integer codiceOrdine) {
		StatoOrdine stato = new StatoOrdine();
		for (Pizza pizza : pizze) {
			pizza.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
			stato.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
			if (pizza.getCodiceOrdine() == codiceOrdine) {
				if (pizza.getFaseCasualeOrdine() == 1) {
					pizza.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA1);
					return stato;
				}
				else if (pizza.getFaseCasualeOrdine() == 2) {
					pizza.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA2);
					return stato;
				} else if (pizza.getFaseCasualeOrdine() == 3) {
					pizza.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setFaseCasualeOrdine(pizza.getFaseCasualeOrdine());
					stato.setCodiceOrdine(pizza.getCodiceOrdine());
					stato.setNomePizza(pizza.getNomePizza());
					stato.setNomeCliente(pizza.getNomeCliente());
					stato.setMessageOrdine(LibroConstants.MODIFICA_PIZZA3);
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
			if(eliminaOrdine.getFaseCasualeOrdine()==1) {
				eliminaOrdine.setFaseCasualeOrdine(eliminaOrdine.getFaseCasualeOrdine()+1);
			return "Lo stato del tuo ordine è passato da in attesa a in preparazione";
		}
		 else if(eliminaOrdine.getFaseCasualeOrdine()==2){
			eliminaOrdine.setFaseCasualeOrdine(eliminaOrdine.getFaseCasualeOrdine()+1);
			return "Lo stato del tuo ordine è passato da in preparazione a essere pronto per essere consegnato";
		}
			else if (eliminaOrdine.getFaseCasualeOrdine()==3){
				pizze.remove(eliminaOrdine);
				return "L'Ordine è stato appena consegnato";
			}
		}
		return "";
	}
}
