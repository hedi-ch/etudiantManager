package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
	
	public void insertSwitch(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Insert.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void updateSwitch(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Update.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void deleteSwitch(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Delete.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void searchSwitch(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Search.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void moyenSwitch(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Moyen.fxml"));
		Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}
