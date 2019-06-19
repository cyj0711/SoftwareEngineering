
public class ItemBean {

	int id;
	String name;
	int cost;
	int count;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void showInfo() {
		System.out.printf("id : %d / name : %s / cost : %d / count : %d\n",id,name,cost,count);
	}
}
