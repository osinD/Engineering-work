package Controllers.AdminControllers;

import java.util.List;

import javax.persistence.EntityManager;

import Entity.Database.DangerType;
import Entity.Database.SecurityType;
import Operational.PersistenceManager;

public class SecurityTypeController {

	private static EntityManager em;
	public void createElement(SecurityType dangerType){
		
		em.getTransaction().begin();
		em.persist(dangerType);
		em.getTransaction().commit();
		
	}
	public void removeElement(SecurityType dangerType){
		
		em.getTransaction().begin();
		em.remove(dangerType);
		em.getTransaction().commit();
		
	}
	public void modifyElement(SecurityType dangerType) {
		
		SecurityType databaseDangerType = em.find(SecurityType.class, dangerType.getId());
		em.getTransaction().begin();
		databaseDangerType.setName(dangerType.getName());
		em.getTransaction().commit();	
		
	}
	
	public void startAddingEntity() {
		em = PersistenceManager.INSTANCE.getEntityManager();
		
	}
	
	public void endAddingEntity(){
		em.close();
		PersistenceManager.INSTANCE.close();
	}
	public List<SecurityType> getAllElements(){
		
		List<SecurityType> danger =em.createQuery("SELECT e FROM SecurityType e").getResultList();
		
		return  danger;
			
	}
}
