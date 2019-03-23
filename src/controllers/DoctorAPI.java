package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.Doctor;
import utils.WithinBounds;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DoctorAPI {
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public DoctorAPI() {
    }

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public Doctor getDoctor(int index){
        if (WithinBounds.arrayCheck(index,doctors.size())) {
            return doctors.get(index);
        } return null;
    }

    public Boolean removeDoctor(int index){
        if (WithinBounds.arrayCheck(index,doctors.size())) {
            doctors.remove(index);
            return true;
        } return false;
    }

    public int numberOfDoctors(){
        return doctors.size();
    }

    public String listDoctors(){
        if (doctors.size() != 0) {
            StringBuilder listDoctors = new StringBuilder();
            for (int i = 0; i < doctors.size(); i++) {
                listDoctors.append(i).append(": ").append(doctors.get(i).toString()).append("\n");
            }
            return listDoctors.toString();
        } return "No Doctors Stored";
    }

    public String listDoctors(String doctorType) {
        if (doctors.size() != 0) {
            StringBuilder listDoctors = new StringBuilder();
            boolean typeExists = false;
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getClass().getName().equals(doctorType)) {
                    listDoctors.append(i).append(": ").append(doctors.get(i).toString()).append("\n");
                    typeExists = true;
                }
            } if (typeExists) return "No " + doctorType + " doctors stored";
            return listDoctors.toString();
        } return "No Doctors Stored";
    }

    public ArrayList<Doctor> searchDoctorsByName(String name){
        ArrayList<Doctor> nameDoctors = new ArrayList<>();
        for (Doctor doctor: doctors){
            if (doctor.getName().toUpperCase().contains(name.toUpperCase())){
                nameDoctors.add(doctor);
            }
        } return nameDoctors;
    }

    public int calculateAnnualFees(){
        int total = 0;
        for (Doctor doctor: doctors) {
            total = (int) doctor.calcRegistrationFee();
        } return total;
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("doctors.xml"));
        doctors = (ArrayList<Doctor>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("doctors.xml"));
        out.writeObject(doctors);
        out.close();
    }

}
