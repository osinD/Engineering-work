package Controllers.RiskController;

import java.util.ArrayList;
import java.util.List;

import Entity.Program.Risk;
import Entity.Program.RiskDanger;
import Entity.Program.RiskTISystem;

public class RiskController {

	public static List<Risk> riskList =new ArrayList<Risk>();
	
	public void createRisk(RiskTISystem riskTISystem, RiskDanger riskDanger){	
	Risk risk = new Risk();
	risk.setRiskTISystem(riskTISystem);
	risk.setRiskDanger(riskDanger);
	risk.setSafetyAttribute(riskTISystem.getSafetyAttribute());
	risk.setBeforeValue(riskTISystem.getLossValue()*riskDanger.getDangerLoss());
	risk.setAfterValue(riskTISystem.getLossValue()*riskDanger.getSecurityLoss());
	riskList.add(risk);
		
	}
}
