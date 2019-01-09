package GUIManager.AdminGUI;

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

public class AdminGUIController implements Initializable{

	  @FXML
	    private AnchorPane startAdminPanel;

	    @FXML
	    private Button tiSystemType;

	    @FXML
	    private Button tiSafetyAttribute;

	    @FXML
	    private Button dangerType;

	    @FXML
	    private Button securityType;

	    @FXML
	    void handleDangerType(ActionEvent event) {
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    }

	    @FXML
	    void handleSecurityType(ActionEvent event) {
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    }

	    @FXML
	    void handleTISafetyAttribute(ActionEvent event) {
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafetyAttribute.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    }

	    @FXML
	    void handleTISystemType(ActionEvent event) {
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

}
