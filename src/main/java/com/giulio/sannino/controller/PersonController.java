package com.giulio.sannino.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.giulio.sannino.bean.Person;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

	private List<Person> persone = new ArrayList<>();

	@GetMapping("/persone")
	@ResponseBody
	public List<Person> getPersone() {
		// Simuliamo il recupero di una lista di persone dal database.
		persone.add(new Person("Rossi", "Mario", "Napoli", "MARIO3243ROSS95"));
		persone.add(new Person("Verdi", "Giuseppe", "Napoli", "GIUSEVER27323"));
		persone.add(new Person("Esposito", "Mario", "Milano", "ESPOSMARIO3235TO"));
		persone.add(new Person("Russo", "Gabriel", "Salerno", "RUSS89GABRIEL00"));
		persone.add(new Person("Di Lorenzo", "Giovanni", "Cesena", "DILOREN900GIOV768"));

		return persone;
	}

	@PostMapping("/persone/inserisci")
	// @RequestMapping(value = "/persone/gg", method = RequestMethod.POST)
	public String modifica(@RequestBody Person nuovaPersona) {
		persone.add(nuovaPersona);

		return "Persona aggiunta con successo";

	}

	@GetMapping("/persone/total")
	@ResponseBody
	public List<Person> totale() {
		return persone;
	}

	@PutMapping("/modifica/{index}")
	@ResponseBody
	public String updatePerson(@PathVariable int index, @RequestBody Person updatedPerson) {
		if (index >= 0 && index < persone.size()) {
			persone.set(index, updatedPerson);
			return "Modifica Effettuata";
		} else {
			return "Modifica non Effettuata";
		}
	}

}
