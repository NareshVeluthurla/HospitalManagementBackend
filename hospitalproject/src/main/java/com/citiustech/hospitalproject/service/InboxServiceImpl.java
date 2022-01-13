package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.hospitalproject.entity.Hospitaluser;
import com.citiustech.hospitalproject.entity.Notes;
import com.citiustech.hospitalproject.repositories.HospitalUserRepository;
import com.citiustech.hospitalproject.repositories.InboxRepo;

@Service
public class InboxServiceImpl implements InboxService {

	@Autowired
	private InboxRepo inboxRepo;
	@Autowired
	private HospitalUserRepository userRepo;

	@Override
	public Notes addNote(Notes e) {
		System.out.println("Note"+e);
		Optional<Hospitaluser> emp= userRepo.findById(e.getSenderId());
		Hospitaluser user1=emp.get();
		e.setSenderName(user1.getFirstName());
		e.setSenderType(user1.getRole());
		
		Optional<Hospitaluser> emp2= userRepo.findById(e.getReceiverId());
		Hospitaluser user2=emp2.get();
		e.setReceiverName(user2.getFirstName());
		e.setReceiverType(user2.getRole());
		return inboxRepo.save(e);
	}

	@Override
	public List<Notes> getAllNotes() {
		return inboxRepo.findAll();
	}

	@Override
	public Optional<Notes> getNotesById(int id) {
		return inboxRepo.findById(id);
	}

	@Override
	public void updateReply(int id, String response) {
		System.out.println(id + "" + response);
		inboxRepo.updateResponse(id, response);
	}

	@Override
	public void deleteNotes(int id) {
		inboxRepo.deleteById(id);

	}

	@Override
	public List<Notes> getSentNotes(String id) {
		return inboxRepo.getSentNotes(id);

	}

	@Override
	public List<Notes> getReceivedNotes(String id) {
		return inboxRepo.getReceivedNotes(id);
	}

	@Override
	public void updateStatus(int id, String status) {
		inboxRepo.updateStatus(id, status);
	}

}
