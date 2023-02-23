package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteController extends HomeController {
	
	public void DeleteEtudiant(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/DeleteEtudiant.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void DeleteClass(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/DeleteClass.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void DeleteMatier(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/DeleteMatier.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void DeleteNote(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/DeleteNote.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void DeleteFilier(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/DeleteFilier.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
}
