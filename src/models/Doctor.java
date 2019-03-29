package models;

import java.util.ArrayList;

public abstract class Doctor implements iDoctor{

    private String name;
    private String dob;
    private Character gender;
    private String address;
    private String contactNumber;
    private ArrayList<Qualification> qualifications;

    public Doctor(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications) {
        if (name.matches("[a-zA-Z]+\\s[a-zA-z]+")){
            this.name = name;
        } else this.name = "Unknown";
        if (dob.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
            this.dob = dob;
        } else this.dob = "Unknown";
        if (gender.equals('m')||gender.equals('f')||gender.equals('M')||gender.equals('F')) {
            if (gender.equals('M')){
                gender = 'm';
            } else if (gender.equals('F')) {
                gender = 'f';
            }
            this.gender = gender;
        } else this.gender = 'u';
        this.address = address;
        if (contactNumber.matches("[0-9]+")) {
            this.contactNumber = contactNumber;
        } else this.contactNumber = "Unknown";
            this.qualifications = qualifications;
    }

    public String viewContactDetails(){
        return "Name: " + name +
                ", Dob: " + dob +
                ", Gender " + getFullGender() +
                ", Address: " + address +
                ", Contact Number: " + contactNumber + "\n";
    }

    public String getFullGender() {
        switch (gender) {
            case 'f':
                return "Female";
            case 'm':
                return "Male";
            default:
                return "Unknown";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("[a-zA-Z]+\\s[a-zA-z]+")){
            this.name = name;
        }
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        if (dob.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
            this.dob = dob;
        }
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        if (gender.equals('m')||gender.equals('f')||gender.equals('M')||gender.equals('F')) {
            if (gender.equals('M')) {
                gender = 'm';
            } else if (gender.equals('F')) {
                gender = 'f';
            }
            this.gender = gender;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        if (contactNumber.matches("[0-9]+")) {
            this.contactNumber = contactNumber;
        }
    }

    public ArrayList<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(ArrayList<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return viewContactDetails() + "\'" +
                ", contactNumber " + contactNumber + " \'" +
                ", qualifications " + qualifications + " \'";
    }
}
