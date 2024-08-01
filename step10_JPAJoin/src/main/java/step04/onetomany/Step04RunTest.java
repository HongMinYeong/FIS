package step04.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import util.DBUtil;

public class Step04RunTest {
	
	//step02 - 이미 존재하는 table과 데이터가 존재한다는 가정하에 실습 
	// persistence.xml -> none 으로 설정 후 진행
	//select로직 -> transaction필요 x
	
	@Test
	public void step02Test() {
		EntityManager em = null;
		
		try {
			em = DBUtil.getEntityManager();
			
			//step01 - team 검색
			/* 1 -> 정수 (int)
			 * 		:Team4의 PK 변수는 long 타입  
			 * int -> long 으로 자동 형변환  -> 기본 타입의 기질  
			 * Integer 와 Long객체타입 자동형 변환 불가 
			 * 1 -> new Integer(1) 로 autounboxing 당함;;;;;
			 * 문제는 Integer가 아닌 Long타입이 필요
			 * long값 표현시 L붙이기   
			 */
			
//			Team4 team = em.find(Team4.class,1); //?
			Team4 team = em.find(Team4.class,1L); 
			System.out.println("\n ***team 이름은 **** : "+team.getTeamName()); //축구1팀
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
				em = null;
			}
		}
		
	}


	//step01 - 데이터 저장만 
//	@Test
	public void step01Test() {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = DBUtil.getEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Team4 t1 = new Team4("축구1팀");
			em.persist(t1);
			em.persist(new Team4("배구1팀"));
			
			em.persist(new Member4("손흥민", t1));  
			em.persist(new Member4("김연경", t1));  
			em.persist(new Member4("박찬호", t1));  
			
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
