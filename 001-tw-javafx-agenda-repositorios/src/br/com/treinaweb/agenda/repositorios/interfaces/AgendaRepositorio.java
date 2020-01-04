/*
 * Arquivo: interface - AgendaRepositorio
 * Autor: Paulo Alves
 * Descrição: responsável por métodos genéricos referentes a regra de negócio da aplicação
 * Data: 30/12/2019
*/

package br.com.treinaweb.agenda.repositorios.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T> {
	
	List<T> selecionar() throws SQLException, IOException;
	void inserir(T entidade) throws SQLException, IOException;
	void atualizar(T entidade)throws SQLException, IOException;
	void excluir(T entidade)throws SQLException, IOException;
}
