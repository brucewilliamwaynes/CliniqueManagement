/**
 * 
 */
package serviceInterface;

import model.Appointment;
import model.Availability;
import model.Clinique;
import model.Doctor;
import model.Patient;
import model.Specialization;

/**
 * @author brucewilliamwaynes
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
	public boolean isDoctorAvailable( Clinique myClinique , Appointment newAppointRequest  );
	public void makeAppointment( Clinique myClinique , Appointment newAppointRequest );
	public Doctor bestDoctor( Clinique myClinique );
	public void fillUpSpecializationList( Clinique myClinique  );
	public Specialization bestSpecialization(Clinique myClinique );
	
	
}
