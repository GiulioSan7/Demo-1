package com.giulio.sannino.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.giulio.sannino.bean.Libro;
import com.giulio.sannino.bean.LibroOutputBean;
import com.giulio.sannino.bean.SearchLibroInputBean;
import com.giulio.sannino.constants.LibroConstants;

@RestController
public class LibroController {
	private List<Libro> Libri = new ArrayList<>();

	@GetMapping("/libro")
	@ResponseBody
	public List<Libro> getLibro() {
		Libri.add(new Libro(0, "Java", "Team Batman", 645464, "Accenture", 7, true));
		Libri.add(new Libro(1, "Fortnite", "Ninja", 885464, "Epic games", 8, true));
		Libri.add(new Libro(2, "Domani è un altro giorno", "Foscolo", 645009, "De agostini", 2, false));
		Libri.add(new Libro(3, "Harry Potter", "Silente Mago", 645345, "Serpeverde", 1, false));
		Libri.add(new Libro(4, "Dragon Ball", "Goku", 877964, "Budokai", 5, false));
		return Libri;
	}

	@PutMapping("/change/{id}")
	@ResponseBody
	// Modifica dati di un Libro
	public LibroOutputBean updatePerson(@PathVariable Integer id, @RequestBody Libro updatedLibro) {
		LibroOutputBean outputBean = new LibroOutputBean();
		for (Libro libro : Libri) {
			if (libro.getId() == id && id >= 0 && id < Libri.size()) {
				Libri.set(id, updatedLibro);
				if (null == updatedLibro.getAutore()) {
					outputBean.setAutore(libro.getAutore());
				} else {
					outputBean.setAutore(updatedLibro.getAutore());

				}
				if (null == updatedLibro.getBorrow()) {
					outputBean.setBorrow(libro.getBorrow());
				} else {
					outputBean.setBorrow(updatedLibro.getBorrow());
				}
				if (null == updatedLibro.getCasaEditrice()) {
					outputBean.setCasaEditrice(libro.getCasaEditrice());
				} else {
					outputBean.setCasaEditrice(updatedLibro.getCasaEditrice());
				}

				if (null == updatedLibro.getId()) {
					outputBean.setId(libro.getId());
				} else {
					outputBean.setId(updatedLibro.getId());
				}
				if (null == updatedLibro.getIsbn()) {
					outputBean.setIsbn(libro.getIsbn());
				} else {
					outputBean.setIsbn(updatedLibro.getIsbn());
				}
				if (null == updatedLibro.getTitolo()) {
					outputBean.setTitolo(libro.getTitolo());
				} else {
					outputBean.setTitolo(updatedLibro.getTitolo());
				}
				if (null == updatedLibro.getNumeroCopie()) {
					outputBean.setNumeroCopie(libro.getNumeroCopie());
				} else {
					outputBean.setNumeroCopie(updatedLibro.getNumeroCopie());
				}

				outputBean.setMessage(LibroConstants.MODIFICA_OK);

				return outputBean;
			}
		}
		outputBean.setMessage(LibroConstants.MODIFICA_KO);
		return outputBean;
	}

	@PutMapping("/copiex/{id}")
	// Aggiorna il numero di copie dei libri.
	public LibroOutputBean updateCopie(@PathVariable int id, @RequestBody Libro updateCopie) {
		LibroOutputBean esito = new LibroOutputBean();
		for (Libro libro : Libri) {
			if (libro.getId() == id) {
				libro.setNumeroCopie(updateCopie.getNumeroCopie());
				esito.setNumeroCopie(updateCopie.getNumeroCopie());
				esito.setTitolo(libro.getTitolo());
				esito.setId(libro.getId());
				esito.setIsbn(libro.getIsbn());
				esito.setAutore(libro.getAutore());
				esito.setCasaEditrice(libro.getCasaEditrice());
				esito.setBorrow(libro.getBorrow());
				esito.setMessage(LibroConstants.MODIFICA_OK2);

				return esito;
			}
		}
		esito.setMessage(LibroConstants.MODIFICA_KO);
		return esito;
	}

	@DeleteMapping("/eliminaCopie/{id}")
	@ResponseBody
	// Elimina le copie dei libri.
	public String eliminaCopie(@PathVariable int id) {
		Libro eliminaCopie = null;
		for (Libro libro : Libri) {
			if (libro.getId().equals(id)) {
				eliminaCopie = libro;
				break;
			}
		}
		if (eliminaCopie != null) {
			if (eliminaCopie.getNumeroCopie() > 1) {
				eliminaCopie.setNumeroCopie(eliminaCopie.getNumeroCopie() - 1);
			} else {
				Libri.remove(eliminaCopie);

			}
			return "Modifica Effettuata";
		} else {
			return "Modifica non Effettuata";
		}
	}

	@PostMapping("/librix/nuovo")
	// Aggiunta nuovo Libro.
	public String modifica(@RequestBody Libro nuovoLibro) {
		Libri.add(nuovoLibro);
		return "Persona aggiunta con successo";

	}

	@GetMapping("/libri/totali")
	@ResponseBody
	public List<Libro> totali() {
		return Libri;
	}

	@PostMapping("/cerca")
	@ResponseBody
	// Recuperare un libro tramite l'Id e isbn.
	public LibroOutputBean getLibroById(@RequestBody SearchLibroInputBean ricerca) {
		LibroOutputBean risposta = new LibroOutputBean();
		Integer idInEsame = ricerca.getId();
		Integer isbnInEsame = ricerca.getIsbn();
		for (Libro libroInEsame : Libri) {
			if (null == isbnInEsame) {
				if (idInEsame == libroInEsame.getId()) {
					risposta.setNumeroCopie(libroInEsame.getNumeroCopie());
					risposta.setTitolo(libroInEsame.getTitolo());
					risposta.setId(libroInEsame.getId());
					risposta.setIsbn(libroInEsame.getIsbn());
					risposta.setAutore(libroInEsame.getAutore());
					risposta.setCasaEditrice(libroInEsame.getCasaEditrice());
					risposta.setBorrow(libroInEsame.getBorrow());
					risposta.setMessage(LibroConstants.MODIFICA_OK1);
					return risposta;
				}
			} else if (null == idInEsame) {
				if (isbnInEsame.equals(libroInEsame.getIsbn())) {
//					 Gli ISBN sono spesso rappresentati come stringhe o numeri interi lunghi, 
//					quindi dovresti utilizzare il metodo .equals().
					risposta.setNumeroCopie(libroInEsame.getNumeroCopie());
					risposta.setTitolo(libroInEsame.getTitolo());
					risposta.setId(libroInEsame.getId());
					risposta.setIsbn(libroInEsame.getIsbn());
					risposta.setAutore(libroInEsame.getAutore());
					risposta.setCasaEditrice(libroInEsame.getCasaEditrice());
					risposta.setBorrow(libroInEsame.getBorrow());
					risposta.setMessage(LibroConstants.MODIFICA_OK3);
					return risposta;
				}
			} else if (null == idInEsame && null == isbnInEsame) {
				risposta.setMessage(LibroConstants.MODIFICA_OK3);
				return risposta;
			}
		}
		return null;
	}

	@PostMapping("/cercare")
	@ResponseBody
	// Recuperare un libro tramite l'Id e isbn.
	public Libro prendiLibroById(@RequestBody SearchLibroInputBean ricerca) {
		LibroOutputBean risposta = new LibroOutputBean();
		Integer idInEsame = ricerca.getId();
		Integer isbnInEsame = ricerca.getIsbn();
		for (Libro libroInEsame : Libri) {
			if (isbnInEsame == null) {
				if (idInEsame == libroInEsame.getId()) {
					risposta.setMessage(LibroConstants.MODIFICA_OK);
					return libroInEsame;
				}
			} else if (idInEsame == null) {
				if (isbnInEsame == libroInEsame.getIsbn()) {
					return libroInEsame;
				}
			}
		}
		return null;
	}

	@PostMapping("/search/{id}") // NON FUNZIONA ANCORA.
	@ResponseBody
	// Recuperare un libro tramite l'Id e isbn.
	public Libro prendiLibroById(@RequestBody int id) {
		for (Libro libro : Libri) {
			if (libro.getId() == id) {
				return libro;

			}

		}
		return null;
	}

	@DeleteMapping("/eliminated/{id}")
	// Eliminazione di un libro.
	public String deleteBookById(@PathVariable int id) {
		Libro bookToRemove = null;
		for (Libro book : Libri) {
			if (book.getId().equals(id)) {
				bookToRemove = book;
				break;
			}
		}

		if (bookToRemove != null) {
			Libri.remove(bookToRemove);
			return "Libro cancellato correttamente";
		} else {
			return "Libro non trovato";
		}
	}

	@GetMapping("/book/totalix")
	@ResponseBody
	public List<Libro> totale() {
		return Libri;
	}

	@PutMapping("/borrow/{id}")
	// Aggiorna il numero di copie dei libri.
	public String prendereInPrestito(@PathVariable int id) {

		for (Libro libro : Libri) {
			if (libro.getId() == id) {
				// libro.setBorrow(borrowUpdate.getBorrow());
				if (libro.getBorrow() == false) {
					libro.setBorrow(true);
					return "Prestito effettuato con successo";
				} else {
					return "Prestito non effettuata con successo";
				}

			}
		}
		return "Modifica non effettuata";
	}

	@PutMapping("/return/{id}")
	// Aggiorna il numero di copie dei libri.
	public String restituireLibro(@PathVariable int id) {

		for (Libro libro : Libri) {
			if (libro.getId() == id) {
				// libro.setBorrow(borrowUpdate.getBorrow());
				if (libro.getBorrow() == false) {
					return "Il libro già è stato restituito";
				} else {
					libro.setBorrow(false);
					return "Libro restituito con successo";
				}

			}
		}
		return "Modifica non effettuata";
	}

}
