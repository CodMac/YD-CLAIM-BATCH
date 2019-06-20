package zqit.claim.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "DEMO")
public class Demo {

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "AGE")
	private String age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
