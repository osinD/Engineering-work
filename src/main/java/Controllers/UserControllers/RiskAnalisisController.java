package Controllers.UserControllers;

import java.util.ArrayList;
import java.util.List;

import Controllers.RiskController.RiskController;
import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;
import Entity.Program.Risk;
import Entity.Program.RiskDanger;
import Entity.Program.RiskTISystem;


public class RiskAnalisisController {

	
	private Risk risk;
	public static List<RiskTISystem> tiLossEffects = new ArrayList<RiskTISystem>();
	
	public void chooseRiskTISystemElement(TISystemType tiSystemType, TISafetyAttribute tiSafetyAttribute, int value){
		RiskTISystem lossTI = new RiskTISystem(tiSystemType,tiSafetyAttribute,value);
		tiLossEffects.add(lossTI);
	}
	
	public void chooseRiskDanger(TISystemType tiSystemType, DangerType dangerType, int dangerLoss, int securityLoss){
		System.out.println("1");
		RiskController riskController = new RiskController();
		System.out.println("2");
		RiskDanger riskDanger = new RiskDanger (dangerType,tiSystemType, dangerLoss, securityLoss);
		System.out.println("3");
		for(RiskTISystem val : tiLossEffects){
			System.out.println("4");
			if(val.getTiSystemType().equals(tiSystemType)){
				System.out.println("5");
				riskController.createRisk(val, riskDanger);
			}
		}	
	}
	
	public void analiseRisk() {
		RiskController riskController = new RiskController();
		riskController.createRisk(risk.getRiskTISystem(), risk.getRiskDanger());
		
	}
}
