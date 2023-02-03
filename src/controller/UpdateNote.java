package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clas.Connecter;
import clas.Etudiant;
import clas.Matier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateNote extends HomeController implements Initializable{
	
	
	ArrayList<Matier> listMatier=new ArrayList<>();
	Connecter c =new Connecter();


	@FXML
	TextField EtudiantId;
	@FXML
	TextField Note;
	@FXML
	ChoiceBox<Matier> matier;
	@FXML
	Button button;
	@FXML
	TextArea result;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		EtudiantId.setOnAction(this::etudiantCherch);
		button.setOnAction(this::update);
		// TODO Auto-generated method stub
		
	}
	
	public void etudiantCherch(ActionEvent e) {
		result.setText(null);
		if(EtudiantId.getText().length()>=4) {
			listMatier=c.chercheMatier(EtudiantId.getText());
			matier.getItems().clear();
			matier.getItems().addAll(listMatier);
			result.setText(null);
			enableAll();
		}		
	}
	
	public void enableAll() {
		Note.setDisable(false);
		matier.setDisable(false);
		button.setDisable(false);
	}
	
	public void disableAll() {
		Note.setDisable(true);
		matier.setDisable(true);
		button.setDisable(true);
	}
	public void update(ActionEvent e) {
		try {
			c.updateNote(EtudiantId.getText(),matier.getValue().getName(),Note.getText());
			result.setText("upsate with succ");
			disableAll();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			result.setText("upsate faild");
			e1.printStackTrace();
		}
	}

}
