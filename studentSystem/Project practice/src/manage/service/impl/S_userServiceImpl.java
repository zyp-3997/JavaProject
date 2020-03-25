package manage.service.impl;

import manage.bean.S_user;
import manage.dao.impl.S_userDaoImpl;

public class S_userServiceImpl {
	private S_userDaoImpl userDaoImpl=new S_userDaoImpl();
	
	public S_user login(String username,String password){
		return userDaoImpl.login(username, password);
	}
	

}
