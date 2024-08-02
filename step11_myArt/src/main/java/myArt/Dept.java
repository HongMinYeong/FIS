package myArt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "dept")
public class Dept {

	@Id
	@Column(name = "deptno")
	@NonNull
	private int deptno;

	@Column(name = "dname", length = 20)
	private String dname;

	@Column(name = "loc", length = 20)
	private String loc;

}
