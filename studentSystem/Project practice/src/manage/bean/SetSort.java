package manage.bean;

public class SetSort {
	private int sort_id;
	private String sort_name;
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	@Override
	public String toString() {
		return "SetSort [sort_id=" + sort_id + ", sort_name=" + sort_name + "]";
	}
}
