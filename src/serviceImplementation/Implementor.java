/**
 * 
 */
package serviceImplementation;

import java.util.ArrayList;
import java.util.Scanner;

import model.Appointment;
import model.Availability;
import model.Clinique;
import model.Doctor;
import model.Patient;
import model.Specialization;
import serviceInterface.Service;

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
	public Doctor searchDoctor(Clinique myClinique , String name) {
		// TODO Auto-generated method stub
		
		for(Doctor eachDoc : myClinique.getDoctorList()){
		
			if( eachDoc.getName().equalsIgnoreCase(name) ){
				
				return eachDoc;
				
			}
			
		}
		
		return null;
	}

	@Override
	public Patient searchPatient(Clinique myClinique, String name) {
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
		
		Doctor myDoc = searchDoctor( myClinique ,  newAppointRequest.getCurrentDoctor().getName()  );
		
		if( myDoc != null  ){
			
			System.out.println(  " Checking availability for Dr. " + myDoc.getName()   );
			
			if( myDoc.getAvail().getDate().equalsIgnoreCase(newAppointRequest.getDate()) ){
				
				if( myDoc.getAvail().getStartTime().equalsIgnoreCase(  newAppointRequest.getFromTime()   )  && myDoc.getAvail().getEndTime().equalsIgnoreCase( newAppointRequest.getToTime() )  ){
					
					if( myDoc.getAvail().getBookingsMade() < 5  ){
						
						myClinique.getQueueOfAppointments().add( newAppointRequest );
						
						myDoc.getAvail().setBookingsMade( ( myDoc.getAvail().getBookingsMade() + 1 )  );
						
						
						
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
	public void makeAppointment(Clinique myClinique) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bestDoctor(Clinique myClinique) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bestSpecialization(Clinique myClinique) {
		// TODO Auto-generated method stub
		
	}


}
