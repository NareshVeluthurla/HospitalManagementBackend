package com.citiustech.hospitalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.dto.AuthRequest;
import com.citiustech.hospitalproject.dto.UserResponse;
import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.service.UserService;
import com.citiustech.hospitalproject.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class HospitalUserController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	private UserService userService;

	@Autowired
	public HospitalUserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/addEmployee")
	public Hospitaluser addEmployee(@RequestBody Hospitaluser emp) {
		return userService.save(emp);

	}

	@PostMapping("authenticate")
	public UserResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		UserResponse userResponse = new UserResponse();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

			Hospitaluser employee = userService.getEmployeeByEmail(authRequest.getUserName());

			userResponse.setEmployeeId(employee.getUserId());
			userResponse.setRole(employee.getRole());
			userResponse.setFirstName(employee.getFirstName());
			userResponse.setLastName(employee.getLastName());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("invalid username/password");
		}

		String generateToken = jwtUtil.generateToken(authRequest.getUserName());
		System.out.println(generateToken);
		userResponse.setToken(generateToken);
		return userResponse;
	}


	// All are Hospital Employee Controller

	@PostMapping("/physician")
	public String saveEmployee(@RequestBody Hospitaluser employee) {
		return userService.saveHospitaluserEmployee(employee);
	}

	@GetMapping("/physician")
	public List<Hospitaluser> getEmployee() {
		return userService.fetchAllHospitaluserEmployee();
	}

	@PutMapping("/physician/{id}/{status}")
	public String updateEmployee(@PathVariable String id, @PathVariable String status) {
		return userService.editHospitaluserEmpStatus(id, status);
	}

	@GetMapping("/countEmp")
	public Long getCountAllEmp() {
		return userService.getCountofallHospitaluserEmployee();
	}

	@GetMapping("/countActive")
	public Long getActiveCountEmp() {
		return userService.getCountofallActiveHospitaluserEmployee();
	}

	@GetMapping("/countDeactive")
	public Long getDeactiveCountEmp() {
		return userService.getCountofallDeactiveHospitaluserEmployee();
	}

	@GetMapping("/countBlocked")
	public Long getBlockedCountEmp() {
		return userService.getCountofallBlockedHospitaluserEmployee();
	}

	

	// All are Hospital Patient Controller

	@GetMapping("/patient")
	public List<Hospitaluser> getAllPatient() {
		return userService.fetchAllPatient();
	}

	@PutMapping("/patient/{id}/{status}")
	public String updatePatient(@PathVariable String id, @PathVariable String status) {
		return userService.editHospitaluserPatientStatus(id, status);
	}

	@GetMapping("/countAllPatient")
	public Long getCountAllPatient() {
		return userService.getCountofallPatient();
	}

	@GetMapping("/countActiveP")
	public Long getActiveCountPatient() {
		return userService.getCountofallActivePatient();
	}

	@GetMapping("/countDeactiveP")
	public Long getDeactiveCountPatient() {
		return userService.getCountofallDeactivePatient();
	}

	@GetMapping("/countBlockedP")
	public Long getBlockedCountPatient() {
		return userService.getCountofallBlockedPatient();
	}

	@GetMapping("/countInactiveP")
	public Long getInactiveCountPatient() {
		return userService.getCountofallInactivePatient();
	}
	@GetMapping("getEmployeeById/{id}")
	public Optional<Hospitaluser> findPatientsWithId(@PathVariable String id) {
		return userService.getEmployeeById(id);
	}

	@GetMapping("/allActiveEmpList")
	public List<Hospitaluser> getAllActiveEmpList() {
		return userService.fetchAllActiveEmployeeList();
	}

	@GetMapping("/allDeactiveEmpList")
	public List<Hospitaluser> getAllDeactiveEmpList() {
		return userService.fetchAllDeactiveEmployeeList();
	}

	@GetMapping("/allBlockedEmpList")
	public List<Hospitaluser> getAllBlockedEmpList() {
		return userService.fetchAllBlockedEmployeeList();
	}

	
	@GetMapping("/allActivePatList")
	public List<Hospitaluser> getAllActivePatientList() {
		return userService.fetchAllActivePatientList();
	}

	@GetMapping("/allDeactivePatList")
	public List<Hospitaluser> getAllDeactivePatientist() {
		return userService.fetchAllDeactivePatientList();
	}

	@GetMapping("/allBlockedPatList")
	public List<Hospitaluser> getAllBlockedPatientList() {
		return userService.fetchAllBlockedPatientList();
	}
	@GetMapping("/allPendingStatusPatList")
	public List<Hospitaluser> getAllPendingStatusPatientList() {
		return userService.fetchAllPendingStatusPatientList();
	}



}