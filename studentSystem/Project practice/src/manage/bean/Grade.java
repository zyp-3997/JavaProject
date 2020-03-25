package manage.bean;

public class Grade {
private int student_id;
private String student_names;
private String class_names;
private int chinese;
private int math;
private int english;
private int physics;
private int chemistry;
private int biolog;
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_names() {
	return student_names;
}
public void setStudent_names(String student_names) {
	this.student_names = student_names;
}
public int getChinese() {
	return chinese;
}
public void setChinese(int chinese) {
	this.chinese = chinese;
}
public int getMath() {
	return math;
}
public void setMath(int math) {
	this.math = math;
}
public int getEnglish() {
	return english;
}
public void setEnglish(int english) {
	this.english = english;
}
public int getPhysics() {
	return physics;
}
public void setPhysics(int physics) {
	this.physics = physics;
}
public int getChemistry() {
	return chemistry;
}
public void setChemistry(int chemistry) {
	this.chemistry = chemistry;
}
public int getBiolog() {
	return biolog;
}
public void setBiolog(int biolog) {
	this.biolog = biolog;
}
public String getClass_names() {
	return class_names;
}
public void setClass_names(String class_names) {
	this.class_names = class_names;
}
@Override
public String toString() {
	return "Grade [student_id=" + student_id + ", student_names="
			+ student_names + ", class_names=" + class_names + ", chinese="
			+ chinese + ", math=" + math + ", english=" + english
			+ ", physics=" + physics + ", chemistry=" + chemistry + ", biolog="
			+ biolog + "]";
}

}
