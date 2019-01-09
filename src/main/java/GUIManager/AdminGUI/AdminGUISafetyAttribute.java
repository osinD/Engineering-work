package GUIManager.AdminGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminGUISafetyAttribute  implements Initializable{
	public static List<String> attrinutes = new ArrayList<String>();
	
	  @FXML
	    private Button systemType1;

	    @FXML
	    private Button attributeType;

	    @FXML
	    private Button dangerType;

	    @FXML
	    private Button addElement;

	    @FXML
	    private TextField elementNameField;

	    @FXML
	    private Button confirmChanges;

	    @FXML
	    private TextField elementNameField1;

	    @FXML
	    private TextField elementNameField2;

	    @FXML
	    private TextField elementNameField11;

	    @FXML
	    private TextField elementNameField12;

	    @FXML
	    private TextField elementNameField13;

	    @FXML
	    private TextField elementNameField14;

	    @FXML
	    private TextField elementNameField15;

	    @FXML
	    private TextField elementNameField16;

	    @FXML
	    private TextField elementNameField17;

	    @FXML
	    private TextField elementNameField18;

	    @FXML
	    void getNameField(ActionEvent event) {

	    }

	    @FXML
	    void handleAddingDanger(ActionEvent event) {

	    }

	    @FXML
	    void handleAttributeType(ActionEvent event) {
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    	Stage stage1 = (Stage) attributeType.getScene().getWindow();
        	stage1.close();
	    }

	    @FXML
	    void handleConfirmChanges(ActionEvent event) {
	    	attrinutes.add(elementNameField.getText());
	    	Stage stage = (Stage) confirmChanges.getScene().getWindow();
        	stage.close();
	    }

	    @FXML
	    void handleDangerTypeButton(ActionEvent event) {
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    	Stage stage1 = (Stage) dangerType.getScene().getWindow();
        	stage1.close();
	    }

	    @FXML
	    void handleSystemTypeButton(ActionEvent event) {
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SystemType.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Administratora");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
	    	Stage stage1 = (Stage) systemType1.getScene().getWindow();
        	stage1.close();
	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
