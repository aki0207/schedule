package model;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class UserSchedule {

	private String id;
	private String schedule;
	private String date;
	private String name;

	public UserSchedule() {

	}

	public UserSchedule(String id, String schedule, String date, String name) {

		this.id = id;
		this.schedule = schedule;
		this.date = date;
		this.name = name;

	}

	public String getId() {

		return id;

	}

	public String getSchedule() {

		return schedule;

	}

	public String getDate() {

		return date;

	}

	public String getName() {

		return name;

	}
	


}