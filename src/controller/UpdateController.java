package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdateController extends HomeController {
	
	public void updateEtudiantInfo(ActionEvent e)throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/UpdateEtudiant.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void updateNote(ActionEvent e)throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/UpdateNote.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
}
