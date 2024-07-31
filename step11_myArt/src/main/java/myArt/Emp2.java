package myArt;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenerationTime;

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

@Entity
public class Emp2 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp2_seq") 
	@Column(name = "empno")
	private int empno;

	@NonNull
	@Column(name = "ename", length = 20)
	private String ename;

	@Column(name = "job", length = 20)
	@NonNull
	private String job;

	@Column(name = "mgr")
	private int mgr;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "hiredate")
	@NonNull
	private LocalDate hiredate = LocalDate.now();
	
	@Column(name = "sal")
	private int sal;

	@Column(name = "comm")
	private int comm;

	@OneToOne
	@JoinColumn(name = "deptno")
	@NonNull
	private Dept2 deptno;

}
