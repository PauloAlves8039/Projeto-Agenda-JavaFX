/*
 * Arquivo: Classe - ContatoRepositorio
 * Autor: Paulo Alves
 * Descrição: responsável por implementar métodos da interface AgendaRepositorio
 * Data: 30/12/2019
*/

package br.com.treinaweb.agenda.repositorios.impl;

import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorio implements AgendaRepositorio<Contato>{

	@Override
	public List<Contato> selecionar() {
		
		return null;
	}

	@Override
	public void inserir(Contato entidade) {
				
	}

	@Override
	public void atualizar(Contato entidade) {
				
	}

	@Override
	public void excluir(Contato entidade) {
				
	}
	
}
