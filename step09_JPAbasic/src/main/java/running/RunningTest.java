package running;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Customer;
import util.DBUtil;

public class RunningTest {

/*	*******step 02 - 저장시도는 하나 commit 안함, 검색, 단 setXxx수정시도 
 */
	@Test
	public void step02() {
		
		EntityManager em = DBUtil.getEntityManager();
		
		em.persist(new Customer("id2", "연아", 50)); 
		
		/* persistent context 라는 영속성(데이터) 저장소에 없다
		 * -> 	db 에 select 해서 검색된 데이터인 entity 객체를 
		 * 		persistent context 저장해 놓음
		 */
		//no = 2인 데이터 검색 
//		Customer c1 = em.find(Customer.class, 2);
		/* persistent context 라는 영속성(데이터) 저장소에 1 pk의
		 * Entity 가 있다 db에 select할 필요가 없다. 
		 */
		Customer c1 = em.find(Customer.class, 1);
		
		System.out.println("데이터 검색 : " + c1);  //데이터 검색 : null
		
		c1.setName("박지오"); // update
		System.out.println("update 후? : " + c1); 
		//2 )호출안됨 ,1) 데이터 있으면 호출 됨 , commit 없으면 update안됨  
//		update 후? : Customer(no=1, id=id1, name=박지오, age=50)
		
		
		em.close();
	}
	
//	*******step 01 - table 생성, data insert, select, update
//	@Test
	public void step01() {
		
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
//		em.persist(new Customer("id1", "연아", 50)); 
		// no가 1로 저장되어 있음 
		
		Customer c1 = em.find(Customer.class, 1);
		System.out.println(c1); 
		// Customer(no=1, id=id1, name=연아, age=50)
		
		c1.setName("유다연"); // update
		tx.commit(); 
	
		em.close();
	}
}


