package GUIManager.UserGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.DangerTypeController;
import Entity.Database.DangerType;
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
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class UserGUISystemDangerController implements Initializable {
	
	public static List<DangerType> choosedDangers = new ArrayList<DangerType>();

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
	    private ListView<String> everyDangerElement;

	    @FXML
	    private ListView<String> myDangerElements;

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
	    	names=everyDangerElement.getSelectionModel().getSelectedItems();
	    	String val = names.get(0);
	    	List<String> numbers = myDangerElements.getItems();
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
	    			myDangerElements.getItems().add(val);
	    		}
	    	}else {
	    		myDangerElements.getItems().add(val);
	    	}
	    }

	    @FXML
	    void handleNextStage(ActionEvent event) {
	    	
	    	ObservableList<String> names;
	    	names=myDangerElements.getItems();
	    	for(String cd : names) {
	    		System.out.println(cd);
	    	}
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
	    	DangerTypeController dangerController = new DangerTypeController();
	    	dangerController.startAddingEntity();
	    	List<DangerType> dangerList =  dangerController.getAllElements();
	    	for(String str : names) {
	    	for(DangerType danger : dangerList) {
	    		
	    			if(str.equals(danger.getName())) {
	    			choosedDangers.add(danger);
	    			}
	    		}
	    	}
	    	
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerSecurityChoose.fxml"));
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
	    	myDangerElements.getItems().removeAll(myDangerElements.getSelectionModel().getSelectedItem());
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
			
			DangerTypeController dangerController = new DangerTypeController();
			ObservableList<String> data = FXCollections.observableArrayList();
			dangerController.startAddingEntity();
			List<DangerType> dangerList =  dangerController.getAllElements();
			
			for(DangerType danger : dangerList) {
				data.add(danger.getName());
			}
			
			everyDangerElement.setItems(data);
			everyDangerElement.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}

}
