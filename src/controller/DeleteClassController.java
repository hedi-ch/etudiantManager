package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clas.Classe;
import clas.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteClassController extends HomeController implements Initializable{
	
	@FXML
	TextField className;
	@FXML
	Button Delete;
	@FXML
	TextArea result;
	Connecter c =new Connecter();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		className.setOnAction(this::CherchClass);
		Delete.setOnAction(this::DeleteClass);
		
	}
	
	public void CherchClass(ActionEvent e) {
		result.setText(null);
		if (c.chercheByClassName(className.getText())!=null) {
			Delete.setDisable(false);
		}
	}
	
	public void DeleteClass(ActionEvent e) {
		try {
		Classe ClassInfo=c.chercheByClassName(className.getText());
		c.DeleteClass(ClassInfo.getIdString());
		result.setText("we succ  deleting");
		Delete.setDisable(true);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result.setText("we faild to delete");
		}
	}
	
	
}
