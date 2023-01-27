package controller;

import java.io.IOException;

import clas.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertClassController extends HomeController {
	

	@FXML
	private  TextField className;
	@FXML
	private TextField classFilier;
	@FXML
	private TextArea result;
	
	public void insertClass(ActionEvent e)throws IOException{
		try {
			Connecter c = new Connecter();
			boolean resl=c.insertClass(className.getText(), classFilier.getText()) ;
			if (resl) result.setText("we add class wwith succ");
			else result.setText("we have problem with insert pls make shour of the filier name");
			System.out.println("insert");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result.setText("we have problem with connection");
		}
		
	}

}
