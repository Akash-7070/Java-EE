package mypack1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="std")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empid",nullable=false)
	public int getRollno()
	{
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public Student()
	{
		super();
	}
	@Column(name="name")
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Column(name="age")
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	@Column(name="address")
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String add)
	{
		this.address = add;
	}
	private int rollno;
	private String name;
	private int age;
	private String address;
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", age=" + age + ", add=" + address + "]";
	}

	
	
}
