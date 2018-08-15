package model;

import java.util.ArrayList;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class UserSchedule {

	private ArrayList<String> id;
	private ArrayList<String> schedule;
	private ArrayList<String> date;
	private ArrayList<String> name;

	public UserSchedule() {

	}

	public UserSchedule(ArrayList<String> id, ArrayList<String> schedule, ArrayList<String> date, ArrayList<String> name) {

		this.id = id;
		this.schedule = schedule;
		this.date = date;
		this.name = name;

	}
	
	//管理のユーザー一覧で使う
	public UserSchedule(ArrayList<String> name) {
		
		this.name = name;
		
	}

	public String getId() {

		return id.get(0);

	}

	public String getSchedule(int index) {

		return schedule.get(index);

	}

	public String getDate(int index) {

		return date.get(index);

	}

	public String getName() {

		return name.get(0);

	}
	
	//管理のユーザー一覧で使う
	public String getName(int index) {
		
		return name.get(index);
	}
	
	public  int returnSize(UserSchedule user_schedule) {
		
		int length = user_schedule.name.size();
		return length;
		
	}
	

	


}