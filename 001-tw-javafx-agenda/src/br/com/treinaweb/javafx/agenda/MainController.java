/*
 * Arquivo: Classe - MainController
 * Autor: Paulo Alves
 * Descrição: utilizada como controlador para o entry point.
 * Data: 29/12/2019
*/

package br.com.treinaweb.javafx.agenda;

import br.com.treinaweb.agenda.entidades.Contato;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {
	
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
	
}
