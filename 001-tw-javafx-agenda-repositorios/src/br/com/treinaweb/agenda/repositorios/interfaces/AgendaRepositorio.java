/*
 * Arquivo: interface - AgendaRepositorio
 * Autor: Paulo Alves
 * Descri��o: respons�vel por m�todos gen�ricos referentes a regra de neg�cio da aplica��o
 * Data: 30/12/2019
*/

package br.com.treinaweb.agenda.repositorios.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T> {
	
	List<T> selecionar() throws SQLException;
	void inserir(T entidade);
	void atualizar(T entidade);
	void excluir(T entidade);
}
