package myArt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

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

	        // Insert
	        Emp emp = new Emp(1106,"hong"); 
	        em.persist(emp);

	        // Read
	        Emp e1 = em.find(Emp.class, emp.getEmpno()); 

	        System.out.println("\n***********************사원 추가 ********************\n");
	        if (e1 != null) {
	            System.out.println("  Member_Name  | " + e1.getEname());
	        } else {
	            System.out.println("Emp not found.");
	        }

	        // Update
	        Dept dept = em.find(Dept.class, 50);
	        if (e1 != null && dept != null) {
	            e1.setDeptno(dept);
	            System.out.println("\n*************************************************\n");
	            System.out.println("\n  empno가 1106인 사원의 부서는  | " + e1.getDeptno().getDeptno());
	        }

	        // Delete
	        List<Emp> datasE = em.createQuery("select e from Emp e", Emp.class).getResultList();
	        System.out.println("\n********************삭제 전 사원 명 ********************\n");
	        datasE.forEach(emp1 -> System.out.println(emp1.getEname()));
	        
	        System.out.println("\n***************" + e1.getEname() + " 삭제 하기  **************\n");
	        em.remove(e1); // 삭제 

	        // 삭제 후 확인
	        List<Emp> datas = em.createQuery("select e from Emp e", Emp.class).getResultList();
	        System.out.println("\n*************************************************\n");
	        datas.forEach(emp1 -> System.out.println(emp1.getEname()));

	        tx.commit();

	    } catch (Exception e) {
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}

}
