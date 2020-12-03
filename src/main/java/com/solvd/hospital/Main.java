package com.solvd.hospital;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hospital.enumer.Level;
import com.solvd.hospital.enumer.Status;
import com.solvd.hospital.exceptions.NullDiagnosisException;
import com.solvd.hospital.exceptions.NullDiseasesThatHealsException;
import com.solvd.hospital.exceptions.NullPatientException;
import com.solvd.hospital.exceptions.NullSymptomsException;
import com.solvd.hospital.interfaces.Operable;
import com.solvd.hospital.model.Appointment;
import com.solvd.hospital.model.hospital.Ambulance;
import com.solvd.hospital.model.hospital.Area;
import com.solvd.hospital.model.hospital.Hospital;
import com.solvd.hospital.model.hospital.PrivateRoom;
import com.solvd.hospital.model.hospital.Room;
import com.solvd.hospital.model.person.Doctor;
import com.solvd.hospital.model.person.HospitalWorker;
import com.solvd.hospital.model.person.Patient;
import com.solvd.hospital.model.person.Secretary;


public class Main {

	private static Logger l= LogManager.getLogger(Main.class);
	private static int IDPer = 0 ; 
	private static int IDAr = 0 ; 
	private static int IDRoom = 0 ; 
	public static void main (String [] args){
		Hospital hospital = new Hospital("Local Hospital","Street 123", null, null, "Tandil", null, new Date());
		Area emergency = new Area(IDAr++, "Emergency", null, null, null);
		Area therapy = new Area(IDAr++, "Therapy", null, null, null);
		Area meeting = new Area(IDAr++, "Meeting area", null, null, null);
		Room room1 = new Room (IDRoom++, "Room 01", null);
		Room room2 = new Room (IDRoom++, "Room 02", null);
		Room room3 = new Room (IDRoom++, "Room 03", null);
		Room room4 = new Room (IDRoom++, "Room 04", null);
		Room room5 = new Room (IDRoom++, "Room 05", null);
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		emergency.setRooms(rooms);
		therapy.setRooms(rooms);
		meeting.setRooms(rooms);

		List<Area> areas= new ArrayList<Area>();
		areas.add(meeting);
		areas.add(therapy);
		areas.add(emergency);
		hospital.setAreas(areas);
		
		
		List<String> diseases= new ArrayList<String>();
		diseases.add("COVID");
		List<String> symptoms= new ArrayList<String>();
		symptoms.add("Headache");
		symptoms.add("Lose Smell");
		symptoms.add("Lose taste");
		symptoms.add("Fatigue");
		Patient patient;
		try {
			patient = new Patient(IDPer++,"John White", null, null, symptoms, Level.HIGH, Status.PENDING);
			patient.setDiagnosis("COVID"); //This is doctor's job, but need more logic from diseases and its symptoms
			List<String> diseasesHeals = new ArrayList<String>();
			diseasesHeals.add("COVID");
			Doctor doctor = new Doctor(IDPer, "Rob Black", null,null, 500.0,null, "51102", diseasesHeals);
			Appointment ap = new Appointment(null, patient , new Date(), doctor);
			l.info(doctor.getDiseasesThatHeals());
			doctor.setCurrentPatient(patient);
			try {
				if (doctor.fixPatient())
					l.info("Patient "+ patient.getName()+ " was fixed from "+ patient.getDiagnosis());
				else 
					l.info("Doctor "+ doctor.getName()+ " can't fixed patient "+ patient.getName());
			} catch (NullDiagnosisException | NullPatientException e1) {
				// TODO Auto-generated catch block
				l.error(" ", e1);
			}
			
			//TODO the same logic from Nurse 
			
			//EXCEPTIONS
			//Invalid Identifier and Salary Zero Exceptions
			Secretary secretary = new Secretary(-15, "Maria Gomez", null, null, 0.0);
			//NullDateException
			Appointment app = new Appointment(null, patient, null, doctor);
			//NullDiagnosisException
			patient.setDiagnosis(null);
			try {
				doctor.fixPatient();
			}catch(NullDiagnosisException | NullPatientException e) {
				l.error(" ", e);
			}
			//NullDirectorException
			List<HospitalWorker> admit = new ArrayList<HospitalWorker>();
			admit.add(doctor);
			PrivateRoom pRoom = new PrivateRoom(01, "Surgery", admit, null, null);
			//NullDiseasesThatHeals
			try {
				doctor.setDiseasesThatHeals(null);	
			}catch(NullDiseasesThatHealsException e) {
				l.error("", e);
			}
			//NullSymptomsException
			try {
				patient.setSymptoms(null);	
			}catch(NullSymptomsException e) {
				l.error(" ", e);
			}
			
			Ambulance amb=new Ambulance();
			//LAMBDA
			Operable p=()->{amb.drive();};
			p.operate();
			
			
			 
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			l.error(" ", e1);
		}
		
		
		
	}
}
