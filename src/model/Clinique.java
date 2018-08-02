/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author brucewilliamwaynes
 *
 */
public class Clinique {

	private String name;
	private ArrayList<Doctor> doctorList;
	private ArrayList<Patient> patientList;
	
	public Clinique(){
		
		this.name = "";
		this.doctorList = new ArrayList<Doctor>();
		this.patientList = new ArrayList<Patient>();
		
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
	
	
}
