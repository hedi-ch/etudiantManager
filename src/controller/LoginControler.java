package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import clas.Connecter;

public class LoginControler extends HomeController {
	private byte NbError=0;
	
	@FXML
	private  TextField adminUserName;
	@FXML
	private  PasswordField password ;
	@FXML
	Button button;
	
	public void adminVerification(ActionEvent e) throws IOException {
		Connecter c = new Connecter();
		if(c.adminVerification(adminUserName.getText(), password.getText())) {
			Parent root = FXMLLoader.load(getClass().getResource("../Xml_Page/Home.fxml"));
			Stage stage =(Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../Xml_Page/style.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		else {
			NbError++;
			if (NbError>=3) {
				button.setDisable(true);
			}
		};

		
		
	}
	
}
