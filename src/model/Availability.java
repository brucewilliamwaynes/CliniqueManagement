/**
 * 
 */
package model;

/**
 * @author brucewilliamwaynes
 *
 */
public class Availability {

	private String Date;
	private String startTime;
	private String endTime;
	private int bookingsMade;
	
	public Availability(){
		
		this.Date = "";
		this.startTime = "";
		this.endTime = "";
		this.bookingsMade = 0;
		
	}
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the bookingsMade
	 */
	public int getBookingsMade() {
		return bookingsMade;
	}
	/**
	 * @param bookingsMade the bookingsMade to set
	 */
	public void setBookingsMade(int bookingsMade) {
		this.bookingsMade = bookingsMade;
	}
	
	
}
