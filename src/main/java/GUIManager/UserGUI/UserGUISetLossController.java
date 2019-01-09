package GUIManager.UserGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.UserControllers.RiskAnalisisController;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserGUISetLossController implements Initializable{
	
    @FXML
    private Text textToSet;

    @FXML
    private TextField first;

    @FXML
    private TextField second;

    @FXML
    private TextField third;

    @FXML
    private Button confirm;

    @FXML
    void handleConfirm(ActionEvent event) {
    	UserGUIController usrGUI = new UserGUIController();
    	UserGUISystemLossController	usrGUILoss =	new UserGUISystemLossController();
    	List<TISystemType> systems = usrGUI.choosedSystems;
    	 
    	RiskAnalisisController riskAnalisisController = new RiskAnalisisController();
    	TISystemType tiSystemType = new TISystemType();
    	TISafetyAttribute tiSafetyAttribute ;
    	int value1 =0,value2 =0,value3 =0;
    	for(TISystemType system : systems) {
    		
    			if(system.getName().equals(usrGUILoss.names)) {
    				tiSystemType = system;
    				break;
    			}
    	}
    	try {
    	value1 = Integer.parseInt(first.getText());
    	value2 = Integer.parseInt(second.getText());
    	value3 = Integer.parseInt(third.getText());
    	if(value1<0 || value1>10 || value2<0 ||value2>10 ||value3<0 || value3>10) {
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FailAllert.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
        		}catch(Exception x) {
        			
        		}
    		
    	}else {
    	
    	tiSafetyAttribute = new TISafetyAttribute("poufność");
    	riskAnalisisController.chooseRiskTISystemElement(tiSystemType, tiSafetyAttribute, value1);
    	
    	tiSafetyAttribute = new TISafetyAttribute("integralność");
    	riskAnalisisController.chooseRiskTISystemElement(tiSystemType, tiSafetyAttribute, value2);
    	
    	tiSafetyAttribute = new TISafetyAttribute("dostępność");
    	riskAnalisisController.chooseRiskTISystemElement(tiSystemType, tiSafetyAttribute, value3);
    	}
    	}catch(NumberFormatException e){
    		
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FailAllert.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
        		}catch(Exception x) {
        			
        		}
    		Stage stage = (Stage) confirm.getScene().getWindow();
        	stage.close();
    	}
    	
    	
    	
    	Stage stage = (Stage) confirm.getScene().getWindow();
    	stage.close();
    	
    	}
    	
    	
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		UserGUISystemLossController	usrGUI =	new UserGUISystemLossController();
		textToSet.setText(usrGUI.names);
		first.setText("0");
		second.setText("0");
		third.setText("0");
	}

}
