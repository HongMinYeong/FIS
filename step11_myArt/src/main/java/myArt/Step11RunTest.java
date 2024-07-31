package myArt;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import myArt.Emp2;
import util.DBUtil;

public class Step11RunTest {

	@Test
	public void RunTest() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Dept2 t1 = new Dept2(10,"ACCOUNTING","NEW YORK");
			em.persist(t1);
			Dept2 t2 = new Dept2(20,"RESEARCH","DALLAS");
			em.persist(t2);
			Dept2 t3 = new Dept2(30,"SALES","CHICAGO");
			em.persist(t3);
			Dept2 t4 = new Dept2(40,"OPERATIONS","BOSTON");
			em.persist(t4);
			
			
			em.persist(new Emp2("hong",t1.getDname(),t1));  
			em.persist(new Emp2("hongg",t2.getDname(),t2));  
			em.persist(new Emp2("honggg",t3.getDname(),t3));  
			em.persist(new Emp2("hongggg",t4.getDname(),t4));  
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
		
	}
}
