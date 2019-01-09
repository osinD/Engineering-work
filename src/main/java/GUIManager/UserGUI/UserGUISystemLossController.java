package GUIManager.UserGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.UserControllers.RiskAnalisisController;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;
import Entity.Program.RiskTISystem;
import javafx.beans.value.ObservableValue;
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

public class UserGUISystemLossController implements Initializable {
	
	public static String names;
	@FXML
	private Button chooseDanger;

	@FXML
	private Button lossValButton;

	@FXML
	private ListView<String> choosedSystems;

	@FXML
	void handleChooseDanger(ActionEvent event) {
		UserGUIController usrGUI = new UserGUIController();
		List<TISystemType> systems = usrGUI.choosedSystems;
		RiskAnalisisController riskAnalisisController = new RiskAnalisisController();
		List<RiskTISystem> tiLossEffects = riskAnalisisController.tiLossEffects;
		TISafetyAttribute tiSafetyAttribute ;
		int flag =0;
		for(TISystemType system : systems) {
			flag=0;
			for(RiskTISystem riskSystem : tiLossEffects) {
				if(system.getName().equals(riskSystem.getTiSystemType().getName())) {
					flag=1;
				}
			}
			if(flag ==0) {
				tiSafetyAttribute = new TISafetyAttribute("poufność");
		    	riskAnalisisController.chooseRiskTISystemElement(system, tiSafetyAttribute, 0);
		    	
		    	tiSafetyAttribute = new TISafetyAttribute("integralność");
		    	riskAnalisisController.chooseRiskTISystemElement(system, tiSafetyAttribute, 0);
		    	
		    	tiSafetyAttribute = new TISafetyAttribute("dostępność");
		    	riskAnalisisController.chooseRiskTISystemElement(system, tiSafetyAttribute, 0);
			}
		}
		
		try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerChoose.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Tryb Użytkownika");
           stage.setScene(new Scene(root1));
           stage.show();
           Stage stage1 = (Stage) chooseDanger.getScene().getWindow();
       	   stage1.close();
    		}catch(Exception e) {
    			
    		}
	}

	@FXML
	void handleLossValButton(ActionEvent event) {
		
		
    	names=choosedSystems.getSelectionModel().getSelectedItem();
		 try {
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SetLossValue.fxml"));
	           Parent root1 = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setTitle("Tryb Użytkownika");
	           stage.setScene(new Scene(root1));
	           stage.show();
	    		}catch(Exception e) {
	    			
	    		}
		 

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		UserGUIController usrGui= new UserGUIController();
		ObservableList<String> data = FXCollections.observableArrayList();
		List<TISystemType> choosed = usrGui.choosedSystems;
		
		for(TISystemType system : choosed) {
			data.add(system.getName());
			System.out.println(system.getName());
		}
		
		choosedSystems.setItems(data);
		choosedSystems.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

}
