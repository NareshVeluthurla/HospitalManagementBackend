package com.citiustech.hospitalproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.dto.AppointmentDTO;
import com.citiustech.hospitalproject.entity.Appointment;
import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.repositories.AppointmentRepository;
import com.citiustech.hospitalproject.repositories.HospitalUserRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;

	
	@Autowired
	private HospitalUserRepository userRepo;
	@Override
	public Appointment addAppointment(Appointment e) {
		
		return appointmentRepo.save(e);
	}

	@Override
	public List<AppointmentDTO> getAllAppointment() {
		List<AppointmentDTO> appointmentDTO = new ArrayList<AppointmentDTO>();
		List<Appointment> appointmentByEmpId = appointmentRepo.findAll();
System.out.println("appointmentByEmpId"+appointmentByEmpId);
		for (Appointment appointment : appointmentByEmpId) {

			AppointmentDTO dt = new AppointmentDTO();

			dt.setId(appointment.getId());
			dt.setEmployeeId(appointment.getEmployeeId());
			dt.setPatientId(appointment.getPatientId());
			dt.setMeetingTitle(appointment.getMeetingTitle());
			dt.setDescription(appointment.getDescription()); 
			dt.setDate(appointment.getDate());
			dt.setTime(appointment.getTime());
			dt.setStatus(appointment.getStatus());
			dt.setReason(appointment.getReason());
			Hospitaluser employee = userRepo.findById(appointment.getEmployeeId()).get();
			dt.setPhysicianFirstName(employee.getFirstName());
			Hospitaluser patient = userRepo.findById(appointment.getPatientId()).get();
			dt.setPatientFirstName(patient.getFirstName());

			appointmentDTO.add(dt);
		}

		return appointmentDTO;
		
	}

	@Override
	public Optional<Appointment> getAppointmentById(int id) {
		
//		Appointment app = new Appointment();
//		app.setId(id);
//		Example<Appointment> example = Example.of(app);
//
//		Optional<Appointment> findOne = appointmentRepo.findOne(example);
//		if (findOne.isPresent()) {
//			return id + " EmpID is exit --> Try with other";
//		} else {
//			return "Unique";
//		}
		
		return appointmentRepo.findById(id);
		
	}

	@Override
	public String updateAppointment(int id, Appointment e) {
		
		if (appointmentRepo.existsById(id)) {
			Appointment app = appointmentRepo.findById(id).get();
			
			app.setEmployeeId(e.getEmployeeId());
			app.setPatientId(e.getPatientId());
			app.setMeetingTitle(e.getMeetingTitle());
			app.setDescription(e.getDescription());
			app.setDate(e.getDate());
			app.setTime(e.getTime());
			app.setStatus(e.getStatus());
			app.setReason(e.getReason());
			
			appointmentRepo.save(app);
			return "Physician ID " + id + " Updated Successfully";
		} else {
			return "Physician ID " + id + " Not Found";
		}
	}
	

	@Override
	public String deleteAppointment(int id) {
		if (appointmentRepo.existsById(id)) {
			appointmentRepo.deleteById(id);
			return id + " deleted successfully";
		} else {
			return "Physician ID " + id + " not found";
		}
	}

	@Override
	public String getPatientId(int id) {
		
		Appointment app = appointmentRepo.getById(id);
		
		return app.getPatientId();
	}

	@Override
	public List<Appointment> getAppointmentByEmpId(String id) {
		
		return appointmentRepo.getAppointmentByEmpId(id);
	}

	@Override
	public List<Appointment> getAppointmentByPatientId(String id) {
		
		return appointmentRepo.getAppointmentByPatientId(id);
	}

	@Override
	public List<AppointmentDTO> getDtoPhysician(String id) {
		List<AppointmentDTO> appointmentDTO= new ArrayList<AppointmentDTO>();
		
		List<Appointment> appointmentByEmpId = appointmentRepo.getAppointmentByEmpId(id);
		
		for (Appointment appointment : appointmentByEmpId) {
			
			AppointmentDTO dt= new AppointmentDTO();
			
			dt.setId(appointment.getId());
			dt.setEmployeeId(appointment.getEmployeeId());
			dt.setPatientId(appointment.getPatientId());
			dt.setMeetingTitle(appointment.getMeetingTitle());
			dt.setDescription(appointment.getDescription());
			dt.setDate(appointment.getDate());
			dt.setTime(appointment.getTime());
			dt.setStatus(appointment.getStatus());
			dt.setReason(appointment.getReason());
			Hospitaluser employee=userRepo.findById(appointment.getEmployeeId()).get();
			 dt.setPhysicianFirstName(employee.getFirstName());			
			Hospitaluser patient=userRepo.findById(appointment.getPatientId()).get();
	        dt.setPatientFirstName(patient.getFirstName());
	        
	        appointmentDTO.add(dt);
		}
		
		return appointmentDTO;
	}

	@Override
	public List<AppointmentDTO> getDtoPatient(String id) {
List<AppointmentDTO> appointmentDTO= new ArrayList<AppointmentDTO>();
		
		List<Appointment> appointmentByEmpId = appointmentRepo.getAppointmentByPatientId(id);
		
		for (Appointment appointment : appointmentByEmpId) {
			
			AppointmentDTO dt= new AppointmentDTO();
			
			dt.setId(appointment.getId());
			dt.setEmployeeId(appointment.getEmployeeId());
			dt.setPatientId(appointment.getPatientId());
			dt.setMeetingTitle(appointment.getMeetingTitle());
			dt.setDescription(appointment.getDescription());
			dt.setDate(appointment.getDate());
			dt.setTime(appointment.getTime());
			dt.setStatus(appointment.getStatus());
			dt.setReason(appointment.getReason());
			Hospitaluser employee=userRepo.findById(appointment.getEmployeeId()).get();
			 dt.setPhysicianFirstName(employee.getFirstName());			
			Hospitaluser patient=userRepo.findById(appointment.getPatientId()).get();
	        dt.setPatientFirstName(patient.getFirstName());
	        
	        appointmentDTO.add(dt);
		}
		
		return appointmentDTO;
	}

	@Override
	public List<AppointmentDTO> getDtoNurse() {

		List<AppointmentDTO> appointmentDTO = new ArrayList<AppointmentDTO>();
		List<Appointment> appointmentByEmpId = appointmentRepo.findAll();
System.out.println("appointmentByEmpId"+appointmentByEmpId);
		for (Appointment appointment : appointmentByEmpId) {

			AppointmentDTO dt = new AppointmentDTO();

			dt.setId(appointment.getId());
			dt.setEmployeeId(appointment.getEmployeeId());
			dt.setPatientId(appointment.getPatientId());
			dt.setMeetingTitle(appointment.getMeetingTitle());
			dt.setDescription(appointment.getDescription()); 
			dt.setDate(appointment.getDate());
			dt.setTime(appointment.getTime());
			dt.setStatus(appointment.getStatus());
			dt.setReason(appointment.getReason());
			Hospitaluser employee = userRepo.findById(appointment.getEmployeeId()).get();
			dt.setPhysicianFirstName(employee.getFirstName());
			Hospitaluser patient = userRepo.findById(appointment.getPatientId()).get();
			dt.setPatientFirstName(patient.getFirstName());

			appointmentDTO.add(dt);
		}

		return appointmentDTO;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepo.findAll();
	}

}
