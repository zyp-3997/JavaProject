package manage.bean;

public class SetClass {
	private int class_id;
	private int grade_id;
	private String class_name;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	@Override
	public String toString() {
		return "SetClass [class_id=" + class_id + ", grade_id=" + grade_id
				+ ", class_name=" + class_name + "]";
	}
}
