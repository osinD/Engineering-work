package GUIManager.UserGUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Controllers.RiskController.RaportController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class UserGUIGenerateRaportController implements Initializable{
	
	@FXML
    private Button tryButton;

    @FXML
    private Text textField;

    @FXML
    private Button approve;
    @FXML
    private AnchorPane anchorid;
    @FXML
    private TextField textField2;


    @FXML
    void handleApprove(ActionEvent event) {

    	RaportController raport = new RaportController();
    	raport.createInsecuredRiskRaport(textField.getText()+textField2.getText());
    	 Stage stage1 = (Stage) approve.getScene().getWindow();
     	   stage1.close();
    }

    @FXML
    void handleTryAgin(ActionEvent event) {
    	final DirectoryChooser dirchooser = new DirectoryChooser();
    	Stage stage = (Stage) anchorid.getScene().getWindow();
    	File file = dirchooser.showDialog(stage);
    	if(file != null) {
    		System.out.println(file.getAbsolutePath());
    		textField.setText(file.getAbsolutePath()+"\\");
    	
    	}

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
