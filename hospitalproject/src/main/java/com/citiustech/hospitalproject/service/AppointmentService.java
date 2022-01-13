package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.dto.AppointmentDTO;
import com.citiustech.hospitalproject.entity.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(Appointment e);

	public List<AppointmentDTO> getAllAppointment();

	public Optional<Appointment> getAppointmentById(int id);

	public String updateAppointment(int id,Appointment e);

	public String deleteAppointment(int id);
	
	public String getPatientId(int id);
	
	public List<Appointment> getAppointmentByEmpId(String id);
	
	public List<Appointment> getAppointmentByPatientId(String id);
	

	public List<AppointmentDTO> getDtoPatient(String id);

	public List<AppointmentDTO> getDtoPhysician(String id);

	public List<AppointmentDTO> getDtoNurse();

	public List<Appointment> getAllAppointments();
}
