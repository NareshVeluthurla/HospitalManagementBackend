package com.citiustech.hospitalproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.dto.AppointmentDTO;
import com.citiustech.hospitalproject.entity.Appointment;
import com.citiustech.hospitalproject.service.AppointmentService;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("addAppointment")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {

		return appointmentService.addAppointment(appointment);
	}

	@GetMapping("getallAppointment")
	public List<AppointmentDTO> allAppointment() {
		return appointmentService.getAllAppointment();
	}

	@GetMapping("getAppointmentById/{id}")
	public Optional<Appointment> findScheduleWithId(@PathVariable int id) {
		return appointmentService.getAppointmentById(id);
	}
	
	@PutMapping("updateAppointment/{id}")
	public String updateAppointmentWithId(@PathVariable int id, @RequestBody Appointment e) {
		
			
			return appointmentService.updateAppointment(id, e);
		
	}

	@DeleteMapping("deleteAppointment/{id}")
	public String deleteAppointmentWithId(@PathVariable int id) {
		
			
			return appointmentService.deleteAppointment(id);
		
	}
	
	@GetMapping("scheduleforCalendar")
	public List<Appointment> getallSchedule(){
		
		List<Appointment> allAppointment = appointmentService.getAllAppointments();
		
		
		List<Appointment> schedule = allAppointment.stream()
				       .filter((a)->a.getStatus().equals("booked"))
		               .collect(Collectors.toList());
		
		return schedule;
		
	}
	
	@GetMapping("getHistoryById/{id}")
	public List<Appointment> getHistoryById(@PathVariable int id){
		
		
		List<Appointment> allAppointment = appointmentService.getAllAppointments();
		
		List<Appointment> rrr = allAppointment.stream()
			       .filter((a)->a.getPatientId().equals(appointmentService.getPatientId(id)))
	               .collect(Collectors.toList());
		
		return rrr;
	}
	
	@GetMapping("getappointmentbyEmpId/{id}")
	public List<Appointment> getSentNotes(@PathVariable String id) {
		System.out.println("Employee Id: " + id);
		 List<Appointment> stream = appointmentService.getAppointmentByEmpId(id).stream()
				 .filter(a->a.getEmployeeId().equals(id) && a.getStatus().equals("pending"))
				 .collect(Collectors.toList());
		return stream;
	}
	
	@GetMapping("getSchedulebyEmpId/{id}")
	public List<Appointment> getSentNotes3(@PathVariable String id) {
		System.out.println("Employee Id: " + id);
		 List<Appointment> stream = appointmentService.getAppointmentByEmpId(id).stream()
				 .filter(a->a.getEmployeeId().equals(id) && a.getStatus().equals("booked"))
				 .collect(Collectors.toList());
		return stream;
	}
	

	@GetMapping("getappointmentbyPatientId1/{id}")
	public List<Appointment> getSentNotes1(@PathVariable String id) {
	System.out.println("Patient Id: " + id);
	List<Appointment> stream1 = appointmentService.getAppointmentByPatientId(id).stream()
	.filter(a->a.getPatientId().equals(id) && a.getStatus().equals("pending") ||
	a.getStatus().equals("booked"))
	.collect(Collectors.toList());
	return stream1;
	}

	@GetMapping("getappointmentbyPatientId2/{id}")
	public List<Appointment> getSentNotes2(@PathVariable String id) {
	System.out.println("Patient Id: " + id);
	List<Appointment> stream1 = appointmentService.getAppointmentByPatientId(id).stream()
	.filter(a->a.getPatientId().equals(id) && a.getStatus().equals("canceled") ||
	a.getStatus().equals("completed"))
	.collect(Collectors.toList());
	return stream1;
	}
	
	@GetMapping("getphysicianappointments/{id}")
	public List<AppointmentDTO> getPhysicianAppointments(@PathVariable String id) {
		System.out.println("getAppointments"+id);
		
		List<AppointmentDTO> collect = appointmentService.getDtoPhysician(id).stream()
		.filter(a->a.getStatus().equals("pending"))
		.collect(Collectors.toList());
		return collect;
		
	}
	
	@GetMapping("getpatientsappointments1/{id}")
	public List<AppointmentDTO> getPatientAppointments1(@PathVariable String id) {
		System.out.println("getAppointments"+id);
		
		List<AppointmentDTO> collect = appointmentService.getDtoPatient(id).stream()
		.filter(a->a.getStatus().equals("pending") || a.getStatus().equals("booked"))
		.collect(Collectors.toList());
		return collect;
		
	}
	
	@GetMapping("getpatientsappointments2/{id}")
	public List<AppointmentDTO> getPatientAppointments2(@PathVariable String id) {
		System.out.println("getAppointments"+id);
		
		List<AppointmentDTO> collect = appointmentService.getDtoPatient(id).stream()
				.filter(a->a.getStatus().equals("completed") || a.getStatus().equals("canceled"))
		        .collect(Collectors.toList());
		return collect;
		
	}
	

@GetMapping("dailyappointmentfornurse")
	public List<AppointmentDTO> dailyAppointmentForNurse() {
		
		
		//List<AppointmentDTO> collect = appointmentService.getDtoNurse();
		List<AppointmentDTO> collect = appointmentService.getDtoNurse() .stream()
				.filter(a->a.getDate().toString().equals(LocalDate.now().toString()+" 00:00:00.0") &&
						a.getStatus().equals("booked"))
				.collect(Collectors.toList());
		System.out.println(collect);
		return collect;
	}
	
}
