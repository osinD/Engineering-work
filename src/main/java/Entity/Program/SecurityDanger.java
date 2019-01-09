package Entity.Program;

import java.util.List;

public class SecurityDanger {
	
	private String security;
	private List<String> securityList;
	
	
	
	public SecurityDanger() {
		super();
	}
	public SecurityDanger(String security, List<String> securityList) {
		super();
		this.security = security;
		this.securityList = securityList;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public List<String> getSecurityList() {
		return securityList;
	}
	public void setSecurityList(List<String> securityList) {
		this.securityList = securityList;
	}
	
	
	
}
