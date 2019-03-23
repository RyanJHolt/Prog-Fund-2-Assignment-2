package models;

/**
 * The type Qualification.
 */
public class Qualification {
    private String degreeType;
    private String degreeName;
    private String collage;
    private String conferringYear;

    /**
     * Instantiates a new Qualification.
     *
     * @param degreeType     the degree type
     * @param degreeName     the degree name
     * @param collage        the collage
     * @param conferringYear the conferring year
     */
    public Qualification(String degreeType, String degreeName, String collage, String conferringYear) {
        this.degreeType = degreeType;
        this.degreeName = degreeName;
        this.collage = collage;
        this.conferringYear = conferringYear;
    }

    /**
     * Gets degree type.
     *
     * @return the degree type
     */
    public String getDegreeType() {
        return degreeType;
    }

    /**
     * Sets degree type.
     *
     * @param degreeType the degree type
     */
    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    /**
     * Gets degree name.
     *
     * @return the degree name
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * Sets degree name.
     *
     * @param degreeName the degree name
     */
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    /**
     * Gets collage.
     *
     * @return the collage
     */
    public String getCollage() {
        return collage;
    }

    /**
     * Sets collage.
     *
     * @param collage the collage
     */
    public void setCollage(String collage) {
        this.collage = collage;
    }

    /**
     * Gets conferring year.
     *
     * @return the conferring year
     */
    public String getConferringYear() {
        return conferringYear;
    }

    /**
     * Sets conferring year.
     *
     * @param conferringYear the conferring year
     */
    public void setConferringYear(String conferringYear) {
        this.conferringYear = conferringYear;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "degreeType='" + degreeType + '\'' +
                ", degreeName='" + degreeName + '\'' +
                ", collage='" + collage + '\'' +
                ", conferringYear='" + conferringYear + '\'' +
                '}';
    }
}
