package Entity.Program;

import Entity.Database.TISafetyAttribute;

public class Risk {
	
	private RiskTISystem riskTISystem;
	private RiskDanger riskDanger;
	private TISafetyAttribute safetyAttribute;
	private int beforeValue;
	private int afterValue;
	
	
	
	public Risk() {
		super();
	}
	public Risk(RiskTISystem riskTISystem, RiskDanger riskDanger, TISafetyAttribute safetyAttribute, int beforeValue,int afterValue) {
		super();
		this.riskTISystem = riskTISystem;
		this.riskDanger = riskDanger;
		this.safetyAttribute = safetyAttribute;
		this.beforeValue = beforeValue;
		this.afterValue=afterValue;
	}
	public RiskTISystem getRiskTISystem() {
		return riskTISystem;
	}
	public void setRiskTISystem(RiskTISystem riskTISystem) {
		this.riskTISystem = riskTISystem;
	}
	public RiskDanger getRiskDanger() {
		return riskDanger;
	}
	public void setRiskDanger(RiskDanger riskDanger) {
		this.riskDanger = riskDanger;
	}
	public TISafetyAttribute getSafetyAttribute() {
		return safetyAttribute;
	}
	public void setSafetyAttribute(TISafetyAttribute safetyAttribute) {
		this.safetyAttribute = safetyAttribute;
	}
	public int getBeforeValue() {
		return beforeValue;
	}
	public void setBeforeValue(int beforeValue) {
		this.beforeValue = beforeValue;
	}
	public int getAfterValue() {
		return afterValue;
	}
	public void setAfterValue(int afterValue) {
		this.afterValue = afterValue;
	}
	
	
	
	

}
