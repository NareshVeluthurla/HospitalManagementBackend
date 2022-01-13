package com.citiustech.hospitalproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("schedular")
public class SchedularController {
	/*
	 * private SchedularService schedulingService;
	 * 
	 * @Autowired public SchedularController(SchedularService schedulingService) {
	 * super(); this.schedulingService = schedulingService; }
	 * 
	 * @PostMapping("/getAppointments") public List<Scheduling>
	 * getAppointments(@RequestBody String data) { System.out.println(data);
	 * JSONObject obj=new JSONObject(data); String inputdate= obj.getString("date");
	 * 
	 * 
	 * LocalDate ld1=LocalDate.parse(inputdate); System.out.println(ld1);
	 * schedulingService.getAppointments(ld1);
	 * 
	 * 
	 * return null;
	 * 
	 * 
	 * }
	 */


}
