package GUIManager.UserGUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Entity.Program.SecurityDanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserGUIShowDangerSecurity  implements Initializable {
	
	 	@FXML
	    private Text textToFill;

	    @FXML
	    private ListView<String> securityList;

	    @FXML
	    private Button okButton;

	    @FXML
	    void handleOKButton(ActionEvent event) {
	    	
	    	Stage stage = (Stage) okButton.getScene().getWindow();
        	stage.close();
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		UserGUIDangerSecurity usrDanger = new UserGUIDangerSecurity();
		List<SecurityDanger> securityDangerList = usrDanger.securityDangerList;
		SecurityDanger secDanger = securityDangerList.get(securityDangerList.size()-1);
		textToFill.setText(secDanger.getSecurity());
		ObservableList<String> data = FXCollections.observableArrayList();
		for(String str : secDanger.getSecurityList()) {
			data.add(str);
		}
		securityList.setItems(data);
	}

}
