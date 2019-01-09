package GUIManager.UserGUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserGUIElementExist implements Initializable{
	
	  @FXML
	    private Button okButton;

	    @FXML
	    void handleOKButton(ActionEvent event) {
	    	Stage stage = (Stage) okButton.getScene().getWindow();
        	stage.close();
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
