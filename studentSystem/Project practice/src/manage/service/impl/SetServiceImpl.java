package manage.service.impl;


import java.util.List;

import manage.bean.SetClass;
import manage.bean.SetGrade;
import manage.bean.SetSort;
import manage.bean.SetSubject;
import manage.dao.impl.SetDaoImpl;

public class SetServiceImpl{
private SetDaoImpl setDao=new SetDaoImpl();
	public int insertgrade(SetGrade setGrade) {
		return setDao.insertgrade(setGrade);
	}

	public int deletegrade(String id) {
		return setDao.deletegrade(id);
	}

	public List<SetGrade> findgrade() {
		return setDao.findgrade();
	}
	public int insertclass(SetClass setClass) {
		return setDao.insertclass(setClass);
	}

	public int deleteclass(String id) {
		return setDao.deleteclass(id);
	}

	public List<SetClass> findClasses() {
		return setDao.findClasses();
	}
	public int insertsubject(SetSubject setSubject) {
		return setDao.insertsubject(setSubject);
	}

	public int deletesubject(String id) {
		return setDao.deletesubject(id);
	}

	public List<SetSubject> findsubject() {
		return setDao.findsubject();
	}
	public int insertsort(SetSort setSort) {
		return setDao.insertsort(setSort);
	}

	public int deletesort(String id) {
		return setDao.deletesort(id);
	}

	public List<SetSort> findsort() {
		return setDao.findsort();
	}
	
}
