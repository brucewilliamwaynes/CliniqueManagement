/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Appointment;
import model.Clinique;
import model.Doctor;
import model.Patient;
import serviceImplementation.Implementor;

/**
 * @author bridgelabz
 *
 */
public class CliniqueController {
	
	public static void main( String args[]     )throws Exception{
		
		Scanner sc = new Scanner( System.in );
		
		System.out.println( "Welcome ! I am the Controller Here ! \n" + " I can-troll everything " );
		
		System.out.println( "I shall give you options, Choose Wisely !" );
		
		System.out.println( "How many Cliniques are we talking about here ? " );
		
		int numberOfCliniques = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println( "Okay , I can controll " + numberOfCliniques + " Address Book(s). ");
		
		ArrayList<Clinique> listOfClinics = new ArrayList<Clinique>();
		
		for( int accesed = 0 ; accesed < numberOfCliniques ; accesed ++   ){
			
			String choice = null;
			do {
				
				System.out.println( "Now Now \n" + "Enter 1 to Load Clinique from file system, 2 to Create Record New Clinic Entries !");
			
				choice = sc.nextLine();
			
			}while(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2"));
		
			if(choice.equalsIgnoreCase("1")){
			
				Clinique elementClinic = new Clinique();
				
				Implementor newService = new Implementor();
				
				newService.fillCliniqueFromJSON();
				
				System.out.println( "Enter Clinic name you want to give!" );
				
				String id = sc.nextLine();
				
				elementClinic.setName(id);
				
				listOfClinics.add(elementClinic);
				
			}
			
			if( choice.equalsIgnoreCase("2") ){
				
				Clinique newClinique = new Clinique();
				
				System.out.println( "Enter Clinic Name you want to give!" );
				
				String id = sc.nextLine();
				
				newClinique.setName(id);
				
				Implementor newService = new Implementor();
				
				newService.fillCliniqueDetails(newClinique);
				
				listOfClinics.add(newClinique);
				
			}
		
		
		}
		
		System.out.println( "Now that everything has been initialized , it's time to take con-troll !" );
		
		String choice = "";
		
		do{
			
			System.out.println( "Enter 1 to work with Clinique , 0 to Exit!" );
			
			
			choice = sc.nextLine();
			
			if(choice.equalsIgnoreCase("1")){
				
				System.out.println( "Enter clinique name !"  );
				
				String id =  sc.nextLine();
				
				Implementor newService = new Implementor();
								
				Clinique currentClinic= newService.searchClinique( listOfClinics , id ); 
				
				if(currentClinic != null ){
					
					String option = null;
					
					do {
					
						System.out.println( "Enter 1 to Search Doctor by Name  , 2 to Search Doctor by Specialization  , 3 to Doctor by Date and Time Available , 4 to Search Doctor by ID " );
				
						System.out.println(  " 5 to Search Patient by Name , 6 to Search Patient by ID , 7 to Search Patient by PhoneNumber " );
						
						System.out.println( "8 To make Appointment ,  0 To Exit this ( Matrix Neil ) " );
						
						option = sc.nextLine();
						
						if(option.equalsIgnoreCase("1")){
							
							System.out.println( "Enter Dr. name to be searched"  );
							
							String name = sc.nextLine();
							
							Doctor doc = newService.searchDoctorByName(currentClinic, name);
							
							if(doc != null){
								
								System.out.println( "Dr." + doc.getName() + " is present !" );
								
							}
							
							else {
								
								System.out.println( "Dr. with name " + name + " not found! "   );
								
							}
							
						}
						
						else if ( option.equalsIgnoreCase("2") ) {
							
							System.out.println( "Enter Specialization to be searched"  );
							
							String name = sc.nextLine();
							
							ArrayList<Doctor> docList = newService.searchDoctorBySpecialization(currentClinic, name);
							
							if(docList != null){
								
								System.out.println( "Available Doctor(s) with " + name + " as specialization are : "   );
								
								for( Doctor eachDoc : docList){
									
									System.out.println(  "Dr. "  + eachDoc.getName() );
									
								}
								
							}
							
							else {
								
								System.out.println(  "Dr. with " + name + "  specialization isn't present in " + currentClinic.getName() + " Clinic." );
								
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
							
							ArrayList<Doctor> docList = newService.searchDoctorByAvailability( currentClinic, newRequest );
							
							if(docList.size() != 0){
								
								System.out.println( "Available Doctor(s) on " + date + " between " +  startTime + "  and "  + endTime + " are :"     );
								
								for( Doctor eachDoc : docList){
									
									System.out.println(  "Dr. "  + eachDoc.getName() );
									
								}
								
							}
							
							else {
								
								System.out.println(  "No available Doctor(s) on " + date + " between " +  startTime + "  and "  + endTime + " in " + currentClinic.getName() + " Clinic." );
								
							}
							
						}
						
						else if(  option.equalsIgnoreCase("4" )   ){
							
							String name = "";
							
							do{
								System.out.println( "Enter Dr. ID(3-digit) to be searched"  );
							
								name = sc.nextLine();
							
							}while(name.length()!= 3);
							
							Doctor doc = newService.searchDoctorByID(currentClinic, name);
							
							if(doc != null){
								
								System.out.println( "Dr." + doc.getName() + " is present !" );
								
							}
							
							else {
								
								System.out.println( "Dr. with name " + name + " not found! "   );
								
							}
							
						}
						
						else if (  option.equalsIgnoreCase("5")    ){
							
							System.out.println( "Enter Patient. name to be searched"  );
							
							String name = sc.nextLine();
							
							Patient pat = newService.searchPatientByName(currentClinic, name);
							
							if(pat != null){
								
								System.out.println( "Mr./Mrs." + pat.getName() + " is present !" );
								
							}
							
							else {
								
								System.out.println( "Mr./Mrs. with name " + name + " not found! "   );
								
							}
							
						}
						
						else if (  option.equalsIgnoreCase( "6")   ){
							
							String name = "";
							
							do{
								
								System.out.println( "Enter Patient ID(3-digit) to be searched"  );
							
								name = sc.nextLine();
							
							}while(name.length()!= 3);
							
							Patient pat = newService.searchPatientByID(currentClinic, name);
							
							if(pat != null){
								
								System.out.println( "Mr./Mrs." + pat.getName() + " is present !" );
								
							}
							
							else {
								
								System.out.println( "Mr./Mrs. with id " + name + " not found! "   );
								
							}
							
						}
						
						else if (  option.equalsIgnoreCase("7")    ){
							
							String name = "";
							
							do{
							
								System.out.println( "Enter Patient. number(10-digit) to be searched"  );
							
								name = sc.nextLine();
							
							}while(name.length()!=10);
								
							Patient pat = newService.searchPatientByMobileNumber(currentClinic, name);
							
							if(pat != null){
								
								System.out.println( "Mr./Mrs." + pat.getName() + " is present !" );
								
							}
							
							else {
								
								System.out.println( "Mr./Mrs. with name " + name + " not found! "   );
								
							}
							
						}
						
						else if (  option.equalsIgnoreCase("8")  ){
							
							newService.scheduleAppointment(currentClinic);
							
						}
						
						else if( option.equalsIgnoreCase("0")  ){
							
							continue;
							
						}
						
						else{
							
							System.out.println(  "Invalid Option!!"   );
							
						}
					
					}while ( !option.equalsIgnoreCase("0") );
					
				}
				
				else{
					
					System.out.println( "No such Clinique found with id :" + id );
					
					continue;
					
				}
				
			}
			
			else if( choice.equalsIgnoreCase("0") ){
				
				continue;
				
			}
			
			else{
				
				System.out.println( "Enter a valid choice!!" );
				
			}
			
			
		}while(!choice.equalsIgnoreCase("0"));
		
		
		sc.close();

	}
	
}
