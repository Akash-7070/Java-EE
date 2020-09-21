package mypack;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Course 
{
	private int cId;
	private String cname;	
	Set<Module> set;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_ID")
	public int getcId() {
		return cId;
	}
	
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid", referencedColumnName="COURSE_ID")
	public Set<Module> getSet() {
		return set;
	}
	public void setSet(Set<Module> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cname=" + cname + ", set=" + set + "]";
	} 
}
