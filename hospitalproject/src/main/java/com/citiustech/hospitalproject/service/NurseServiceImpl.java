package com.citiustech.hospitalproject.service;

import org.springframework.stereotype.Service;

@Service
public class NurseServiceImpl implements INurseService {

	/*
	 * @Autowired private NurseRepository nurserepo;
	 * 
	 * @Override public String saveNurse(Nurse nurse) { Nurse nurseSaved =
	 * nurserepo.save(nurse); if (nurseSaved != null && nurseSaved.getEmpId() !=
	 * null) { return "Nurse ID " + nurseSaved.getEmpId() + " Saved Successfully"; }
	 * else { return "Nurse " + nurseSaved.getEmpId() + " is notsaved successfully";
	 * } }
	 * 
	 * @Override public List<Nurse> fetchAllNurse() { return nurserepo.findAll(); }
	 * 
	 * @Override public String deleteNurseById(Long empId) { if
	 * (nurserepo.existsById(empId)) { nurserepo.deleteById(empId); return empId +
	 * " deleted successfully"; } else { return "Nurse ID " + empId + " not found";
	 * } }
	 * 
	 * @Override public String updateNurseById(Long empId, Nurse nurse) { if
	 * (nurserepo.existsById(empId)) { Nurse exitedNurse =
	 * nurserepo.findById(empId).get(); exitedNurse.setTitle(nurse.getTitle());
	 * exitedNurse.setFirstName(nurse.getFirstName());
	 * exitedNurse.setLastName(nurse.getLastName());
	 * exitedNurse.setEmailId(nurse.getEmailId());
	 * exitedNurse.setDob(nurse.getDob()); exitedNurse.setRole(nurse.getRole());
	 * exitedNurse.setStatus(nurse.getStatus()); nurserepo.save(exitedNurse); return
	 * "Nurse ID " + empId + " Updated Successfully"; } else { return "Nurse ID " +
	 * empId + " Not Found"; } }
	 */
}
