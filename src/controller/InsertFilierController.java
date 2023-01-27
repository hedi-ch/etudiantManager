package controller;

import java.io.IOException;

import clas.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsertFilierController extends HomeController{
	@FXML
	private  TextField FilierName;
	@FXML
	private TextArea result;
	
	
/*	public void switchSceneInsertMatier(ActionEvent e) throws IOException {
		FXMLLoader load= new FXMLLoader(getClass().getResource("../Xml_Page/InsertMatier.fxml"));
		Parent root= load.load();
		Connecter c = new Connecter();
		InserMatierController insertMatier = load.getController();
		insertMatier.insertMatier(c.chercheFilier(FilierName.getText()).getId());
		
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
*/
	
	
	
	public void insertFilier(ActionEvent e)throws IOException{
		try {
			Connecter c = new Connecter();
			boolean resl=c.insertFilier(FilierName.getText());
			if(resl) {
				result.setText("the insert succ");
				//switchSceneInsertMatier(e);
				FXMLLoader load = new FXMLLoader(getClass().getResource("../Xml_Page/InsertMatier.fxml"));
				InserMatierController.filierId=c.chercheFilier(FilierName.getText()).getId();
				
				Parent root = load.load();
				Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
				
			}
			else result.setText("the insert have error1");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result.setText("the insert have error2");
		}
		
	}
	
}
