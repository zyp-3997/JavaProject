package manage.bean;

public class SetGrade {
	private int grade_id;
	private String grade_name;
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	@Override
	public String toString() {
		return "SetGrade [grade_id=" + grade_id + ", grade_name=" + grade_name
				+ "]";
	}
}
