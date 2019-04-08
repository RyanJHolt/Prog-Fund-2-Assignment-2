package models;

import java.util.ArrayList;

/**
 * The type Intern.
 */
public class Intern extends Doctor {
    /**
     * Instantiates a new Intern.
     *
     * @param name           the name
     * @param dob            the dob
     * @param gender         the gender
     * @param address        the address
     * @param contactNumber  the contact number
     * @param qualifications the qualifications
     */
    public Intern(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications) {
        super(name, dob, gender, address, contactNumber, qualifications);
    }

    public  double calcRegistrationFee(){
        return 310;
    }

    @Override
    public String toString() {
        return "Intern Doctor{ " + "\'" +
                super.toString() + "\'" +
                "RegistrationFee " + calcRegistrationFee() + " \'" +
                " } " ;
    }
}
