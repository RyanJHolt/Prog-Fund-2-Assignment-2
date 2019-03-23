package controllers;

import models.*;
import utils.ScannerInput;
import utils.WithinBounds;

import java.util.ArrayList;
import java.util.HashSet;


public class Driver {

    private DoctorAPI doctorAPI;

    private Driver() {
        doctorAPI = new DoctorAPI();
        runMenu();
    }

    public static void main(String[] args) {
        new Driver();
    }

    private int mainMenu() {
        System.out.println("Medical Council Menu");
        System.out.println("---------");
        System.out.println("  1) Add a Doctor");
        System.out.println("  2) List all Doctors");
        System.out.println("  3) List Doctors by name");
        System.out.println("  4) Update Doctor details");
        System.out.println("  5) Update Doctor qualifications");
        System.out.println("  6) Update Doctor specialisations");
        System.out.println("  7) Delete Doctor");
        System.out.println("  --------------------");
        System.out.println("  10) Annual Fees Report");
        System.out.println("  11) Doctor Report (by category");
        System.out.println("  12) Doctor summary report ");

        System.out.println("  --------------------");
        System.out.println("  20) Save to xml");
        System.out.println("  21) Load from xml");
        System.out.println("  --------------------");
        System.out.println("  0) Exit");
        return ScannerInput.readNextInt("==>>");
    }

    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    doctorAPI.addDoctor(addDoctor());
                    break;
                case 2:
                    listDoctors();
                    break;
                case 3:
                    listDoctorsByName();
                    break;
                case 4:
                    updateDoctorDetails();
                    break;
                case 5:
                    updateDoctorQualifications();
                    break;
                case 6:
                    updateDoctorSpecialisations();
                    break;
                case 7:
                    deleteDoctor();
                    break;
                case 10:
                    System.out.println(totalFees());
                    break;
                case 11:
                    System.out.println(doctorReportByCat());
                    break;
                case 12:
                    break;
                case 20:
                    try {
                        doctorAPI.save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 21:
                    try {
                        doctorAPI.load();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            ScannerInput.validNextLine("\nPress any key to continue...");
            option = mainMenu();
        }

        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private Doctor addDoctor() {
        System.out.println("is the Doctor 1. a Specialist,2. an Intern 3. a general doctor ");
        int docType;
        do {
            docType = ScannerInput.readNextInt(" please pick a valid number ");
        }
        while (!WithinBounds.check(1, 4, docType));
        Doctor doctor = null;
        String[] contacts = contactDetails();
        String name = contacts[0];
        String dob = contacts[1];
        char gender = contacts[2].charAt(0);
        String address = contacts[3];
        String contactNumber = contacts[4];
        ArrayList<Qualification> qualifications = addQualifications();

        switch (docType) {
            case 1:
                boolean qualifiedInIrelandSpec = qualifiedInIreland();
                HashSet<String> specialist = addSpecialism();
                return new Specialist(name, dob, gender, address, contactNumber, qualifications, qualifiedInIrelandSpec, specialist);
            case 2:
                return new Intern(name, dob, gender, address, contactNumber, qualifications);
            case 3:
                boolean qualifiedInIrelandGen = qualifiedInIreland();
                return new General(name, dob, gender, address, contactNumber, qualifications, qualifiedInIrelandGen);
            default:
                return null;
        }
    }

    private void listDoctors() {
        System.out.println(doctorAPI.listDoctors());
    }

    private void  listDoctorsByName() {
        ArrayList<Doctor> Doctors = doctorAPI.searchDoctorsByName(ScannerInput.validNextLine("Please Input a Name"));
        StringBuilder list = new StringBuilder();
        for (Doctor doctor : Doctors) {
            list.append(doctor.toString()).append("\n");
        }
        System.out.println(list);
    }

    private void updateDoctorDetails() {
        listDoctors();
        Doctor doctor = doctorAPI.getDoctor(selectDoctor());
        String[] contacts = contactDetails();
        doctor.setName(contacts[0]);
        doctor.setDob(contacts[1]);
        doctor.setGender(contacts[2].toLowerCase().charAt(0));
        doctor.setAddress(contacts[3]);
        doctor.setContactNumber(contacts[4]);
        System.out.println(doctor.toString());
    }

    private void updateDoctorQualifications() {
        listDoctors();
        doctorAPI.getDoctor(selectDoctor()).setQualifications(addQualifications());
    }

    private void updateDoctorSpecialisations() {
        listDoctors();
    }


    private String doctorReportByCat() {
        String type = "Specialist";
        int input;
        do {
            input = ScannerInput.readNextInt("Please Choose a number \n 1:Specialist \n 2:General \n 3:Intern");
            switch (input) {
                case 1:
                    type = "Specialist";
                    break;
                case 2:
                    type = "General";
                    break;
                case 3:
                    type = "Intern";
                    break;
            }
        } while (!WithinBounds.check(1,4,input));
        return doctorAPI.listDoctors(type);
    }


    private void deleteDoctor() {
        listDoctors();
        if (!doctorAPI.removeDoctor(ScannerInput.readNextInt("Please input a doctor to delete"))) {
            System.out.println("Unable to delete");
        } else System.out.println("Doctor was deleted");

    }

    private int totalFees() {
        return doctorAPI.calculateAnnualFees();
    }

    private String[] contactDetails () {
        String[] contact = new String[5];
        contact[0] =(ScannerInput.validNextLine("Please Input first name and surname of Doctor"));
        contact[1] = (ScannerInput.validNextLine("please input date of birth"));
        contact[2] = (ScannerInput.validNextLine("please input gender"));
        contact[3] = (ScannerInput.validNextLine("please input address"));
        contact[4] = (ScannerInput.validNextLine("Please input contact number"));
        return contact;
    }

    private ArrayList<Qualification> addQualifications(){
        ArrayList<Qualification> qualifications = new ArrayList<>();
        char Qual = 'y';
        while (Qual == 'y' || Qual == 'Y') {
            String degreeType = ScannerInput.validNextLine("please Input Degree Type");
            String degreeName = ScannerInput.validNextLine("Please Input Degree Name");
            String collage = ScannerInput.validNextLine("Please Input Collage Name");
            String conferringYear = ScannerInput.validNextLine("Please Input Conferring Year");
            qualifications.add(new Qualification(degreeType, degreeName, collage, conferringYear));
            Qual = ScannerInput.validNextChar("Do you want to add another qualification? (Y/N)");
        }
        return qualifications;
    }

    private HashSet<String> addSpecialism() {
        char spec = 'y';
        HashSet<String> specialist = new HashSet<>();
        while (spec == 'y' || spec == 'Y') {
            specialist.add(ScannerInput.validNextLine("Please input a specialism"));
            spec = ScannerInput.validNextChar("Do you want to add another specialism? (Y/N)");
        }
        return specialist;

    }

    private boolean qualifiedInIreland() {
        char inIre = ScannerInput.validNextChar("are you qualified in Ireland (Y/N)");
        return (inIre == 'y' || inIre == 'Y');
    }

    private int selectDoctor() {
        int doctor;
        do {
            doctor = ScannerInput.readNextInt("Please Select a Doctor");
        }
        while (!WithinBounds.arrayCheck(doctor, doctorAPI.numberOfDoctors()));
        return doctor;
    }


}
