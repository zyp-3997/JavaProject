package manage.bean;

public class Student {
private int student_id;
private int class_id;
private String student_name;
private String student_sex;
private int  student_age;
private String student_adress;
private int  student_tel;

public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getStudent_sex() {
	return student_sex;
}
public void setStudent_sex(String student_sex) {
	this.student_sex = student_sex;
}
public int getStudent_age() {
	return student_age;
}
public void setStudent_age(int student_age) {
	this.student_age = student_age;
}
public String getStudent_adress() {
	return student_adress;
}
public void setStudent_adress(String student_adress) {
	this.student_adress = student_adress;
}
public int getStudent_tel() {
	return student_tel;
}
public void setStudent_tel(int student_tel) {
	this.student_tel = student_tel;
}
@Override
public String toString() {
	return "Student [student_id=" + student_id + ", class_id=" + class_id
			+ ", student_name=" + student_name + ", student_sex=" + student_sex
			+ ", student_age=" + student_age + ", student_adress="
			+ student_adress + ", student_tel=" + student_tel + "]";
}


}
