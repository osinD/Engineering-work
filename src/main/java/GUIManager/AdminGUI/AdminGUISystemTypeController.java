package GUIManager.AdminGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.TISystemController;
import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import Entity.Database.TISafetyAttribute;
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
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminGUISystemTypeController  implements Initializable{
	
	private TISystemType sysToModify = new TISystemType();

	@FXML
    private Button securityType;

    @FXML
    private Button attributeType;

    @FXML
    private Button dangerType;

    @FXML
    private TableView elementsTable;

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
    private MenuButton menuAttributes;

    @FXML
    void getNameField(ActionEvent event) {

    }

    @FXML
    void handleAddingElement(ActionEvent event) {
    	
    	TISystemController tiSysController = new TISystemController();
		tiSysController.startAddingEntity();
		TISystemType system = new TISystemType();
		system.setName(elementNameField.getText());
		List<TISafetyAttribute> attributeList = new ArrayList<TISafetyAttribute>();
		attributeList.add(new TISafetyAttribute("poufność"));
		attributeList.add(new TISafetyAttribute("dostępność"));
		attributeList.add(new TISafetyAttribute("integralność"));
		system.setSafetyAttribute(attributeList);
		tiSysController.createElement(system);
		
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
    void handleDeleteElement(ActionEvent event) {
    	elementsTable.getItems().removeAll(elementsTable.getSelectionModel().getSelectedItem());
		
    }

    @FXML
    void handleModifyElement(ActionEvent event) {
    	TISystemController tiSysController = new TISystemController();
		tiSysController.startAddingEntity();
    	TISystemType system = new TISystemType();
    	system = sysToModify;
    	system.setName(elementNameField.getText());
    	tiSysController.modifyElement(system);

    }

    @FXML
    void handleSecurityTypeButton(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityType.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Administratora");
           stage.setScene(new Scene(root1));
           stage.show();
    		}catch(Exception e) {
    			
    		}
    	Stage stage1 = (Stage) securityType.getScene().getWindow();
    	stage1.close();
    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TISystemController tiSysController = new TISystemController();
		tiSysController.startAddingEntity();
		List<TISystemType> tiSystemList = tiSysController.getAllElements();
		TableColumn id = new TableColumn("Id");
		TableColumn name = new TableColumn("Name");
		elementsTable.getColumns().addAll(id,name);
		final ObservableList<TISystemType> data = FXCollections.observableArrayList();
		for(TISystemType tisys : tiSystemList) {
			data.add(tisys);
		}
		//powiązanie danych z kolumnami
		id.setCellValueFactory(new PropertyValueFactory<TISystemType,Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<TISystemType,String>("name"));
		
		elementsTable.setItems(data);
		AdminGUISafetyAttribute adminSafetyAttribute = new AdminGUISafetyAttribute();
		List<String> attrList = adminSafetyAttribute.attrinutes;
		
		if(!attrList.isEmpty()) {
		for(String s : attrList) {
			//String x =s;
		//	menuAttributes.getItems().add(new CheckMenuItem(s));
			System.out.println(s);
		}
		
		}
		
		
		elementsTable.setRowFactory(tv -> {
		    TableRow<TISystemType> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty()) {

		        	sysToModify = row.getItem();
		        	deleteElement.setStyle("-fx-background-color:  #8bc52d");
		            modifyElement.setStyle("-fx-background-color:  #8bc52d");
		            elementNameField.setText(sysToModify.getName());
		            confirmChanges.setStyle("-fx-background-color:  #8bc52d");
		        }
		    });
		    return row ;
		});
		
		
	}

}
