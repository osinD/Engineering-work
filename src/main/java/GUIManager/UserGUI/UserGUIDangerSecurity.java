package GUIManager.UserGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.DangerTypeController;
import Controllers.AdminControllers.SecurityTypeController;
import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import Entity.Program.SecurityDanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserGUIDangerSecurity implements Initializable {

	public static List<SecurityDanger> securityDangerList= new ArrayList<SecurityDanger>();
	@FXML
    private Button lastStage;

    @FXML
    private Button securityDangers;

    @FXML
    private MenuButton dangerMenu;

    @FXML
    private ListView<String> securityList;

    @FXML
    void handleDangerMenu(ActionEvent event) {	
    	
    }
    
    @FXML
    void handleLastStage(ActionEvent event) {
    	
    	
    	
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RiskCreate.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Użytkownika");
           stage.setScene(new Scene(root1));
           stage.show();
           Stage stage1 = (Stage) lastStage.getScene().getWindow();
       	   stage1.close();
          
    		}catch(Exception e) {
    			
    		}
    }

    @FXML
    void handleSetValues(ActionEvent event) {
    	
    	
     	
    	Stage stage1 = (Stage) securityDangers.getScene().getWindow();
    	
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerSecurityChoose.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Użytkownika");
           stage.setScene(new Scene(root1));
           stage.show();
           
    		}catch(Exception e) {
    			
    		}
    	String danger;
    	
    	ObservableList<String> names;
    	names=securityList.getSelectionModel().getSelectedItems();
    	List<String> secureList= names;
    	
    	 for(MenuItem item : dangerMenu.getItems()) {
             CheckMenuItem checkMenuItem = (CheckMenuItem) item;
             if(checkMenuItem.isSelected()) {       
                 securityDangerList.add(new SecurityDanger(checkMenuItem.getText(), secureList));
             }
         }
    	 
    	 try {
     		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityDangerShow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Tryb Użytkownika");
            stage.setScene(new Scene(root1));
            stage.show();
     		}catch(Exception e) {
     			
     		}
    	stage1.close();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SecurityTypeController securityController = new SecurityTypeController();
		ObservableList<String> data = FXCollections.observableArrayList();
		securityController.startAddingEntity();
		List<SecurityType> securityAll = securityController.getAllElements();
		for(SecurityType security : securityAll) {
			data.add(security.getName());
		}
		securityList.setItems(data);
		securityList.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE);
		
		
		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangerList=usrGUIDangerCtrl.choosedDangers;
		
		for(DangerType danger : dangerList) {
			dangerMenu.getItems().add(new CheckMenuItem(danger.getName()));
		}
		
	
	}
}
