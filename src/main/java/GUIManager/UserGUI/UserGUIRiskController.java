package GUIManager.UserGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Controllers.RiskController.RaportController;
import Controllers.RiskController.RiskController;
import Controllers.UserControllers.RiskAnalisisController;
import Entity.Database.DangerType;
import Entity.Database.TISystemType;
import Entity.Program.Risk;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserGUIRiskController implements Initializable{
	
	public static TISystemType tiSystemType;
	public static DangerType dangerType;
	public static int dangerLoss;
	public static int securityLoss;
	public static  RiskAnalisisController riskAnalisisController;
	public RiskController  riskController;
	public UserGUIController usrGUIController;
	
	@FXML
    private ListView<String> listTISystem;

    @FXML
    private ListView<String> listDangers;

    @FXML
    private TextField beforeSecuroty;

    @FXML
    private TextField afterSecurity;

    @FXML
    private Button tiStstemButton;

    @FXML
    private Button addToRisk;

    @FXML
    private Button createRaport;

    @FXML
    void handleAddToRisk(ActionEvent event) {
    	ObservableList<String> names;
    	names=listDangers.getSelectionModel().getSelectedItems();
    	String val = names.get(0);
    	UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangers=usrGUIDangerCtrl.choosedDangers;
		for(DangerType danger : dangers) {
			if(val.equals(danger.getName())) {
				dangerType = danger;
				System.out.println(danger.getName());
				break;
			}
		}
		try {
		dangerLoss = Integer.parseInt(beforeSecuroty.getText());
		securityLoss = Integer.parseInt(afterSecurity.getText());
		if(dangerLoss<0 || dangerLoss>10 || securityLoss<0 ||securityLoss>10) {
			try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FailAllert.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
        		}catch(Exception x) {
        			
        		}
			
		}else{
		
			List<Risk> allRisks = RiskController.riskList;
			int err =0;
			for(Risk r : allRisks) {
				if(r.getRiskTISystem().getTiSystemType().getName().equals(tiSystemType.getName())&&r.getRiskDanger().getDanger().equals(dangerType)) {
					err =1;
				}
			}
			if(err == 1) {
				try {
	        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlreadyExist.fxml"));
	               Parent root1 = (Parent) fxmlLoader.load();
	               Stage stage = new Stage();
	               stage.setTitle("Tryb Użytkownika");
	               stage.setScene(new Scene(root1));
	               stage.show();
	        		}catch(Exception x) {
	        			
	        		}
			}else {
			System.out.println(tiSystemType.getName()+beforeSecuroty.getText()+afterSecurity.getText());
			riskAnalisisController = new RiskAnalisisController();
			riskAnalisisController.chooseRiskDanger(tiSystemType, dangerType, dangerLoss, securityLoss);
			}
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
		}
    }

    @FXML
    void handleCreateRaport(ActionEvent event) {
    	List<Risk> allRisks = RiskController.riskList;
    	List<TISystemType> choosedSystems =UserGUIController.choosedSystems;
    	TISystemType newSystem = new TISystemType() ;
    	int flag =0, check=0;
    	for( TISystemType system : choosedSystems) {
    		flag =0;
    		for(Risk i : allRisks) {
    			if(system.getName().equals(i.getRiskTISystem().getTiSystemType().getName())) {
    				flag=1;
    			}
    		}
    		if(flag ==0) {
    			check =1;
    		}
    	}
    	if(check == 0) {
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenerateRaport.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
               Stage stage1 = (Stage) createRaport.getScene().getWindow();
           	   stage1.close();
        		}catch(Exception x) {
        			
        		}
    		//RaportController raport = new RaportController();
        	//raport.createInsecuredRiskRaport("Raport");
    	}else {
    		try {
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DangerTISystemAlert.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setTitle("Tryb Użytkownika");
               stage.setScene(new Scene(root1));
               stage.show();
        		}catch(Exception x) {
        			
        		}
    	}
    	
    	
    }

    @FXML
    void handleTIStstemButton(ActionEvent event) {
    	
    	ObservableList<String> names;
    	names=listTISystem.getSelectionModel().getSelectedItems();
    	String val = names.get(0);
    	UserGUIController usrGui= new UserGUIController();
    	List<TISystemType> choosed = usrGui.choosedSystems;
		for(TISystemType sys : choosed) {
			
			if(val.equals(sys.getName())) {
				System.out.println("XDXDXDXDXDXDXD    "+sys.getName());
				tiSystemType = sys;
				break;
			}
		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		beforeSecuroty.setText("0");
		afterSecurity.setText("0");
		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangers=usrGUIDangerCtrl.choosedDangers;
		ObservableList<String> data = FXCollections.observableArrayList();
		for(DangerType danger : dangers) {
			data.add(danger.getName());
		}
		listDangers.setItems(data);
		
		
		ObservableList<String> data1 = FXCollections.observableArrayList();
		UserGUIController usrGui= new UserGUIController();
		List<TISystemType> choosed = usrGui.choosedSystems;
		for(TISystemType sys : choosed) {
			data1.add(sys.getName());
		}
		listTISystem.setItems(data1);
		
		listTISystem.setOnMousePressed(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	tiStstemButton.setStyle("-fx-background-color:  #8bc52d");
	        }
	    });
		listDangers.setOnMousePressed(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) {
	        	addToRisk.setStyle("-fx-background-color:  #8bc52d");
	        }
	    });
		
	}

}
