package step03.onetoonejoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor 
@Getter
@Setter
@ToString

@SequenceGenerator(name = "member3_seq", sequenceName = "member3_seq_id", 
				   allocationSize = 50, initialValue = 1)
//@Entity
public class Member3 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member3_seq") 
	@Column(name="member_id")
	private long memberId;
	
	@NonNull
	@Column(length = 20, nullable = false) //컬럼 사이즈 20byte
	private String name;
	/* ?
	 * create table Member3 (
	 * member_id number(19,0) not null,
	 *  name varchar2(20) not null,
	 *  team_id number(19,0), 
	 *  primary key (member_id)
	 *  );
	 *  
	 * 
	 * alter table Member3 add constraint  foreign key (team_id) references Team3;
	 */
	
	@NonNull
	@OneToOne // Memeber 하나는 Team 하나에 소속 
	@JoinColumn(name="team_id")  //Team3의 pk 변수에 선언된 매핑된 컬럼명
	private Team3 teamId;
	// long 타입에서 Team3이라는 참조객체 타입으로 변환   
	
}
