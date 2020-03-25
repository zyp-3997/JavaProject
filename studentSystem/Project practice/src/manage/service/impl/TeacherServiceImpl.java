package manage.service.impl;

import java.util.List;

import manage.bean.Teacher;
import manage.dao.impl.TeacherDaoImpl;


public class TeacherServiceImpl {
private TeacherDaoImpl teacherDaoImpl=new TeacherDaoImpl();;
public int addinfor(Teacher teacher) {
	return teacherDaoImpl.addinfoinfor(teacher);
}
public int updateinfor(Teacher teacher) {
	return teacherDaoImpl.updateinfor(teacher);
}
public int deleteinfor(String id) {
	return teacherDaoImpl.deleteinfor(id);
}

public List<Teacher> findinforAll() {
	return teacherDaoImpl.findinforAll();
	
}

public Teacher findinforById(String id){
	return teacherDaoImpl.findinforById(id);
}
}
