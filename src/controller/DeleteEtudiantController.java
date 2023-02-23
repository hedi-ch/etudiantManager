package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import clas.Connecter;
import clas.Etudiant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class DeleteEtudiantController extends HomeController implements Initializable{

	@FXML
	TextField  EtudiantId;
	@FXML
	Button DeleteButton;
	@FXML
	Text FirstName;
	@FXML
	Text LastName;
	@FXML
	Text Class;
	@FXML
	Text Filier;
	@FXML
	TextArea result;
	
	Connecter c =new Connecter();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		EtudiantId.setOnAction(this::etudiantCherch);
		DeleteButton.setOnAction(this::DeleteEtudiantByEtudiantId);
	}
	
	public void etudiantCherch(ActionEvent e) {
		result.setText(null);
		try{
			if(EtudiantId.getText().length()>=4) {
			Etudiant etudiant=c.cherchEtudiant(EtudiantId.getText());
			LastName.setText(etudiant.getLastName());
			FirstName.setText(etudiant.getFirstName());
			Filier.setText(etudiant.getFilier());
			Class.setText(etudiant.getClassName());
			enableAll();
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
				result.setText("faild to found Etudiant");
			}
			}
	
	public void enableAll() {
		LastName.setDisable(false);
		FirstName.setDisable(false);
		Filier.setDisable(false);
		Class.setDisable(false);
		DeleteButton.setDisable(false);
	}
	public void DeleteEtudiantByEtudiantId(ActionEvent e) {
		try {
		c.DeleteEtudiantByEtudiantId(EtudiantId.getText());
		DiasaAll();
		result.setText("we delete all note and info about Etudiant");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result.setText("faild to delete");
		}
	}
	
	public void DiasaAll() {
		LastName.setDisable(true);
		FirstName.setDisable(true);
		Filier.setDisable(true);
		Class.setDisable(true);
		DeleteButton.setDisable(true);
	}
	
}
