package Entity.Program;

import java.util.List;

import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;

public class RiskDanger {

	private DangerType danger;
	private TISystemType systemType;
	private int dangerLoss;
	private int securityLoss;
	
	
	public RiskDanger(DangerType danger, TISystemType systemType,  int dangerLoss,
			int securityLoss) {
		super();
		this.danger = danger;
		this.systemType = systemType;
		
		this.dangerLoss = dangerLoss;
		this.securityLoss = securityLoss;
	}
	public DangerType getDanger() {
		return danger;
	}
	public void setDanger(DangerType danger) {
		this.danger = danger;
	}
	
	public TISystemType getSystemType() {
		return systemType;
	}
	public void setSystemType(TISystemType systemType) {
		this.systemType = systemType;
	}
	
	public int getDangerLoss() {
		return dangerLoss;
	}
	public void setDangerLoss(int dangerLoss) {
		this.dangerLoss = dangerLoss;
	}
	public int getSecurityLoss() {
		return securityLoss;
	}
	public void setSecurityLoss(int securityLoss) {
		this.securityLoss = securityLoss;
	}
	
	
}
