/**
 * 
 */
package model;

/**
 * @author brucewilliamwaynes
 *
 */
public class Specialization {

	private String areaOfSpecialization;
	private double rating;
	
	public Specialization(){
		
		this.areaOfSpecialization = "";
		this.rating = 0.0;
		
	}
	
	/**
	 * @return the areaOfSpecialization
	 */
	public String getAreaOfSpecialization() {
		return areaOfSpecialization;
	}
	/**
	 * @param areaOfSpecialization the areaOfSpecialization to set
	 */
	public void setAreaOfSpecialization(String areaOfSpecialization) {
		this.areaOfSpecialization = areaOfSpecialization;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
