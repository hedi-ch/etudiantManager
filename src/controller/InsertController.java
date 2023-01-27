package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InsertController extends HomeController{
	
	public void insertClass(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/InsertClass.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void insertEtudiant(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/InsertEtudiant.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void insertFilier(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/InsertFilier.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void insertMatier(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/InsertMatier.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void insertNote(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/InsertNote.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
