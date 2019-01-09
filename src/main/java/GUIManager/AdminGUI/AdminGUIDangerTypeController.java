package GUIManager.AdminGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.AdminControllers.DangerTypeController;
import Entity.Database.DangerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminGUIDangerTypeController implements Initializable{
	
	private DangerType dangerToModify = new DangerType();
	
	private DangerTypeController dangerController =new DangerTypeController();
	@FXML
    private AnchorPane addDangerPanel;
	
	@FXML
    private Button addDanger;

    @FXML
    private Button deleteDanger;

    @FXML
    private Button modifyDanger;

    @FXML
    private TextField dangerNameField;

    @FXML
    private Button confirmChanges;

    @FXML
    private Button systemType;

    @FXML
    private Button attributeType;

    @FXML
    private Button securityType;

    @FXML
    private TableView dangerTable;

    @FXML
    void getDangerName(ActionEvent event) {

    }

    @FXML
    void handleAddingDanger(ActionEvent event) {
    	DangerType danger = new DangerType();
    	danger.setName(dangerNameField.getText());
    	System.out.println(dangerNameField.getText());
    	dangerController.createElement(danger);
    }

    @FXML
    void handleConfirmChanges(ActionEvent event) {
    	
    	
    	Stage stage = (Stage) confirmChanges.getScene().getWindow();
    	stage.close();
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
    void handleDeleteDanger(ActionEvent event) {
    	dangerController.removeElement(dangerToModify);
    }

    @FXML
    void handleModifyDanger(ActionEvent event) {
    	DangerType danger = new DangerType();
    	danger = dangerToModify;
    	danger.setName(dangerNameField.getText());
    	dangerController.modifyElement(danger);
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
    	Stage stage1 = (Stage) systemType.getScene().getWindow();
    	stage1.close();

    }
    private DangerTypeController dangerTypeController = new DangerTypeController();
    private List<DangerType> dangerList = dangerTypeController.getAllElements();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		TableColumn id = new TableColumn("Id");
		TableColumn name = new TableColumn("Name");
		dangerTable.getColumns().addAll(id,name);
		
		final ObservableList<DangerType> data = FXCollections.observableArrayList();
		
		for(DangerType danger : dangerList) {
			data.add(danger);
			System.out.println(danger.getName());
		}
		//powiązanie danych z kolumnami
		id.setCellValueFactory(new PropertyValueFactory<DangerType,Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<DangerType,String>("name"));
		///dodanie danych do tabeli
		dangerTable.setItems(data);
		
		dangerTable.setRowFactory(tv -> {
		    TableRow<DangerType> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty()) {

		        	dangerToModify = row.getItem();
		            deleteDanger.setStyle("-fx-background-color:  #8bc52d");
		            modifyDanger.setStyle("-fx-background-color:  #8bc52d");
		            dangerNameField.setText(dangerToModify.getName());
		            confirmChanges.setStyle("-fx-background-color:  #8bc52d");
		        }
		    });
		    return row ;
		});
		
	}
	

}
