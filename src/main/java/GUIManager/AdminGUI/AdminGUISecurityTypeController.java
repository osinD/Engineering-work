package GUIManager.AdminGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.SecurityTypeController;
import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminGUISecurityTypeController implements Initializable{
	
	private SecurityType secToModify = new SecurityType();
	
	 	@FXML
	    private Button systemType1;

	    @FXML
	    private Button attributeType;

	    @FXML
	    private Button dangerType;

	    @FXML
	    private Button addElement;

	    @FXML
	    private Button deleteElement;

	    @FXML
	    private Button modifyElement;

	    @FXML
	    private TextField elementNameField;

	    @FXML
	    private Button confirmChanges;
	    @FXML
	    private TableView elementsTable;


	    @FXML
	    void getNameField(ActionEvent event) {

	    }

	    @FXML
	    void handleAddingDanger(ActionEvent event) {
	    	SecurityTypeController secController = new SecurityTypeController();
	    	secController.startAddingEntity();
	    	SecurityType security = new SecurityType();
	    	security.setName(elementNameField.getText());
	    	secController.createElement(security);

	    }

	    @FXML
	    void handleAttributeType(ActionEvent event) {
	    	try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafetyAttribute.fxml"));
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
	    void handleDeleteDanger(ActionEvent event) {
	    	SecurityTypeController secController = new SecurityTypeController();
	    	secController.startAddingEntity();
	    	secController.removeElement(secToModify);
	    }

	    @FXML
	    void handleModifyDanger(ActionEvent event) {
	    	
	    	SecurityTypeController secController = new SecurityTypeController();
	    	secController.startAddingEntity();
	    	SecurityType security = new SecurityType();
	    	security = secToModify;
	    	security.setName(elementNameField.getText());
	    	secController.modifyElement(security);
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
		SecurityTypeController secController = new SecurityTypeController();
		secController.startAddingEntity();
		List<SecurityType> secTypeList = secController.getAllElements();
		
		TableColumn id = new TableColumn("Id");
		TableColumn name = new TableColumn("Name");
		elementsTable.getColumns().addAll(id,name);
		final ObservableList<SecurityType> data = FXCollections.observableArrayList();
		
		for(SecurityType security : secTypeList) {
			data.add(security);
		}
		//powiązanie danych z kolumnami
				id.setCellValueFactory(new PropertyValueFactory<SecurityType,Integer>("id"));
				name.setCellValueFactory(new PropertyValueFactory<SecurityType,String>("name"));
		
		elementsTable.setItems(data);
		
		elementsTable.setRowFactory(tv -> {
		    TableRow<SecurityType> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty()) {

		        	secToModify = row.getItem();
		        	deleteElement.setStyle("-fx-background-color:  #8bc52d");
		            modifyElement.setStyle("-fx-background-color:  #8bc52d");
		            elementNameField.setText(secToModify.getName());
		            confirmChanges.setStyle("-fx-background-color:  #8bc52d");
		        }
		    });
		    return row ;
		});
		
		
	}

}
