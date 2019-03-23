package models;

import java.util.ArrayList;

/**
 * The type Registered doctor.
 */
public abstract class RegisteredDoctor extends Doctor {
    private boolean qualifiedInIreland;

    /**
     * Instantiates a new Registered doctor.
     *
     * @param name               the name
     * @param dob                the dob
     * @param gender             the gender
     * @param address            the address
     * @param contactNumber      the contact number
     * @param qualifications     the qualifications
     * @param qualifiedInIreland the qualified in ireland
     */
    public RegisteredDoctor(String name, String dob, Character gender, String address, String contactNumber, ArrayList<Qualification> qualifications, boolean qualifiedInIreland) {
        super(name, dob, gender, address, contactNumber, qualifications);
        this.qualifiedInIreland = qualifiedInIreland;
    }

    /**
     * Is qualified in ireland boolean.
     *
     * @return the boolean
     */
    public boolean isQualifiedInIreland() {
        return qualifiedInIreland;
    }

    /**
     * Sets qualified in ireland.
     *
     * @param qualifiedInIreland the qualified in ireland
     */
    public void setQualifiedInIreland(boolean qualifiedInIreland) {
        this.qualifiedInIreland = qualifiedInIreland;
    }

    @Override
    public String toString() {
        return super.toString() +
                "qualifiedInIreland" + qualifiedInIreland + "\' ";
    }
}
