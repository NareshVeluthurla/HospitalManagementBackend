package com.citiustech.hospitalproject.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.hospitalproject.entity.Notes;

@Repository
public interface InboxRepo extends JpaRepository<Notes, Integer> {

	  List<Notes> findBySenderName(String name);
	  
	  List<Notes> findByReceiverName(String name);
	  
	  @Transactional
	  @Modifying	  
	  @Query("from Notes where senderId = :senderId and status = 'Active'")
	  List<Notes> getSentNotes(@Param(value = "senderId") String id);
	  
	  @Transactional
	  @Modifying
	  @Query("from Notes where receiverId = :receiverId and status = 'Active'")
	  List<Notes> getReceivedNotes(@Param(value = "receiverId") String id);
	  
	  @Transactional
	  @Modifying
	  @Query("update Notes set response = :response where id = :id") void
	  updateResponse(@Param(value = "id") int id, @Param(value = "response") String
	  response);
	  
	  @Transactional
	  @Modifying
	  @Query("update Notes set status = :status where id = :id") void
	  updateStatus(@Param(value = "id") int id, @Param(value = "status") String
	  status);
	
}
