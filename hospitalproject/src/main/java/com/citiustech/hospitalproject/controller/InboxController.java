package com.citiustech.hospitalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.hospitalproject.entity.Notes;
import com.citiustech.hospitalproject.service.InboxService;

@RestController
@RequestMapping("inbox")
public class InboxController {

	private InboxService inboxService;

	@Autowired
	public InboxController(InboxService inboxService) {
		super();
		this.inboxService = inboxService;
	}



	@PostMapping("note")
	public Notes saveNote(@RequestBody Notes note) {
		return inboxService.addNote(note);

	}

	@GetMapping("sentnotes/{senderid}")
	public List<Notes> getSentNotes(@PathVariable String senderid) {
		System.out.println("name" + senderid);
		return inboxService.getSentNotes(senderid);
	}

	@GetMapping("receivednotes/{receiverid}")
	public List<Notes> getReceivedNotes(@PathVariable String receiverid) {
		System.out.println("receiver Id" + receiverid);
		return inboxService.getReceivedNotes(receiverid);
	}

	@PutMapping("reply/{id}")
	public String updateReplyWithId(@PathVariable int id, @RequestBody String response, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		try {
			System.out.println(id + "" + response);
			inboxService.updateReply(id, response);
			return "Notes Updated Sucessfully";
		} catch (Exception ex) {
			return ex.toString();
		}

	}

	@PutMapping("status/{id}")
	public String updateStatusWithId(@PathVariable int id, @RequestBody String status, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		try {
			System.out.println(id + "" + status);
			inboxService.updateStatus(id, status);
			return "Notes Updated Sucessfully";
		} catch (Exception ex) {
			return ex.toString();
		}

	}
}

