package manage.bean;

public class Teacher {
private int teacher_id;
private int class_id;
private String teacher_name;
private String teacher_sex;
private String teacher_major;
private String teacher_level;
private int teacher_tel;
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
public String getTeacher_name() {
	return teacher_name;
}
public void setTeacher_name(String teacher_name) {
	this.teacher_name = teacher_name;
}
public String getTeacher_sex() {
	return teacher_sex;
}
public void setTeacher_sex(String teacher_sex) {
	this.teacher_sex = teacher_sex;
}
public String getTeacher_major() {
	return teacher_major;
}
public void setTeacher_major(String teacher_major) {
	this.teacher_major = teacher_major;
}
public String getTeacher_level() {
	return teacher_level;
}
public void setTeacher_level(String teacher_level) {
	this.teacher_level = teacher_level;
}
public int getTeacher_tel() {
	return teacher_tel;
}
public void setTeacher_tel(int teacher_tel) {
	this.teacher_tel = teacher_tel;
}
@Override
public String toString() {
	return "Teacher [teacher_id=" + teacher_id + ", class_id=" + class_id
			+ ", teacher_name=" + teacher_name + ", teacher_sex=" + teacher_sex
			+ ", teacher_major=" + teacher_major + ", teacher_level="
			+ teacher_level + ", teacher_tel=" + teacher_tel + "]";
}

}
