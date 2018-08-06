/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author brucewilliamwaynes
 *
 */
public class Clinique {

	private String name;
	private ArrayList<Doctor> doctorList;
	private ArrayList<Patient> patientList;
	private HashMap<String , ArrayList<Doctor>> specialList;
	private ArrayList<Appointment> queueOfAppointments;
	
	public Clinique(){
		
		this.name = "";
		this.doctorList = new ArrayList<Doctor>();
		this.patientList = new ArrayList<Patient>();
		this.specialList = new HashMap<String , ArrayList<Doctor>>();
		this.setQueueOfAppointments(new ArrayList<Appointment>());
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the doctorList
	 */
	public ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}
	/**
	 * @param doctorList the doctorList to set
	 */
	public void setDoctorList(ArrayList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	/**
	 * @return the patientList
	 */
	public ArrayList<Patient> getPatientList() {
		return patientList;
	}
	/**
	 * @param patientList the patientList to set
	 */
	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}

	/**
	 * @return the specialList
	 */
	public HashMap<String , ArrayList<Doctor>> getSpecialList() {
		return specialList;
	}

	/**
	 * @param specialList the specialList to set
	 */
	public void setSpecialList(HashMap<String , ArrayList<Doctor>> specialList) {
		this.specialList = specialList;
	}

	/**
	 * @return the queueOfAppointments
	 */
	public ArrayList<Appointment> getQueueOfAppointments() {
		return queueOfAppointments;
	}

	/**
	 * @param queueOfAppointments the queueOfAppointments to set
	 */
	public void setQueueOfAppointments(ArrayList<Appointment> queueOfAppointments) {
		this.queueOfAppointments = queueOfAppointments;
	}
	
	
}
