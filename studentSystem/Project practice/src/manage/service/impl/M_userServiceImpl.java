package manage.service.impl;

import manage.bean.M_user;
import manage.dao.impl.M_userDaoImlp;


public class M_userServiceImpl {
private M_userDaoImlp userDaoImpl=new M_userDaoImlp();
	
	public M_user login(String username,String password){
		return userDaoImpl.login(username, password);
	}
}
