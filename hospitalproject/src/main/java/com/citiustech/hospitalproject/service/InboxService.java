package com.citiustech.hospitalproject.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.hospitalproject.entity.Notes;


public interface InboxService {

public Notes addNote(Notes e);

public List<Notes> getAllNotes();

public Optional<Notes> getNotesById(int id);

public void updateReply(int id, String response);

public void updateStatus(int id, String status);

public void deleteNotes(int id);

public List<Notes> getSentNotes(String id);

public List<Notes> getReceivedNotes(String id);
}
