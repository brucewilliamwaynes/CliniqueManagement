/**
 * 
 */
package model;

/**
 * @author brucewilliamwaynes
 *
 */
public class Doctor {

	private String name;
	private String id;
	private Specialization special;
	private Availability avail;
	
	public Doctor(){
		this.name = "";
		this.id = "";
		this.special = new Specialization();
		this.avail = new Availability();
		
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the special
	 */
	public Specialization getSpecial() {
		return special;
	}
	/**
	 * @param special the special to set
	 */
	public void setSpecial(Specialization special) {
		this.special = special;
	}
	/**
	 * @return the avail
	 */
	public Availability getAvail() {
		return avail;
	}
	/**
	 * @param avail the avail to set
	 */
	public void setAvail(Availability avail) {
		this.avail = avail;
	}
	
	
	
}
