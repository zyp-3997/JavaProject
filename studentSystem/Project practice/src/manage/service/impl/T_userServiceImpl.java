package manage.service.impl;

import manage.bean.T_user;
import manage.dao.impl.T_userDaoImpl;


public class T_userServiceImpl {
private T_userDaoImpl userDaoImpl=new T_userDaoImpl();
	
	public T_user login(String username,String password){
		return userDaoImpl.login(username, password);
	}
}
