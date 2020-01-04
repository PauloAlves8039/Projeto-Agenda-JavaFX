/*
 * Arquivo: Classe - ContatoRepositorioJdbc
 * Autor: Paulo Alves
 * Descrição: responsável por implementar métodos da interface AgendaRepositorio para conexão com o banco de dados
 * Data: 02/01/2020
*/

package br.com.treinaweb.agenda.repositorios.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selecionar() throws SQLException, IOException {
		Connection conexao = null;
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			Properties props = new Properties();
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
			if (is == null) {
				throw new FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado.");
			}
			props.load(is);
			conexao = DriverManager.getConnection(props.getProperty("urlConexao"), props.getProperty("usuarioConexao"), props.getProperty("senhaConexao"));
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
			if (conexao != null) {
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
