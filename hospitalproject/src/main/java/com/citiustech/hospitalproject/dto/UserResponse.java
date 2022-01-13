package com.citiustech.hospitalproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
 private String token;
 
 private String firstName;
 
 private String lastName;
 
 private String role;
 
 private String employeeId;
 

}
