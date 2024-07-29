/* desc dept;
 * 
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(4)
 DNAME                                              VARCHAR2(20)
 LOC                                                VARCHAR2(20)
 */
/* JPA 필수 적용 사항 
 * - DTO 는 view단에서도 사용 가능한 데이터 표현용 클래스 
 * - Model 단에서 생성해서 View에 전송 
 * 
 * - JPA 특화된 클래스 : Entity 클래스 
 * 	- RDBMS 자체의 table에 특화된 종속된 자바 클래스
 * 	- 구조 ㅣ table 과 동일 
 * 	- Entity 는 객체 생성등 db와 완전 밀착 
 * 		- setXxx() - update sql 문장과 동일하게 수행  
 * 	- Model 단의 DB연동 로직에서만 사용해야함 (엔티티) 
 * 
 *  - DTO = Entity ? 그럼 하나로 퉁치면 안되누 -> 안됨 
 *  - Entity 는 client 에서 open 할 수 가 없다. 
 * 
 */
package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Dept01DTO {
	private int deptno;
	private String dname;
	private String loc;

}
