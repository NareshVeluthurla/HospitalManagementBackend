package com.citiustech.hospitalproject.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.entity.Available;
import com.citiustech.hospitalproject.service.AvailableService;

@RestController
@RequestMapping("/available")
public class AvailableController {

	private AvailableService availableService;

	@Autowired
	public AvailableController(AvailableService availableService) {
		super();
		this.availableService = availableService;
	}

	@GetMapping("/getHello")
	public String getHello() {
		return "hello";
	}

	@GetMapping("getallAvailable")
	public List<Available> allAppointment() {
		
		List<Available> collect = availableService.getAllAvailable().stream()
				                                  .filter(a->a.getIsAvail().equals("yes"))
		                                          .collect(Collectors.toList());
		
		return collect;
	}

	@GetMapping("getAvailableById/{id}")
	public Optional<Available> findScheduleWithId(@PathVariable int id) {
		return availableService.getAvailableById(id);
	}

	@PutMapping("updateAvailable/{id}")
	public String updateAvailableWithId(@PathVariable int id, @RequestBody Available e) {

		return availableService.updateAvailable(id, e);
	}

	@DeleteMapping("deleteAvailable/{id}")
	public String deleteAvailableWithId(@PathVariable int id) {

		return availableService.deleteAvailable(id);
	}
	
	
	@GetMapping("getavailablebyEmpId/{id}")
	public List<Available> getSentNotes(@PathVariable String id) {
		System.out.println("Employee Id: " + id);
		 List<Available> stream = availableService.getgetAvailByEmpId(id).stream()
				 .filter(a->a.getIsAvail().equals("yes")).collect(Collectors.toList());
		return stream;
	}
	@GetMapping("getallAvailable1")
	public List<Available> allAppointment1() {

	List<Available> collect = availableService.getAllAvailable();

	return collect;
	}
}
