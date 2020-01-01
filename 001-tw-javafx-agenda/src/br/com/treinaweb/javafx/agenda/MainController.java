/*
 * Arquivo: Classe - MainController
 * Autor: Paulo Alves
 * Descrição: responsável pela comunicação entre código Java e arquivo FXML.
 * Data: 29/12/2019
*/

package br.com.treinaweb.javafx.agenda;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.impl.ContatoRepositorio;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	
	@FXML
	private TableView<Contato> tabelaContatos;
	@FXML
	private Button botaoInserir;
	@FXML
	private Button botaoAlterar;
	@FXML
	private Button botaoExcluir;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfIdade;
	@FXML
	private TextField txfTelefone;
	@FXML
	private Button botaoSalvar;
	@FXML
	private Button botaoCancelar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tabelaContatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		habilitarEdicaoAgenda(false);

		this.tabelaContatos.getSelectionModel().selectedItemProperty().addListener((observador, contatoAntigo, contatoNovo) -> {
			if(contatoNovo != null) {
				txfNome.setText(contatoNovo.getNome());
				txfIdade.setText(String.valueOf(contatoNovo.getIdade()));
				txfTelefone.setText(contatoNovo.getTelefone());
			}
		});
		
		carregarTabelaContatos();
	}
	
	private void carregarTabelaContatos() {
		AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();
		List<Contato> contatos = repositorioContato.selecionar();
		if(contatos.isEmpty()) {
			Contato contato = new Contato();
			contato.setNome("Paulo");
			contato.setIdade(25);
			contato.setTelefone("(81)3333-4444");
			contatos.add(contato);
		}
		ObservableList<Contato> contatosObservableList = FXCollections.observableArrayList(contatos);
		this.tabelaContatos.getItems().setAll(contatosObservableList);
	}
	
	private void habilitarEdicaoAgenda(Boolean edicaoEstaHabilitada) {
		this.txfNome.setDisable(!edicaoEstaHabilitada);
		this.txfIdade.setDisable(!edicaoEstaHabilitada);
		this.txfTelefone.setDisable(!edicaoEstaHabilitada);
		this.botaoSalvar.setDisable(!edicaoEstaHabilitada);
		this.botaoCancelar.setDisable(!edicaoEstaHabilitada);
		this.botaoInserir.setDisable(edicaoEstaHabilitada);
		this.botaoAlterar.setDisable(edicaoEstaHabilitada);
		this.botaoExcluir.setDisable(edicaoEstaHabilitada);
		this.tabelaContatos.setDisable(edicaoEstaHabilitada);
	}
	
}
