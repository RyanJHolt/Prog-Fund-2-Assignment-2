package models;

import java.util.ArrayList;

/**
 * The type Doctor.
 */
public abstract class Doctor implements iDoctor{

    private String name;
    private String dob;
    private Character gender;
    private String address;
    private String contactNumber;
    private ArrayList<Qualification> qualifications;

    /**
     * Instantiates a new Doctor.
     *
     * @param name           the name
     * @param dob            the dob
     * @param gender         the gender
     * @param address        the address
     * @param contactNumber  the contact number
     * @param qualifications the qualifications
     */
    public Doctor(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications) {
        if (name.matches("[a-zA-Z]+\\s[a-zA-z]+")){
            this.name = name;
        } else this.name = "Unknown";
        if (dob.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
            this.dob = dob;
        } else this.dob = "Unknown";
        if (gender.equals('m')||gender.equals('f')) {
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

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        if (name.matches("[a-zA-Z]+\\s[a-zA-z]+")){
            this.name = name;
        }
    }

    /**
     * Gets dob.
     *
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets dob.
     *
     * @param dob the dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Character getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Character gender) {
        this.gender = gender;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets contact number.
     *
     * @return the contact number
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets contact number.
     *
     * @param contactNumber the contact number
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets qualifications.
     *
     * @return the qualifications
     */
    public ArrayList<Qualification> getQualifications() {
        return qualifications;
    }

    /**
     * Sets qualifications.
     *
     * @param qualifications the qualifications
     */
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
