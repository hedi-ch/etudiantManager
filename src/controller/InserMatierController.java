
package controller;

import java.io.IOException;
import clas.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class InserMatierController extends HomeController {
	
	@FXML
	private TextField matierName;
	@FXML
	private TextField coefficient;
	@FXML
	private TextArea result;
	@FXML
	private ListView<String> listView;
	
	static int filierId;
	public void insertMatier(ActionEvent e)throws IOException{
		try {
			Connecter c = new Connecter();
			boolean resl=c.inserMatier(matierName.getText(),coefficient.getText(),filierId);
			if(resl) {
				result.setText("the insert succ");
				listView.getItems().add(matierName.getText());		
			}
			else result.setText(" erro filierId:"+filierId);
		}
		catch(Exception ex) {
			result.setText("the insert have error");
		}
		
	}


	
}
