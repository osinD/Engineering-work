package Entity.Program;

import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;

public class RiskTISystem {

	private TISystemType tiSystemType;
	private TISafetyAttribute safetyAttribute;
	private  int lossValue;
	
	
	public RiskTISystem(TISystemType tiSystemType, TISafetyAttribute safetyAttribute, int lossValue) {
		super();
		this.tiSystemType = tiSystemType;
		this.safetyAttribute = safetyAttribute;
		this.lossValue = lossValue;
	}
	public TISystemType getTiSystemType() {
		return tiSystemType;
	}
	public void setTiSystemType(TISystemType tiSystemType) {
		this.tiSystemType = tiSystemType;
	}
	public TISafetyAttribute getSafetyAttribute() {
		return safetyAttribute;
	}
	public void setSafetyAttribute(TISafetyAttribute safetyAttribute) {
		this.safetyAttribute = safetyAttribute;
	}
	public int getLossValue() {
		return lossValue;
	}
	public void setLossValue(int lossValue) {
		this.lossValue = lossValue;
	}
	
	
	
	
}
