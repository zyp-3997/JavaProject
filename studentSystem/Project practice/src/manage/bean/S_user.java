package manage.bean;

public class S_user {
private int user_id;
private String user_name;
private String password;
private int user_tel;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getUser_tel() {
	return user_tel;
}
public void setUser_tel(int user_tel) {
	this.user_tel = user_tel;
}
@Override
public String toString() {
	return "S_user [user_id=" + user_id + ", user_name=" + user_name
			+ ", password=" + password + ", user_tel=" + user_tel + "]";
}


}
