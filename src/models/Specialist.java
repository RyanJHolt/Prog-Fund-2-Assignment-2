package models;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The type Specialist.
 */
public class Specialist extends RegisteredDoctor implements iDoctor {
    private HashSet<String> specialist;

    /**
     * Instantiates a new Specialist.
     *
     * @param name               the name
     * @param dob                the dob
     * @param gender             the gender
     * @param address            the address
     * @param contactNumber      the contact number
     * @param qualifications     the qualifications
     * @param qualifiedInIreland the qualified in ireland
     * @param specialist         the specialist
     */
    public Specialist(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland, HashSet<String> specialist) {
        super(name, dob, gender, address, contactNumber, qualifications, qualifiedInIreland);
        this.specialist = specialist;
    }

    public double calcRegistrationFee(){
        if (isQualifiedInIreland()){
            return 425;
        } else return 641;
    }

    /**
     * Gets specialist.
     *
     * @return the specialist
     */
    public HashSet<String> getSpecialist() {
        return specialist;
    }

    /**
     * Sets specialist.
     *
     * @param specialist the specialist
     */
    public void setSpecialist(HashSet<String> specialist) {
        this.specialist = specialist;
    }


    @Override
    public String toString() {
        return "Specialist Doctor{" + "\'" +
                super.toString() +
                "specialist=" + specialist + "\'" +
                "RegistrationFee" + calcRegistrationFee() + "\'" +
                "}";
    }
}
