package Operational;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Controllers.AdminControllers.DangerTypeController;
import Controllers.AdminControllers.TISystemController;
import Entity.Database.DangerType;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		 	Parent root = FXMLLoader.load((getClass().getResource("StartAplication.fxml")));
	        
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		
		TISystemController systemController =new TISystemController();
		DangerTypeController dangercontroller = new DangerTypeController();
		TISafetyAttribute tiSafetyAttribute = new TISafetyAttribute();
		systemController.startAddingEntity();
		//TISystemType system = new TISystemType("Stacja Robocza");
		dangercontroller.startAddingEntity();
		systemController.startAddingEntity();
		List<TISystemType> systemTypes = systemController.getAllElements();
		//systemController.endAddingEntity();
		//List<TISafetyAttribute> attributeList = new ArrayList<TISafetyAttribute>();
		//attributeList.add(new TISafetyAttribute("poufność"));
	   // attributeList.add(new TISafetyAttribute("dostępność"));
		//attributeList.add(new TISafetyAttribute("integralność"));
		//system.setSafetyAttribute(attributeList);
		//systemController.createElement(system);
		
		
		launch(args);
		dangercontroller.endAddingEntity();
	}
}
