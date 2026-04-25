package com.pm.patientservice.mapper;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.entity.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toResponseDTO(Patient patient){

        return PatientResponseDTO.builder()
                .id(patient.getId().toString())
                .name(patient.getName())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .build();


    }

    public  static Patient toModel(PatientRequestDTO  patientRequestDTO){
Patient patient=new Patient();
patient.setName(patientRequestDTO.getName());
patient.setAddress(patientRequestDTO.getAddress());
patient.setEmail(patientRequestDTO.getEmail());
patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

return patient;
    }
}
