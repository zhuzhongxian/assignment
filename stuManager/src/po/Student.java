package po;
/***
 * Bean Student
 *  * @author Zeno
 *
 */
public class Student {
	private Integer id;
	private String stuname;
	private String password;
	private Double score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuname=" + stuname + ", password=" + password + ", score=" + score + "]";
	}
	 @Override
	 /***
	  * ÷ÿ–¥equals∑Ω∑®
	  */
	 public boolean equals(Object o) {
		  if (null == o)
		      return false;
		  Student student = (Student) o;
		    if (this.stuname.equals(student.getStuname())) {
		       if(this.password.equals(student.getPassword())) {
		          return true;
		     }
		        }
		        return false;
		    }

}
