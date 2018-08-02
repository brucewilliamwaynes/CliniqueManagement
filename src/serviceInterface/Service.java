/**
 * 
 */
package serviceInterface;

import model.Availability;
import model.Clinique;
import model.Doctor;
import model.Patient;

/**
 * @author bridgelabz
 *
 */
public interface Service {
	
	public void addDoctor( Clinique myClinique );
	public void addDoctorToClinique( Clinique myClinique , Doctor newDoctor );
	public void addPatient( Clinique myClinique );
	public void addPatientToClinique(  Clinique myClinique,  Patient newPatient  );
	public Doctor searchDoctor( Clinique myClinique , String name );
	public Patient searchPatient( Clinique myClinique, String name );
	public void viewSpecialization( Doctor myDoctor  );
	public void viewAvailability( Doctor myDoctor  );
	public void viewDoctorDetails( Doctor myDoctor );
	public void viewPatientDetails( Patient myPatient   );
	public void viewCliniqueDetails( Clinique myClinique  );
	public void fillCliniqueDetails( Clinique myClinique );
	public void fillDoctorDetails( Doctor myDoctor  );
	public void fillPatientDetails( Patient myPatient );
	public void fillAvailDetails( Doctor myDoctor );
	public void fillSpecializationDetails( Doctor myDoctor );
	public boolean isDoctorAvailable( Availability newAppointment   );
	public void makeAppointment( Clinique myClinique );
	public void bestDoctor( Clinique myClinique );
	public void bestSpecialization(Clinique myClinique );
	
	
}