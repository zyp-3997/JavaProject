package manage.service.impl;

import java.util.List;

import manage.bean.Grade;
import manage.dao.impl.GradeDaoImpl;


public class GradeServiceImpl  {
 private GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();
 public int addgrade(Grade grade) {
	return gradeDaoImpl.addgrade(grade);
	 
 }
 
public int updategrade(Grade grade) {
	return gradeDaoImpl.updategrade(grade);
}

public int deletegrade(String id) {
	return gradeDaoImpl.deletegrade(id);
}

public List<Grade> findgradeAll() {
	return gradeDaoImpl.findgradeAll();
}

public Grade findgradeById(String id){
	return gradeDaoImpl.findgradeById(id);
}

public List<Grade> findgradeByname(String name) {
	return gradeDaoImpl.findgradeByname(name);
}
public List<Grade> findgradeByClass(String name) {
	return gradeDaoImpl.findgradeByClass(name);
}
}
