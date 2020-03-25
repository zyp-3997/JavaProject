package manage.bean;

public class Set {
private int grade_id;
private String grade_name;
private int class_id;
private String class_name;
private int subject_id;
private String subject_name;
private int sort_id;
private String sort_name;
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
public int getSubject_id() {
	return subject_id;
}
public void setSubject_id(int subject_id) {
	this.subject_id = subject_id;
}
public String getSubject_name() {
	return subject_name;
}
public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}
public int getSort_id() {
	return sort_id;
}
public void setSort_id(int sort_id) {
	this.sort_id = sort_id;
}
public String getSort_name() {
	return sort_name;
}
public void setSort_name(String sort_name) {
	this.sort_name = sort_name;
}
@Override
public String toString() {
	return "Set [grade_id=" + grade_id + ", grade_name=" + grade_name
			+ ", class_id=" + class_id + ", class_name=" + class_name
			+ ", subject_id=" + subject_id + ", subject_name=" + subject_name
			+ ", sort_id=" + sort_id + ", sort_name=" + sort_name + "]";
}
}
