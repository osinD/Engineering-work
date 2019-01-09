package GUIManager.UserGUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserGUIEmptyList  implements Initializable{
	
	 	@FXML
	    private Button createList;

	    @FXML
	    void handleCreateList(ActionEvent event) {
	    	Stage stage = (Stage) createList.getScene().getWindow();
        	stage.close();
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

}
