package com.unb.agenda2.Listas;

import java.util.List;

import com.unb.agenda2.Entidades.Contato;

public class ListaAgenda {
	
	private List<Contato> agenda;

	public ListaAgenda(List<Contato> agenda) {
		this.agenda = agenda;
	}
	
	public void add(Contato contato) {
		this.agenda.add(contato);
	}

	public void update(Contato contato) {
		this.agenda.set(contato.getId(), contato);
	}

	public void remove(Integer id) {
		this.agenda.remove(id);
	}

}


