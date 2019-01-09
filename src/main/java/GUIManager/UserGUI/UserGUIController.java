package GUIManager.UserGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.DangerTypeController;
import Controllers.AdminControllers.TISystemController;
import Entity.Database.TISystemType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.stage.Stage;

public class UserGUIController implements Initializable{
	
	public static List<TISystemType> choosedSystems = new ArrayList<TISystemType>();
	public static String dangerForSecurity;
	
	@FXML
    private MenuItem adminSelect;
	
	@FXML
    private Button secondStage;

    @FXML
    private Button thirdStage;

    @FXML
    private Button getElements;

    @FXML
    private Button removeElements;

    @FXML
    private Button fifthStage;

    @FXML
    private Button fourthStage;

    @FXML
    private Button sixthStage;

    @FXML
    private Button nextStage;

    @FXML
    private Button firstStage;

    @FXML
    private ListView<String> everySystemElement;

    @FXML
    private ListView<String> mySystemElements;
    
    @FXML
    void handleAdmin(ActionEvent event) {
    	
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/StartGUI/StartAdministrator.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Użytkownika");
           stage.setScene(new Scene(root1));
           stage.show();
    		}catch(Exception e) {
    			
    		}
    }

    @FXML
    void handleFifthStage(ActionEvent event) {

    }

    @FXML
    void handleFirstStage(ActionEvent event) {

    }

    @FXML
    void handleFourthStage(ActionEvent event) {

    }

    @FXML
    void handleGetElements(ActionEvent event) {
    	ObservableList<String> names;
    	names=everySystemElement.getSelectionModel().getSelectedItems();
    	String val = names.get(0);
    	List<String> numbers = mySystemElements.getItems();
    	int flag =0;
    	if(!numbers.isEmpty()) {
    		for(String s : numbers) {
    			
    			if(s.equals(val)) {
    				flag=1;
    			}
    		}
    		if(flag ==1) {
    			try {
            		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ElementExist.fxml"));
                   Parent root1 = (Parent) fxmlLoader.load();
                   Stage stage = new Stage();
                   stage.setTitle("Tryb Użytkownika");
                   stage.setScene(new Scene(root1));
                   stage.show();
            		}catch(Exception e) {
            			
            		}
    		}else {
    			mySystemElements.getItems().add(val);
    		}
    	}else {
    	mySystemElements.getItems().add(val);
    	}
    	
    }

    @FXML
    void handleNextStage(ActionEvent event) {
    	ObservableList<String> names;
    	names=mySystemElements.getItems();
    	if(names.isEmpty()) {
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmptyList.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
        		}catch(Exception e) {
        			
        		}
    	}else {
    	TISystemController systemController =new TISystemController();
    	systemController.startAddingEntity();
    	List<TISystemType> systemTypes = systemController.getAllElements();
    	for(TISystemType system : systemTypes) {
    		for(String str  : names) {
    			if(str.equals(system.getName())) {
    				choosedSystems.add(system);
    			}
    		}
    	}
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LossValues.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Użytkownika");
           stage.setScene(new Scene(root1));
           stage.show();
           Stage stage1 = (Stage) nextStage.getScene().getWindow();
       	   stage1.close();
    		}catch(Exception e) {
    			
    		}
    	}
    }

    @FXML
    void handleRemoveElements(ActionEvent event) {
    	
    	mySystemElements.getItems().removeAll(mySystemElements.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleSecondStage(ActionEvent event) {

    }

    @FXML
    void handleSisthStage(ActionEvent event) {

    }

    @FXML
    void handleThirdStage(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TISystemController systemController =new TISystemController();
		ObservableList<String> data = FXCollections.observableArrayList();
		systemController.startAddingEntity();
		List<TISystemType> systemTypes = systemController.getAllElements();
		
		for(TISystemType system : systemTypes) {
				data.add(system.getName());
				System.out.println(system.getName());
		}
		everySystemElement.setItems(data);
		everySystemElement.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}

}
