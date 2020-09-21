package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module 
{
	@Override
	public String toString() {
		return "Module [mId=" + mId + ", mname=" + mname + "]";
	}
	private int mId;
	private String mname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
