package extras;

import java.io.Serializable;

public class Time implements Serializable {

	public String hours;
	public String minutes;
	
	
	public Time(String hours, String minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	
	public String toString() {
		return this.hours+":"+this.minutes;
	}
	
}
