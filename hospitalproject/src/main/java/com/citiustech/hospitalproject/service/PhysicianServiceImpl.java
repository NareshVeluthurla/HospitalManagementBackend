package com.citiustech.hospitalproject.service;

import org.springframework.stereotype.Service;

@Service
public class PhysicianServiceImpl implements IPhysicianService {

/*	@Autowired
	private PhysicianRepository physicianrepo;

	@Override
	public String emailCheck(String emailId) {
		Physician phyEntity = new Physician();
		phyEntity.setEmailId(emailId);
		Example<Physician> example = Example.of(phyEntity);

		Optional<Physician> findOne = physicianrepo.findOne(example);
		if (findOne.isPresent()) {
			return emailId + " Email is exit --> Try with other";
		} else {
			return "Unique";
		}
	}

	@Override
	public String empIDCheck(Long empId) {
		Physician phyEmpId = new Physician();
		phyEmpId.setEmpId(empId);
		Example<Physician> example = Example.of(phyEmpId);

		Optional<Physician> findOne = physicianrepo.findOne(example);
		if (findOne.isPresent()) {
			return empId + " EmpID is exit --> Try with other";
		} else {
			return "Unique";
		}
	}

	@Override
	public String savePhysician(Physician physician) {
		String emailCheck = emailCheck(physician.getEmailId());
		String empIDCheck = empIDCheck(physician.getEmpId());
		if (emailCheck == "Unique" && empIDCheck == "Unique") {
			Physician physicianSaved = physicianrepo.save(physician);
			return "Physician ID " + physicianSaved.getEmpId() + " Saved Successfully";
		} else if (emailCheck != "Unique" || empIDCheck != "Unique") {
			return "EmailId or EmpID Already Exit";
		} else {
			return "";
		}

	}

	@Override
	public List<Physician> fetchAllPhysician() {
		return physicianrepo.findAll();
	}

	@Override
	public String deletePhysicianById(Long empId) {
		if (physicianrepo.existsById(empId)) {
			physicianrepo.deleteById(empId);
			return empId + " deleted successfully";
		} else {
			return "Physician ID " + empId + " not found";
		}

	}

	@Override
	public String updatePhysicianById(Long empId, Physician physician) {
		if (physicianrepo.existsById(empId)) {
			Physician exitedphysician = physicianrepo.findById(empId).get();
			exitedphysician.setTitle(physician.getTitle());
			exitedphysician.setFirstName(physician.getFirstName());
			exitedphysician.setLastName(physician.getLastName());
			exitedphysician.setEmailId(physician.getEmailId());
			exitedphysician.setDob(physician.getDob());
			exitedphysician.setRole(physician.getRole());
			exitedphysician.setStatus(physician.getStatus());
			physicianrepo.save(exitedphysician);
			return "Physician ID " + empId + " Updated Successfully";
		} else {
			return "Physician ID " + empId + " Not Found";
		}
	}

}*/

/*@Override
public String savePhysician(Physician physician) {
	Physician physicianSaved = physicianrepo.save(physician);
	if (physicianSaved != null && physicianSaved.getEmpId() != null) {
		return "Physician ID " + physicianSaved.getEmpId() + " Saved Successfully";
	} else {
		return "Physician " + physicianSaved.getEmpId() + " is notsaved successfully";
	}
}*/
}
