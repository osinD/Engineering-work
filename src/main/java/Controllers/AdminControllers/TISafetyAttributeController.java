package Controllers.AdminControllers;

import java.util.List;

import javax.persistence.EntityManager;

import Entity.Database.DangerType;
import Entity.Database.TISafetyAttribute;
import Operational.PersistenceManager;

public class TISafetyAttributeController {

	private static EntityManager em;
	public void createElement(TISafetyAttribute dangerType){
		
		em.getTransaction().begin();
		em.persist(dangerType);
		em.getTransaction().commit();
		
	}
	public void removeElement(TISafetyAttribute dangerType){
		
		em.getTransaction().begin();
		em.remove(dangerType);
		em.getTransaction().commit();
		
	}
	public void modifyElement(TISafetyAttribute dangerType) {
		
		TISafetyAttribute databaseDangerType = em.find(TISafetyAttribute.class, dangerType.getId());
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
	public List<TISafetyAttribute> getAllElements(){
		
		List<TISafetyAttribute> danger =em.createQuery("SELECT e FROM TISafetyAttribute e").getResultList();
		
		return  danger;
			
	}
}
