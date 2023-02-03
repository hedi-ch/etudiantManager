package controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clas.Classe;
import clas.Connecter;
import clas.Etudiant;
import clas.Filier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class updateEtudiantController extends HomeController implements Initializable{
	
	@FXML
	TextField EtudiantId;
	@FXML
	TextField lastName;
	@FXML
	TextField firstName;
	@FXML
	ChoiceBox<String> FilierName;
	@FXML
	ChoiceBox<String> className;
	@FXML
	Button button; 
	@FXML
	TextArea result;
	
	ArrayList<Filier> listFilier=new ArrayList<>();
	
	
	Connecter c =new Connecter();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		EtudiantId.setOnAction(this::etudiantCherch);
		FilierName.setOnAction(this::getClass);
		button.setOnAction(this::update);
		
		
	}
	
	public void update(ActionEvent e) {
		try {
			c.updateEtudiant(EtudiantId.getText(),lastName.getText() , firstName.getText(), className.getValue());
			result.setText("upsate with succ");
			disebleAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			result.setText("upsate fail");
			e1.printStackTrace();
		}
	}
	
	
	public void enableAll() {
		lastName.setDisable(false);
		firstName.setDisable(false);
		FilierName.setDisable(false);
		className.setDisable(false);
		button.setDisable(false);
	}
	
	
	public void disebleAll() {
		lastName.setDisable(true);
		firstName.setDisable(true);
		FilierName.setDisable(true);
		className.setDisable(true);
		button.setDisable(true);
	}
	
	
	public void etudiantCherch(ActionEvent e) {
		result.setText(null);
		if(EtudiantId.getText().length()>=4) {
			filierCherch();
			Etudiant etudiant=c.cherchEtudiant(EtudiantId.getText());
			lastName.setText(etudiant.getLastName());
			firstName.setText(etudiant.getFirstName());
			FilierName.setValue(etudiant.getFilier());
			className.setValue(etudiant.getClassName());
			enableAll();
		}
	}
	
	
	public void getClass(ActionEvent e) {
		ArrayList<Classe> listCLass=new ArrayList <>();
		className.getItems().clear();
		String filierName=FilierName.getValue();
		int filierId = c.chercheFilier(filierName).getId();
		listCLass=c.allClass(filierId);
		
		for(Classe cla:listCLass) {
			className.getItems().add(cla.getClassName());
			}
		}
	
	
	public void filierCherch() {
		listFilier=c.allFilier();
		for(Filier fil:listFilier) {
			FilierName.getItems().add(fil.getName());
			}
	}
	
}
