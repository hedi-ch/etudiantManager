package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clas.Classe;
import clas.Connecter;
import clas.Filier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertEtudiantController extends HomeController implements Initializable {
	
	@FXML
	private ChoiceBox<String> choiseBoxClass;
	@FXML
	private ChoiceBox<String> choiseBoxFilier;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextArea result;
	
	private ArrayList<Classe> listCLass ;
	private ArrayList<Filier> listFilier ;
	Connecter c =new Connecter();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		listFilier=c.allFilier();
		for(Filier fil:listFilier) {
			choiseBoxFilier.getItems().add(fil.getName());
			}
		choiseBoxFilier.setOnAction(this::getClass);
		}
	
	public void getClass(ActionEvent e) {
		choiseBoxClass.getItems().clear();
		String filierName=choiseBoxFilier.getValue();
		result.setText(filierName);
		int filierId = c.chercheFilier(filierName).getId();
		listCLass=c.allClass(filierId);
		
		for(Classe cla:listCLass) {
			choiseBoxClass.getItems().add(cla.getClassName());
			}
		if(!choiseBoxClass.getItems().isEmpty()) {
			choiseBoxClass.setDisable(false);
			}
		else {
			choiseBoxClass.setDisable(true);
		}
		}
	
	public void insertEtudiant(ActionEvent e) {
		try {
		int classId=c.chercheByClassName(choiseBoxClass.getValue()).getId();
		boolean res=c.insertEtudiant(firstName.getText(),lastName.getText(),classId);
		if(res) result.setText("insert succ");
		else result.setText("insert failde");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result.setText("insert failde");
			
		}
	}
	}
