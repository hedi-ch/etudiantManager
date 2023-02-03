package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clas.Connecter;
import clas.Matier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertNoteController extends HomeController implements Initializable{
	
	@FXML
	TextField etudiantId;
	@FXML
	ChoiceBox<String> choiceBox;
	@FXML
	TextField note;
	@FXML
	Button button;
	@FXML
	TextArea result;
	
	
	Matier matier;
	
	Connecter c =new Connecter();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		etudiantId.setOnAction(this::matierCherch);
		choiceBox.setOnAction(this::enableNote);
		note.setOnAction(this::enableButton);
	}
	
	public void returnToDefault() {
		button.setDisable(true);
		etudiantId.setText(null);
		choiceBox.setDisable(true);
		choiceBox.getItems().clear();
		note.setText(null);
		note.setDisable(true);
		
	}
	
	public void insertNote(ActionEvent e) {
		if(!c.cherchNoteByMatierId(etudiantId.getText(),matier.getIdString())) {
			if(c.insertNote(etudiantId.getText(), matier.getIdString(), note.getText())) result.setText("inseert sucs");
			else result.setText("inseert faild ");
		}
		else {
			result.setText("Try to update the note because it already exist");
		}
		returnToDefault();
	}
	
	public void enableButton(ActionEvent e) {
		matier =c.chercheMatierByMatierName(choiceBox.getValue());
		if(note.getText()!=null) {
			if(button.isDisabled()) {
				button.setDisable(false);
				}
		}
	}
	
	public void enableNote(ActionEvent e){
		if(note.isDisabled()) {
		note.setDisable(false);
		}
	}
	
	public boolean matierCherch(ActionEvent e) {
		if(etudiantId.getText().length()>=4) {
			
			ArrayList<Matier> matierList = c.chercheMatier(etudiantId.getText());
			for(Matier mat:matierList) {
				choiceBox.getItems().add(mat.getName());
				}
			
			if(!choiceBox.getItems().isEmpty()) {
				choiceBox.setDisable(false);
				return true;
				}
			else {
				choiceBox.setDisable(true);
				return false;
				}
		}
		else return false;
	}

}
