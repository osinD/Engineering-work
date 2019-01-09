package Controllers.AdminControllers;

import java.util.List;


import javax.persistence.EntityManager;



import Operational.PersistenceManager;

import Entity.Database.DangerType;



public class DangerTypeController {

	private static EntityManager em;
	public void createElement(DangerType dangerType){
		
		em.getTransaction().begin();
		em.persist(dangerType);
		em.getTransaction().commit();
		
	}
	public void removeElement(DangerType dangerType){
		
		em.getTransaction().begin();
		em.remove(dangerType);
		em.getTransaction().commit();
		
	}
	public void modifyElement(DangerType dangerType) {
		
		DangerType databaseDangerType = em.find(DangerType.class, dangerType.getId());
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
	public List<DangerType> getAllElements(){
		
		List<DangerType> danger =em.createQuery("SELECT e FROM DangerType e").getResultList();
		
		return  danger;
			
	}
}
