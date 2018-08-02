/**
 * 
 */
package model;

/**
 * @author brucewilliamwaynes
 *
 */
public class Appointment {

	private Doctor currentDoctor;
	private Patient currentPatient;
	private String lastAppointment;
	private String date;
	private String fromTime;
	private String toTime;
	
	public Appointment(){
		
		this.currentDoctor = new Doctor();
		
		this.currentPatient = new Patient();
		
		this.lastAppointment = "";
		
		this.date = "";
		
		this.fromTime = "";
		
		this.toTime = "";
		
	}
	
	/**
	 * @return the currentDoctor
	 */
	public Doctor getCurrentDoctor() {
		return currentDoctor;
	}
	/**
	 * @param currentDoctor the currentDoctor to set
	 */
	public void setCurrentDoctor(Doctor currentDoctor) {
		this.currentDoctor = currentDoctor;
	}
	/**
	 * @return the currentPatient
	 */
	public Patient getCurrentPatient() {
		return currentPatient;
	}
	/**
	 * @param currentPatient the currentPatient to set
	 */
	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	/**
	 * @return the lastAppointment
	 */
	public String getLastAppointment() {
		return lastAppointment;
	}

	/**
	 * @param lastAppointment the lastAppointment to set
	 */
	public void setLastAppointment(String lastAppointment) {
		this.lastAppointment = lastAppointment;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the fromTime
	 */
	public String getFromTime() {
		return fromTime;
	}

	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	/**
	 * @return the toTime
	 */
	public String getToTime() {
		return toTime;
	}

	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	
	
	
}
