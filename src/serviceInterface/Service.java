/**
 * 
 */
package serviceInterface;

import java.util.ArrayList;

import org.json.simple.JSONObject;

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
	
	public void scheduleAppointment( Clinique myClinique  );
	public Clinique searchClinique( ArrayList<Clinique>  clinicList , String name);
	public void addDoctor( Clinique myClinique );
	public void addDoctorToClinique( Clinique myClinique , Doctor newDoctor );
	public void addPatient( Clinique myClinique );
	public void addPatientToClinique(  Clinique myClinique,  Patient newPatient  );
	public Doctor searchDoctorByName( Clinique myClinique , String name );
	public Doctor searchDoctorByID( Clinique myClinique, String id    );
	public ArrayList<Doctor> searchDoctorBySpecialization( Clinique myClinique , String name    );
	public ArrayList<Doctor> searchDoctorByAvailability( Clinique myClinique , Appointment appointRequest    );	
	public Patient searchPatientByName( Clinique myClinique, String name );
	public Patient searchPatientByID( Clinique myClinique, String id    );
	public Patient searchPatientByMobileNumber( Clinique myClinique, String phoneNumber  );
	public void viewSpecialization( Doctor myDoctor  );
	public void viewAvailability( Doctor myDoctor  );
	public void viewDoctorDetails( Doctor myDoctor );
	public void viewPatientDetails( Patient myPatient   );
	public void viewCliniqueDetails( Clinique myClinique  );
	public void viewSpecilizationList ( Clinique myClinique    );
	public void fillCliniqueDetails( Clinique myClinique );
	public void fillDoctorDetails( Doctor myDoctor  );
	public void fillPatientDetails( Patient myPatient );
	public void fillAvailDetails( Doctor myDoctor );
	public void fillSpecializationDetails( Doctor myDoctor );
	public void fillSpecializationList( Clinique myClinique   );
	public boolean isDoctorAvailable( Clinique myClinique , Appointment newAppointRequest  );
	public void makeAppointment( Clinique myClinique , Appointment newAppointRequest );
	public Doctor bestDoctor( Clinique myClinique );
	public String bestSpecialization( Clinique myClinique );
	public void fillCliniqueFromJSON() throws Exception;
	public void fillDoctorDetailsFromJSON(  Clinique myClinique  ) throws Exception;
	public void fillPatientDetailsFromJSON (  Clinique myClinique    ) throws Exception;
	public void fillAvailDetailsFromJSON( JSONObject docJSON , Doctor newDoc  );
	public void fillSpecialDetailsFromJSON( JSONObject docJSON  , Doctor newDoc  );
	
	
}
