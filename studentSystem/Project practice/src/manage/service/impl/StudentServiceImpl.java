package manage.service.impl;

import java.util.List;

import manage.bean.Student;
import manage.dao.impl.StudentDaoImpl;


public class StudentServiceImpl  {
private StudentDaoImpl studentDaoImpl=new StudentDaoImpl();

public int addinfor(Student student) {
	return studentDaoImpl.addinfo(student);
}
public int updateinfor(Student student) {
	return studentDaoImpl.updateinfor(student);
}
public int deleteinfor(String id) {
	return studentDaoImpl.deleteinfor(id);
}

public List<Student> findinforAll() {
	return studentDaoImpl.findinforAll();
	
}

public Student findinforById(String id){
	return studentDaoImpl.findinforById(id);
}
}
