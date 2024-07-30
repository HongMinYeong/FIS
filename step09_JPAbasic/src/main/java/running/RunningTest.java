package running;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Customer;
import util.DBUtil;

public class RunningTest {
	
	@Test
	public void step01() {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Customer("id1", "연아", 50));
		
		Customer c1 = em.find(Customer.class, 1);
		System.out.println(c1);
		//tx.commit(); 
	
		em.close();
	}
}


