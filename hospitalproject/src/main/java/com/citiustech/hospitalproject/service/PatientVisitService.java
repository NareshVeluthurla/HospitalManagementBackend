package com.citiustech.hospitalproject.service;

import com.citiustech.hospitalproject.entity.PatientVisitDetail;

public interface PatientVisitService {

int saveVisitDetails(PatientVisitDetail details);

void updateVisitDetails(PatientVisitDetail details);

Iterable<PatientVisitDetail> getAllVisitDetails(String id);

Iterable<PatientVisitDetail> getAllVisitDetailsByPatientId(String id);

PatientVisitDetail getAllVisitDetailsByAppointmentId(int id);
}
