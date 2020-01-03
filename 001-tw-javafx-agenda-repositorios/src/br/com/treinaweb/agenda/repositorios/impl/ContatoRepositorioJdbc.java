/*
 * Arquivo: Classe - ContatoRepositorioJdbc
 * Autor: Paulo Alves
 * Descrição: responsável por implementar métodos da interface AgendaRepositorio para conexão com o banco de dados
 * Data: 02/01/2020
*/

package br.com.treinaweb.agenda.repositorios.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selecionar() throws SQLException {
		Connection conexao = null;
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tw_jdbc?useTimezone=true&serverTimezone=UTC", "root", "root");
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM contatos");
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setIdade(rs.getInt("idade"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}
		} finally {
			if(conexao != null) {
				conexao.close();
			}
		}

		return contatos;
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
