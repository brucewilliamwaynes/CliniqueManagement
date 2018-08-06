/**
 * 
 */
package serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;

import model.Appointment;
import model.Availability;
import model.Clinique;
import model.Doctor;
import model.Patient;
import model.Specialization;
import serviceInterface.Service;
import utility.FileHandlingClass;

/**
 * @author brucewilliamwaynes
 *
 */
public class Implementor implements Service{

	@Override
	public void addDoctor(Clinique myClinique ) {
		// TODO Auto-generated method stub
		Doctor newDoctor = new Doctor();
		
		fillDoctorDetails(  newDoctor );
		
		addDoctorToClinique(myClinique, newDoctor);
		
	}

	@Override
	public void addDoctorToClinique(Clinique myClinique, Doctor newDoctor) {
		// TODO Auto-generated method stub
		
		myClinique.getDoctorList().add( newDoctor );
		
	}

	@Override
	public void addPatient( Clinique myClinique ) {
		// TODO Auto-generated method stub
		
		Patient newPatient = new Patient();
		
		fillPatientDetails( newPatient  );
		
		addPatientToClinique(  myClinique , newPatient  );
		
	}

	@Override
	public void addPatientToClinique(Clinique myClinique, Patient newPatient) {
		// TODO Auto-generated method stub
		
		myClinique.getPatientList().add( newPatient );
		
	}

	@Override
	public Doctor searchDoctorByName(Clinique myClinique , String name) {
		// TODO Auto-generated method stub
		
		for(Doctor eachDoc : myClinique.getDoctorList()){
		
			if( eachDoc.getName().equalsIgnoreCase(name) ){
				
				return eachDoc;
				
			}
			
		}
		
		return null;
	}

	@Override
	public Patient searchPatientByName(Clinique myClinique, String name) {
		// TODO Auto-generated method stub
		
		for(Patient eachPat : myClinique.getPatientList()){
			
			if( eachPat.getName().equalsIgnoreCase(name) ){
				
				return eachPat;
				
			}
			
		}
		
		
		return null;
	}

	@Override
	public void viewDoctorDetails(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		System.out.println( "DoctorName" + myDoctor.getName() );
		
		System.out.println( "DoctorId" + myDoctor.getId() );
		
		viewSpecialization( myDoctor  );
		
		viewAvailability( myDoctor  );
		
	}

	@Override
	public void viewPatientDetails(Patient myPatient) {
		// TODO Auto-generated method stub
	
		System.out.println( "PatientName" + myPatient.getName() );
		
		System.out.println( "PatientId" + myPatient.getId() );
		
		System.out.println( "PatientNumber" + myPatient.getPhoneNumber() );
		
		System.out.println( "PatientAge" + myPatient.getAge() );
		
	}

	@Override
	public boolean isDoctorAvailable( Clinique myClinique , Appointment  newAppointRequest  ) {
		// TODO Auto-generated method stub
		
		Doctor myDoc = searchDoctorByName( myClinique ,  newAppointRequest.getCurrentDoctor().getName()  );
		
		myDoc.setTotalPoints(  myDoc.getTotalPoints() + 1  );
			
		if( myDoc != null && myDoc.getAvail().getDate().equalsIgnoreCase(newAppointRequest.getDate()) &&  myDoc.getAvail().getStartTime().equalsIgnoreCase(  newAppointRequest.getFromTime()   )  && myDoc.getAvail().getEndTime().equalsIgnoreCase( newAppointRequest.getToTime() )  && myDoc.getAvail().getBookingsMade() < 5  ){
				
				return true;
				
			}
			
		return false;
	
}

	@Override
	public void viewCliniqueDetails(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		System.out.println( "Hey Welcome to " + myClinique.getName()  + " ! " );
		
		System.out.println(   "Here are the details of the doctors available."   );
		
		for( Doctor eachDoc : myClinique.getDoctorList() ){
			
			viewDoctorDetails( eachDoc  );
			
		}
		
		System.out.println(   "Here are the details of the Patient associated with us!"    );
		
		for( Patient eachPatient : myClinique.getPatientList() ){
			
			viewPatientDetails( eachPatient  );
			
		}
		
		
		System.out.println(  "That's all the Details ! \n" + "Do revisit!"   );
		
	}

	@Override
	public void viewSpecialization(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		Specialization currentSpec = myDoctor.getSpecial();
		
		System.out.println(  "Area of Specification" + currentSpec.getAreaOfSpecialization()  );
		
		System.out.println( "Rating " + currentSpec.getRating()  );
		
	}

	@Override
	public void viewAvailability(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		Availability currentAvail = myDoctor.getAvail();
		
		System.out.println( "Date of availability" + currentAvail.getDate()  );
		
		System.out.println( "Start time of availability " + currentAvail.getStartTime() );
		
		System.out.println( "End Time of Availability " + currentAvail.getEndTime()  );
		
		System.out.println(  "Number of Bookings made" + currentAvail.getBookingsMade()  );
		
	}

	@Override
	public void fillCliniqueDetails(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		ArrayList<Doctor> docList = new ArrayList<Doctor>();
		
		ArrayList<Patient> patList = new ArrayList<Patient>();
		
		System.out.println( "Enter details of Doctor first"  );
		
		String stop = "";
		
		Scanner sc = new Scanner( System.in  );
		
		do{
			
			System.out.println( "Adding a new Doctor"   );
			
			Doctor newDoc = new Doctor();
			
			fillDoctorDetails( newDoc  );
			
			myClinique.getDoctorList().add( newDoc );
			
			System.out.println( "Do you want to stop? (yes/no)'"  );
			
			stop = sc.nextLine();
			
		}while(!stop.equals("yes") );
		
		stop = "";
		
		System.out.println(  "Filling up details for Patients" );
		
		do{
			
			System.out.println( "Adding a new Patient"   );
			
			Patient newPat = new Patient();
			
			fillPatientDetails( newPat  );
			
			myClinique.getPatientList().add( newPat );
			
			System.out.println( "Do you want to stop? (yes/no)'"  );
			
			stop = sc.nextLine();
			
		}while(!stop.equals("yes") );
		
		System.out.println( "Completed Filling up of Clinique Details"   );
		
	}

	@Override
	public void fillDoctorDetails(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in  );
		
		System.out.println( "Enter Name" );
		
		String inputString = sc.nextLine();
		
		myDoctor.setName(inputString);
		
		do {
			
			System.out.println( "Enter Id 3 digit ");
			
			inputString = sc.nextLine();
			
		}while( inputString.length() != 3 );
		
		myDoctor.setId(inputString);
		
		fillSpecializationDetails( myDoctor  );
		
		fillAvailDetails( myDoctor );
		
	}

	@Override
	public void fillPatientDetails(Patient myPatient) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in  );
		
		System.out.println(  "Enter name"  );
		
		String inputString = sc.nextLine();
		
		myPatient.setName( inputString );
		
		do {
			
			System.out.println( "Enter Id 3 digit ");
			
			inputString = sc.nextLine();
			
		}while( inputString.length() != 3 );
		
		myPatient.setId( inputString );
		
		System.out.println( "Enter phone Number" );
		
		inputString = sc.nextLine();
		
		myPatient.setPhoneNumber( inputString );
		
		System.out.println(  "Enter age '"  );
		
		inputString = sc .nextLine();
		
		myPatient.setAge( inputString );
		
	}

	@Override
	public void fillAvailDetails(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		Availability newAvail = new Availability();
		
		Scanner sc = new Scanner( System.in );
		
		System.out.println(  "Enter Date when Avail in DD/MM/YYYY format."   );
		
		String inputString = sc.nextLine();
		
		newAvail.setDate(inputString);

		System.out.println(  "Enter start Time " );
		
		inputString = sc.nextLine();
		
		newAvail.setStartTime(inputString);
		
		System.out.println(  "Enter end Time " );
		
		inputString = sc.nextLine();
		
		newAvail.setEndTime(inputString);
		
		myDoctor.setAvail( newAvail );
		
	}

	@Override
	public void fillSpecializationDetails(Doctor myDoctor) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in  );
		
		Specialization newSpec = new Specialization();
		
		System.out.println(  "Enter Area of Specialization"  );
		
		String inputString = sc.nextLine();
		
		newSpec.setAreaOfSpecialization(inputString);
		
		Double rating = 0.0;
		
		do{
			
			System.out.println( "Enter Rating of " + myDoctor.getName()  );
			
			rating = sc.nextDouble();
			
		}while(rating<=0.0 || rating > 5.0);
		
		newSpec.setRating( rating );
		
		myDoctor.setSpecial ( newSpec );
		
	}

	@Override
	public void makeAppointment(Clinique myClinique ,  Appointment newAppointRequest  ) {
		// TODO Auto-generated method stub
		
		Doctor myDoc = searchDoctorByName( myClinique ,  newAppointRequest.getCurrentDoctor().getName()  );
		
		if( myDoc != null  ){
			
			System.out.println(  " Checking availability for Dr. " + myDoc.getName()   );
			
			if( myDoc.getAvail().getDate().equalsIgnoreCase(newAppointRequest.getDate()) ){
				
				if( myDoc.getAvail().getStartTime().equalsIgnoreCase(  newAppointRequest.getFromTime()   )  && myDoc.getAvail().getEndTime().equalsIgnoreCase( newAppointRequest.getToTime() )  ){
					
					if( myDoc.getAvail().getBookingsMade() < 5  ){
						
						myClinique.getQueueOfAppointments().add( newAppointRequest );
						
						myDoc.getAvail().setBookingsMade( ( myDoc.getAvail().getBookingsMade() + 1 )  );
						
						System.out.println( " Appointment Successfull !" );
						
						myDoc.setTotalPoints(  myDoc.getTotalPoints() + 2   );
						
					}
					
					else {
						
						System.out.println( " Dr. "  + myDoc.getName() + "  is already rounded for the day ! Try another Doctor !  "  );
						
					}
					
					
				}
				
				else{
					
					System.out.println(  " Sorry Dr. "  + myDoc.getName() +  "  attends patients only from " +   myDoc.getAvail().getStartTime()  +    " till "  + myDoc.getAvail().getEndTime()  );
									
				}
				
				
			}
			
			else{
				
				System.out.println( " Oops Dr. " + myDoc.getName() + " isn't available on  " + newAppointRequest.getDate() );
				
			}
			
		}
		
		else {
			
		System.out.println(  "Sorry ! Dr. " + newAppointRequest.getCurrentDoctor().getName() + " isn't available with us. "   );	
			
		}
		
		
	}

	@Override
	public Doctor bestDoctor(Clinique myClinique) {
		// TODO Auto-generated method stub
		 
		int maxPoint = 0;
		
		Doctor bestDoc = null;
		
		for( Doctor eachDoc : myClinique.getDoctorList()  ){
			
			if(  maxPoint < eachDoc.getTotalPoints()   ){
				
				bestDoc = eachDoc;
				
				maxPoint = eachDoc.getTotalPoints();
				
			}
			
		}
		
		return bestDoc;
		
	}

	@Override
	public Doctor searchDoctorByID(Clinique myClinique, String id) {
		// TODO Auto-generated method stub
		
		for( Doctor eachDoc : myClinique.getDoctorList()  ){
			
			if(  eachDoc.getId().equalsIgnoreCase(id)   )
				
				return eachDoc;
			
		}
		
		return null;
		
	}

	@Override
	public ArrayList<Doctor> searchDoctorBySpecialization(Clinique myClinique, String name) {
		// TODO Auto-generated method stub
		
		if(  myClinique.getSpecialList().containsKey(name)   ){
			
			System.out.println( "YES FOUND!"  );
			
			ArrayList<Doctor> docList = myClinique.getSpecialList().get(name);
			
			return docList;
			
		}
		
		return null;
	
	}

	@Override
	public ArrayList<Doctor> searchDoctorByAvailability(Clinique myClinique, Appointment appointRequest) {
		// TODO Auto-generated method stub
		
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		for( Doctor eachDoctor : myClinique.getDoctorList()  ){
			
			if(  eachDoctor.getAvail().getDate().equalsIgnoreCase(appointRequest.getDate())  && eachDoctor.getAvail().getStartTime().equalsIgnoreCase(appointRequest.getFromTime()) && eachDoctor.getAvail().getEndTime().equals(appointRequest.getToTime()) )
			
				doctorList.add(eachDoctor);
		
		}
		
		
		return doctorList;
		
	}

	@Override
	public Patient searchPatientByID(Clinique myClinique, String id) {
		// TODO Auto-generated method stub
	
		for( Patient eachPatient : myClinique.getPatientList() ){
			
			if( eachPatient.getId().equalsIgnoreCase(id)  )
				
				return eachPatient;
			
		}
		
		return null;
	
	}

	@Override
	public Patient searchPatientByMobileNumber(Clinique myClinique, String phoneNumber) {
		// TODO Auto-generated method stub
		
		for ( Patient eachPatient : myClinique.getPatientList()  ){
			
			if(eachPatient.getPhoneNumber().equalsIgnoreCase(phoneNumber))
				
				return eachPatient;
			
		}
		
		return null;
	
	}

	@Override
	public String bestSpecialization(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		double maxRating = 0.0;
		double currentRating = 0.0;
		String bestSpec = "";
		
		for ( String element :  myClinique.getSpecialList().keySet()  ){
			
			currentRating = 0.0;
			
			for( Doctor eachDoc : myClinique.getSpecialList().get(element) ){
				
				currentRating += eachDoc.getSpecial().getRating();
				
			}
			
			currentRating /= myClinique.getSpecialList().get(element).size();
			
			if( currentRating > maxRating ){
				
				maxRating = currentRating;
				
				bestSpec = element;
				
			}
			
		}
		
		
		return bestSpec;
	
	}

	@Override
	public void viewSpecilizationList(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		for( String element : myClinique.getSpecialList().keySet()  ){
			
			System.out.println(  " Specialization : " + element  );
			
			for( Doctor eachDoc : myClinique.getSpecialList().get(element)){
				
				System.out.print( "  Dr.  "  + eachDoc.getName() + "   \n" );
				
			}
			
		}
		
	}

	@Override
	public void fillSpecializationList(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		HashMap< String , ArrayList< Doctor > > specList = new HashMap< String, ArrayList< Doctor >>();
 		
	for( Doctor eachDoc : myClinique.getDoctorList()   ){
		
		String key = eachDoc.getSpecial().getAreaOfSpecialization();
		
		ArrayList< Doctor > keyList = null;
		
		if( specList.containsKey( key  )   ){
			
			keyList = specList.get(key);
			
			keyList.add(eachDoc);
			
		}
		
		else{
			
			keyList = new ArrayList< Doctor >();
			
			keyList.add(eachDoc);
			
		}
		
		specList.put( key , keyList );
		
	}
	
	myClinique.setSpecialList(specList);
	
	}

	@Override
	public void fillCliniqueFromJSON() throws Exception {
		// TODO Auto-generated method stub
		
		Clinique myClinique = new Clinique();
		
		System.out.println(  " Reading Doctor Details First ! "  );
		
		fillDoctorDetailsFromJSON( myClinique );
		
		System.out.println(  " Reading Patient Details!"  );
		
		fillPatientDetailsFromJSON( myClinique  );
		
	}

	@Override
	public void fillDoctorDetailsFromJSON( Clinique myClinique ) throws Exception {
		// TODO Auto-generated method stub
		
		JSONObject docJSON = FileHandlingClass.readJSONFromFile();
		
		ArrayList<Doctor> docList = new ArrayList<Doctor>();
		
		for( Object key : docJSON.keySet()){
			
			JSONObject docObj = (JSONObject)docJSON.get(key);
			
			Doctor newDoc = new Doctor();
			
			newDoc.setName((String) docObj.get("Name"));
			
			newDoc.setId((String) docObj.get("ID"));
			
			newDoc.setTotalPoints((int) docObj.get("TotalPoints"));
			
			fillAvailDetailsFromJSON( docJSON , newDoc    );
			
			fillSpecialDetailsFromJSON( docJSON , newDoc   );
			
			docList.add(newDoc);
			
		}
		
		myClinique.setDoctorList(docList);		
		
	}

	@Override
	public void fillPatientDetailsFromJSON( Clinique myClinique) throws Exception {
		// TODO Auto-generated method stub
		
		JSONObject patJSON = FileHandlingClass.readJSONFromFile();
		
		ArrayList<Patient > patList = new ArrayList<Patient>();
		
		for ( Object key : patJSON.keySet() ){
			
			JSONObject patObj = (JSONObject)patJSON.get(key);
			
			Patient newPat = new Patient();
			
			newPat.setName((String) patObj.get("Name"));
			
			newPat.setId((String) patObj.get("ID"));
			
			newPat.setPhoneNumber((String) patObj.get("PhoneNumber"));
			
			newPat.setAge((String) patObj.get("Age"));
			
			patList.add(newPat);
			
		}
		
		myClinique.setPatientList(patList);
		
	}

	@Override
	public void fillAvailDetailsFromJSON(JSONObject docJSON , Doctor newDoc) {
		// TODO Auto-generated method stub
		
		Availability newAvail = new Availability();
		
		newAvail.setDate((String) docJSON.get(   "Date"    ));
		
		newAvail.setStartTime((String) docJSON.get( "StartTime" ));
		
		newAvail.setEndTime((String) docJSON.get( "EndTime" ));
		
		newAvail.setBookingsMade((int) docJSON.get( "Bookings" ));
		
		newDoc.setAvail(newAvail);
		
	}

	@Override
	public void fillSpecialDetailsFromJSON(JSONObject docJSON , Doctor newDoc  ) {
		// TODO Auto-generated method stub
		
		Specialization newSpec = new Specialization();
		
		newSpec.setAreaOfSpecialization((String) docJSON.get("AOS"));
		
		newSpec.setRating((double) docJSON.get("Rating"));
		
		newDoc.setSpecial(newSpec);
		
	}

	@Override
	public Clinique searchClinique(ArrayList<Clinique> clinicList, String name) {
		// TODO Auto-generated method stub
		for(Clinique eachClinic : clinicList){
			
			if( eachClinic.getName().equalsIgnoreCase(name))
				
				return eachClinic;
			
		}
		
		
		return null;
		
	}

	@Override
	public void scheduleAppointment(Clinique myClinique) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner( System.in  );
		
		Appointment newAppointRequest = new Appointment();
		
		System.out.println( "Scheduling Appointment ! Process is starting !"  );
		
		System.out.println(  "Enter your name");
		
		String name = sc.nextLine();
		
		Patient newPat = this.searchPatientByName(myClinique, name);
		
		if( newPat != null ){
			
			newAppointRequest.setCurrentPatient(newPat);
			
		}
		
		else{
			
			newPat = new Patient();
			
			this.fillPatientDetails(newPat);
			
			myClinique.getPatientList().add(newPat);
			
		}
		
		String option = "";
		
		do {
		
		System.out.println( " Search Doctors , 1 for name , 2 for specialization , 3 for availability , 4 for id , 0 to Exit !  "  );
		
		option = sc.nextLine();
		
		if(option.equalsIgnoreCase("1")){
			
			System.out.println( "Enter Dr. name to be searched"  );
			
			name = sc.nextLine();
			
			Doctor doc = this.searchDoctorByName( myClinique, name);
			
			if(doc != null){
							
				this.viewDoctorDetails(doc);
				
			}
			
			else {
				
				System.out.println( "Dr. with name " + name + " not found! "   );
				
			}
			
		}
		
		else if ( option.equalsIgnoreCase("2") ) {
			
			System.out.println( "Enter Specialization to be searched"  );
			
			name = sc.nextLine();
			
			ArrayList<Doctor> docList = this.searchDoctorBySpecialization( myClinique , name);
			
			System.out.println(docList.size());
			
			if(docList != null){
				
				System.out.println( "Available Doctor(s) with " + name + " as specialization are : "   );
				
				for( Doctor eachDoc : docList){
					
					this.viewDoctorDetails(eachDoc);
					
				}
				
			}
			
			else {
				
				System.out.println(  "Dr. with " + name + "  specialization isn't present in " + myClinique.getName() + " Clinic." );
				
			}
			
		}
		
		else if ( option.equalsIgnoreCase("3") ) {
			
			System.out.println( "Enter Date, Start Time and EndTime  to be searched"  );
			
			String date = sc.nextLine();
			
			String startTime = sc.nextLine();
			
			String endTime = sc.nextLine();
			
			Appointment newRequest = new Appointment();
			
			newRequest.setDate(date);
			
			newRequest.setFromTime(startTime);
			
			newRequest.setToTime(endTime);
			
			ArrayList<Doctor> docList = this.searchDoctorByAvailability( myClinique, newRequest );
			
			if(docList.size() != 0){
				
				System.out.println( "Available Doctor(s) on " + date + " between " +  startTime + "  and "  + endTime + " are :"     );
				
				for( Doctor eachDoc : docList){
					
					this.viewDoctorDetails(eachDoc);
					
				}
				
			}
			
			else {
				
				System.out.println(  "No available Doctor(s) on " + date + " between " +  startTime + "  and "  + endTime + " in " + myClinique.getName() + " Clinic." );
				
			}
			
		}
		
		else if(  option.equalsIgnoreCase("4" )   ){
			
			name = "";
			
			do{
				System.out.println( "Enter Dr. ID(3-digit) to be searched"  );
			
				name = sc.nextLine();
			
			}while(name.length()!= 3);
			
			Doctor doc = this.searchDoctorByID( myClinique, name);
			
			if(doc != null){
				
				this.viewDoctorDetails(doc);
				
			}
			
			else {
				
				System.out.println( "Dr. with name " + name + " not found! "   );
				
			}
			
		}
		
		}while(!option.equals("0"));
		
		System.out.println( "I hope I was able to provide you with Information!"  );
		
		System.out.println( "Enter Doctor name you want to book appointment with :"  );
		
		name = sc.nextLine();
		
		Doctor currentDoc = this.searchDoctorByName(myClinique, name);
		
		newAppointRequest.setCurrentDoctor(currentDoc);
		
		System.out.println( "Enter date and time of availability !"   );
		
		String date = sc.nextLine();
		
		String startTime = sc.nextLine();
		
		String endTime = sc.nextLine();
		
		newAppointRequest.setDate(date);
		
		newAppointRequest.setFromTime(startTime);
		
		newAppointRequest.setToTime(endTime);
		
		if( this.isDoctorAvailable(myClinique, newAppointRequest)   ){
			
			System.out.println( "Appointment  Successful !"   );
			
			myClinique.getQueueOfAppointments().add(newAppointRequest);
			
		}
		
		else{
			
			System.out.println(  "Appointment Failed !! Sorry !"   );
			
		}
		
	}


}
