package myArt;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

@Table(name = "emp")
@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private int empno;

	@Column(name = "ename", length = 20)
	@NonNull
	private String ename;

	@Column(name = "job", length = 20)
	private String job;

	@Column(name = "mgr")
	private Integer mgr;

	@Column(name = "hiredate")
	private Date hiredate;

	@Column(name = "sal")
	private Integer sal;

	@Column(name = "comm")
	private Integer comm;

	@OneToOne
	@JoinColumn(name = "deptno")
	private Dept deptno;
	
    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

}
