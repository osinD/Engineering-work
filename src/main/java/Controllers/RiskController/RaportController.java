package Controllers.RiskController;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Controllers.AdminControllers.TISafetyAttributeController;
import Controllers.UserControllers.RiskAnalisisController;
import Entity.Database.DangerType;
import Entity.Database.TISafetyAttribute;
import Entity.Database.TISystemType;
import Entity.Program.Risk;
import Entity.Program.SecurityDanger;
import GUIManager.UserGUI.UserGUIController;
import GUIManager.UserGUI.UserGUIDangerSecurity;
import GUIManager.UserGUI.UserGUISystemDangerController;

public class RaportController {

	private List<DangerType> dangerTypeList;
	private TISafetyAttributeController safetyAttributeController;

	public void createNewHTMLFile(String filename) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename + ".html", "UTF-8");
			writer.println(
					"<!DOCTYPE html>\r\n" + "<html>\r\n" + "\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
							+ "    <title>Analiza ryzyka dla systemu teleinformatycznego</title>\r\n"
							+ "   <style> .dangers{\r\n" + 
							"    background-color: aquamarine;\r\n" + 
							"}\r\n" + 
							".ti_elements{\r\n" + 
							"    background-color: lightgreen;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							".loss-value{\r\n" + 
							"    background-color: lightgray;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							".susceptibility{\r\n" + 
							"    background-color: lightgray;\r\n" + 
							"}\r\n" + 
							".risks{\r\n" + 
							"    background-color: crimson;\r\n" + 
							"}</style>\r\n" + "</head>\r\n" + "\r\n"
							+ "<body>\r\n" + "\r\n" + "    <h1>Analiza Ryzyka dla systemu</h1>");

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	

	public void getDangerList(List<DangerType> dangerGUIList) {
		dangerTypeList = dangerGUIList;
	}

	public void lossValues(List<Risk> riskListForSystemType, int counter, BufferedWriter out) throws IOException {
		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangerTypeList = usrGUIDangerCtrl.choosedDangers;
		for (DangerType danger : dangerTypeList) {
			if (danger.equals(riskListForSystemType.get(counter).getRiskDanger().getDanger())) {
				out.write("<td>" + riskListForSystemType.get(counter).getRiskTISystem().getLossValue() + "</td>");
				counter++;
			} else {
				out.write("<td>0</td>\r\n");
			}
		}
	}

	public List<Integer> dangerValues(List<Risk> riskListForSystemType, int counter, BufferedWriter out) throws IOException {
		
		List<Integer> riskValues = new ArrayList<Integer>();
		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangerTypeList = usrGUIDangerCtrl.choosedDangers;
		for (DangerType danger : dangerTypeList) {
			if (danger.equals(riskListForSystemType.get(counter).getRiskDanger().getDanger())) {
				out.write("<td>" + riskListForSystemType.get(counter).getRiskDanger().getDangerLoss() + "</td>");
				riskValues.add(riskListForSystemType.get(counter).getBeforeValue());
				counter++;
			} else {
				riskValues.add(0);
				out.write("<td>0</td>\r\n");
			}
		}
		return riskValues;
	}

	public void beforeSecurityValues(List<Risk> riskListForSystemType, int counter, BufferedWriter out)
			throws IOException {
		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		List<DangerType> dangerTypeList = usrGUIDangerCtrl.choosedDangers;
		for (DangerType danger : dangerTypeList) {
			if (danger.equals(riskListForSystemType.get(counter).getRiskDanger().getDanger())) {
				out.write("<td>" + riskListForSystemType.get(counter).getBeforeValue() + "</td>");
				counter++;
			} else {
				out.write("<td>0</td>\r\n");
			}
		}
	}

	
	
	public void createInsecuredRiskRaport(String filename) {

		UserGUISystemDangerController usrGUIDangerCtrl = new UserGUISystemDangerController();
		RiskAnalisisController riskAnalisisController = new RiskAnalisisController();
		RiskController riskController = new RiskController();
		List<DangerType> dangerTypeList = usrGUIDangerCtrl.choosedDangers;
		List<TISafetyAttribute> attributesList = new ArrayList<TISafetyAttribute>();
		attributesList.add(new TISafetyAttribute("poufność"));
		attributesList.add(new TISafetyAttribute("integralność"));
		attributesList.add(new TISafetyAttribute("dostępność"));
		List<Risk> riskList = riskController.riskList;
		List<Risk> riskListForAttributes = new ArrayList<Risk>();
		UserGUIController usrGui= new UserGUIController();
		List<TISystemType> choosedSystems = usrGui.choosedSystems;
		List<Risk> riskListForSystemType = new ArrayList<Risk>();
		List<Integer> dangerElementValues = new ArrayList<Integer>();
		List<Integer> riskElementValues = new ArrayList<Integer>();
		
		int counter = 0;
		int lossval = 0, riskval = 0, flag =0;

		createNewHTMLFile(filename);
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(filename + ".html", true);
			out = new BufferedWriter(fstream);
			out.write("<h2 class=\"susceptibility\">\r\n PRZED WPROWADZENIEM ZABEZPIECZEŃ</h2>\r\n");
			for(TISafetyAttribute attribute : attributesList) {
				out.write("<h2>" + attribute.getName() + "</h2>\r\n");
				out.write("<table>\r\n" + "<tr class=\"dangers\">\r\n" + "<th>Zasoby</th>\r\n" + "<th>Szacowanie</th>");
				for (DangerType danger : dangerTypeList) {
					out.write("<th>" + danger.getName() + "</th>\r\n");
				}
				out.write("</tr>\r\n");

				riskListForAttributes = getElementsBySafetyAttribute(riskList, attribute.getName());
				for(TISystemType tiSystem : choosedSystems) {
					riskListForSystemType = getElementsForSystemType(riskListForAttributes, tiSystem.getName());
					out.write("<tr>\r\n" + "<td rowspan=\"4\"  class=\"ti_elements\">"+tiSystem.getName() + "</td>\r\n" + "</tr>"+ "<tr class=\"loss-value\">\r\n" + "<td>Skutki</td>");
					dangerElementValues = new ArrayList<Integer>();
					riskElementValues = new ArrayList<Integer>();
					flag = 0;
					for (DangerType danger : dangerTypeList) {
						flag =0;
						for(Risk risk : riskListForSystemType) {
							if(risk.getRiskDanger().getDanger().getName().equals(danger.getName())){
								dangerElementValues.add(risk.getRiskDanger().getDangerLoss());
								riskElementValues.add(risk.getBeforeValue());
								flag =1;
							}
						}
						if(flag == 0) {
							dangerElementValues.add(0);
							riskElementValues.add(0);
						}
						
					}
					for (DangerType danger : dangerTypeList) {
						out.write("<td>" + riskListForSystemType.get(0).getRiskTISystem().getLossValue() + "</td>");
					}
					out.write(" </tr>\r\n" + "<tr class=\"susceptibility\">\r\n" + "<td>Podatność</td>\r\n");
					for(Integer i : dangerElementValues ){
						out.write("<td>"+i+"</td>\r\n");
					}
					out.write("</tr>\r\n" + "<tr class=\"risks\">\r\n" + "<td>Ryzyko</td>");
					for(Integer i : riskElementValues) {
						out.write("<td>"+i+"</td>\r\n");
					}
					out.write("</tr>\r\n");
				}
				out.write("</table>\r\n");
			}
			/////////////////XXXXXXXXXXXXXXXXXXDDDDDDDDDDDDDDDDDDDDDDDDDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXD
			out.write("<h2 class=\"susceptibility\">\r\n PO WPROWADZENIU ZABEZPIECZEŃ</h2>\r\n");
			for(TISafetyAttribute attribute : attributesList) {
				out.write("<h2>" + attribute.getName() + "</h2>\r\n");
				out.write("<table>\r\n" + "<tr class=\"dangers\">\r\n" + "<th>Zasoby</th>\r\n" + "<th>Szacowanie</th>");
				for (DangerType danger : dangerTypeList) {
					out.write("<th>" + danger.getName() + "</th>\r\n");
				}
				out.write("</tr>\r\n");

				riskListForAttributes = getElementsBySafetyAttribute(riskList, attribute.getName());
				for(TISystemType tiSystem : choosedSystems) {
					riskListForSystemType = getElementsForSystemType(riskListForAttributes, tiSystem.getName());
					out.write("<tr>\r\n" + "<td rowspan=\"4\"  class=\"ti_elements\">"+tiSystem.getName() + "</td>\r\n" + "</tr>"+ "<tr class=\"loss-value\">\r\n" + "<td>Skutki</td>");
					dangerElementValues = new ArrayList<Integer>();
					riskElementValues = new ArrayList<Integer>();
					flag = 0;
					for (DangerType danger : dangerTypeList) {
						flag =0;
						for(Risk risk : riskListForSystemType) {
							if(risk.getRiskDanger().getDanger().getName().equals(danger.getName())){
								dangerElementValues.add(risk.getRiskDanger().getSecurityLoss());
								riskElementValues.add(risk.getAfterValue());
								flag =1;
							}
						}
						if(flag == 0) {
							dangerElementValues.add(0);
							riskElementValues.add(0);
						}
						
					}
					for (DangerType danger : dangerTypeList) {
						out.write("<td>" + riskListForSystemType.get(0).getRiskTISystem().getLossValue() + "</td>");
					}
					out.write(" </tr>\r\n" + "<tr class=\"susceptibility\">\r\n" + "<td>Podatność</td>\r\n");
					for(Integer i : dangerElementValues ){
						out.write("<td>"+i+"</td>\r\n");
					}
					out.write("</tr>\r\n" + "<tr class=\"risks\">\r\n" + "<td>Ryzyko</td>");
					for(Integer i : riskElementValues) {
						out.write("<td>"+i+"</td>\r\n");
					}
					out.write("</tr>\r\n");
				}
				out.write("</table>\r\n");
			}
			
			/////////////////XXXXXXXXXXXXXXXXXXDDDDDDDDDDDDDDDDDDDDDDDDDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXDXD
			out.write("<h2 class=\"susceptibility\">\r\n WPROWADZONE ZABEZPIECZENIA W STOSUNKU DO ZAGROŻEŃ</h2>\r\n");
			UserGUIDangerSecurity usrGUIDangerSecurity = new UserGUIDangerSecurity();
			List<SecurityDanger> securityDangerList = usrGUIDangerSecurity.securityDangerList;
			if(!securityDangerList.isEmpty()){
				for(SecurityDanger item : securityDangerList) {
					out.write("<h4>" +item.getSecurity()+ "</h4>\r\n");
					out.write("<ul>");
					for(String s : item.getSecurityList()) {
						out.write("<li>"+s+"</li>\r\n");
					}
					out.write("</ul>\r\n");
				}
				
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

		finally {
			if (out != null) {
				try {
					out.write("</body>\r\n" + "\r\n" + "</html>");
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
	
	
	public List<Risk> getElementsBySafetyAttribute(List<Risk> risks, String attributeName){
		
		List<Risk> returnValues = new ArrayList<Risk>();
		for(Risk risk: risks) {
			if(risk.getRiskTISystem().getSafetyAttribute().getName().equals(attributeName)) {
				returnValues.add(risk);
			}
		}
		return returnValues;
	}
	
	public List<Risk> getElementsForSystemType(List<Risk> risks, String systemName){
		List<Risk> returnValues = new ArrayList<Risk>();
		for(Risk risk: risks) {
			if(risk.getRiskTISystem().getTiSystemType().getName().equals(systemName)) {
				returnValues.add(risk);
			}
		}
		return returnValues;
	}

	public List<Risk> getRiskForOneElement(TISystemType system) {
		List<Risk> allRisks = RiskController.riskList;
		List<Risk> risks = new ArrayList<Risk>();
		for (Risk val : allRisks) {
			if (val.getRiskTISystem().getTiSystemType().getName().equals(system.getName())) {
				risks.add(val);
			}
		}
		return risks;
	}

}
