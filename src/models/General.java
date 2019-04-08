package models;

import java.util.ArrayList;

/**
 * The type General.
 */
public class General extends RegisteredDoctor {

    /**
     * Instantiates a new General.
     *
     * @param name               the name
     * @param dob                the dob
     * @param gender             the gender
     * @param address            the address
     * @param contactNumber      the contact number
     * @param qualifications     the qualifications
     * @param qualifiedInIreland the qualified in ireland
     */
    public General(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland) {
        super(name, dob, gender, address, contactNumber, qualifications, qualifiedInIreland);
    }

    public double calcRegistrationFee(){
        if (isQualifiedInIreland()){
            return 194;
        } else return 410;
    }

    @Override
    public String toString() {
        return "General Doctor{" + " \' " +
                super.toString() +
                "Registration Fee: " + calcRegistrationFee() + "\'" +
                "}";
    }
}
