package Controllers.AdminControllers;

import java.util.List;

import javax.persistence.EntityManager;

import Entity.Database.DangerType;
import Entity.Database.TISystemType;
import Operational.PersistenceManager;

public class TISystemController {

	private  EntityManager em ;

	public void createElement(TISystemType dangerType) {

		em.getTransaction().begin();
		em.persist(dangerType);
		em.getTransaction().commit();

	}

	public void removeElement(TISystemType dangerType) {

		em.getTransaction().begin();
		em.remove(dangerType);
		em.getTransaction().commit();

	}

	public void modifyElement(TISystemType dangerType) {

		TISystemType databaseDangerType = em.find(TISystemType.class, dangerType.getId());
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
	public List<TISystemType> getAllElements() {

		List<TISystemType> danger = em.createQuery("SELECT e FROM TISystemType e").getResultList();
		return danger;

	}
}
