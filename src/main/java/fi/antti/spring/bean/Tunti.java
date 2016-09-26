package fi.antti.spring.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Tunti {
	
	private int id;
	
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")	
	private String work_date;
	
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String start_time;
	
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String end_time;
	
	@Size (min = 0, max = 255)
	private String info;

	public Tunti(int id, String work_date, String start_time, String end_time,
			String info) {
		super();
		this.id = id;
		this.work_date = work_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.info = info;
	}

	public Tunti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWork_date() {
		return work_date;
	}

	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Tunti [id=" + id + ", work_date=" + work_date + ", start_time="
				+ start_time + ", end_time=" + end_time + ", info=" + info
				+ "]";
	}
	
	

}
