package running;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.domain.entity.Customer;
import model.domain.entity.Dept;
import util.DBUtil;

public class RunningTest {
/* step04
   dept entity 개발 -> 설정 파일 등록 -> 모든 부서 검색해서 출력
   
   JPA만의 select 문장 
   - JPA 는 Entity 를 기반으로 RDBMS와 소통 
   - select Entity_멤버변수명 from entity 명 (table 명이 아님요)
   - select d from Dept d;
   - Dept entity 의 모든 내용 검색 (모든 멤버 변수)
     : rdbms) =  select * from dept;
     			select d.name from dept;
     			-> JPA) select d.name from Dept d;
     				d: 참조변수로 간주
     				d.name : d가 참조하는 객체의 name 멤버 변수명 호출 
    
*/
	@Test
	public void step04() {
		EntityManager em = DBUtil.getEntityManager();
		
		List<Dept> datas = em.createQuery("select d from Dept d",Dept.class).getResultList();
		System.out.println(datas.size() + "\n");
		
		// 출력 
		datas.forEach(System.out::println);
		
		// ? Dept table 모든 부서 번호의 합 
		int deptnoSum = em.createQuery("select d from Dept d",Dept.class).getResultStream().mapToInt(Dept::getDeptno).sum();
		System.out.println("\n**** 모든 부서 번호의 합 : " + deptnoSum + " ****\n");
		
		//? 부서 번호가 40 미만인 부서번호들만 합을 구하기 
		int deptnoSum2 = em.createQuery("select d from Dept d",Dept.class).getResultStream().mapToInt(Dept::getDeptno).filter(deptno -> deptno < 40).sum();
		System.out.println("\n**** 40 미만인 모든 부서 번호의 합 : " + deptnoSum2 + " ****\n");
		
		
		em.close();
	}

	/*
	 * step03 존재하는 customer 에 검색 -> 수정 -> 검색 -> 삭제
	 */
//	@Test
	public void step03() {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
//		em.persist(new Customer("id1", "연아", 50));
		Customer c = em.find(Customer.class, 4);// select
		System.out.println("\n*****1. 데이터 검색 : " + c + "*****\n");

		c = em.find(Customer.class, 4);// non - select
		System.out.println("\n*****2. 데이터 검색 : " + c + "*****\n");

		tx.begin();
		// update
		c.setAge(20); // update 준비( DB에 영구 적용 직전, 영속성 영역에 이미 반영)
		// delete
		em.remove(c); // delete 준비( DB에 영구 적용 직전, 영속성 영역에 이미 반영) - persistence context 의 내용도 삭제 의미

		// persistent context를 경우에 따라 clear 해야 할 경우 사용하는 메소드
//		em.clear(); // 하면 find실행함 clear안하면 null 반환 

		c = em.find(Customer.class, 4);
		System.out.println("\n*****3. 데이터 검색 : " + c + "*****\n"); // null 이지로오옹ㅇ

//		tx.commit(); // 실제 DB 에 반영 (update, delete 수행)
		em.close();
	}

	/*
	 * *******step 02 - 저장시도는 하나 commit 안함, 검색, 단 setXxx수정시도
	 */
//	@Test
	public void step02() {

		EntityManager em = DBUtil.getEntityManager();

		em.persist(new Customer("id2", "연아", 50));

		/*
		 * persistent context 라는 영속성(데이터) 저장소에 없다 -> db 에 select 해서 검색된 데이터인 entity 객체를
		 * persistent context 저장해 놓음
		 */
		// no = 2인 데이터 검색
//		Customer c1 = em.find(Customer.class, 2);
		/*
		 * persistent context 라는 영속성(데이터) 저장소에 1 pk의 Entity 가 있다 db에 select할 필요가 없다.
		 */
		Customer c1 = em.find(Customer.class, 1);

		System.out.println("데이터 검색 : " + c1); // 데이터 검색 : null

		c1.setName("박지오"); // update
		System.out.println("update 후? : " + c1);
		// 2 )호출안됨 ,1) 데이터 있으면 호출 됨 , commit 없으면 update안됨
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
