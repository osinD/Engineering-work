package GUIManager.StartGUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartAplication implements Initializable{

	 @FXML
	    private AnchorPane startPanel;

	    @FXML
	    private Button adminButton;

	    @FXML
	    private Button userButton;


	    @FXML
	    void handleUserButton(ActionEvent event) {
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartUser.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Przeprowadzania analizy ryzyka");
	           stage.setScene(new Scene(root1));
	           stage.show();
	           Stage stage1 = (Stage) userButton.getScene().getWindow();
	     	   stage1.close();
	    		}catch(Exception e) {
	    			
	    		}
	    }
	
	@FXML
	   void handleAdministratorButton(ActionEvent event){
		try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartAdministrator.fxml"));
       Parent root1 = (Parent) fxmlLoader.load();
       Stage stage = new Stage();
       stage.setTitle("Tryb Administratora");
       stage.setScene(new Scene(root1));
       stage.show();
       Stage stage1 = (Stage) adminButton.getScene().getWindow();
 	   stage1.close();
		}catch(Exception e) {
			
		}
       
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}