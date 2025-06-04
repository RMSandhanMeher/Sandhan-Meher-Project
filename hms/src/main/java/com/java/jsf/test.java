package com.java.jsf;

import com.java.jsf.Controller.HospitalController;
import com.java.jsf.dao.DoctorDaoImpl;
import com.java.jsf.dao.PatientDaoImpl;
import com.java.jsf.model.Patient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        try {
            
            HospitalController controller = new HospitalController();
            controller.setDoctorDao(new DoctorDaoImpl());   
            controller.setPatientDao(new PatientDaoImpl());
            
            controller.setDoctorId("D123"); 

            
            Patient patient = new Patient();
            patient.setPatientId("P101");
            patient.setPatientName("John Doe");

            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse("1995-08-15");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            patient.setDOB(sqlDate);

           
            controller.setPatient(patient);

            
            String result = controller.addPatient();
            System.out.println("Result from addPatient(): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
