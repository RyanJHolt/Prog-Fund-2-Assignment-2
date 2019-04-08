package models;

public class Qualification {
    private String degreeType;
    private String degreeName;
    private String collage;
    private String conferringYear;

    public Qualification(String degreeType, String degreeName, String collage, String conferringYear) {

        this.degreeType = degreeType;
        if (degreeName.matches("[a-zA-Z ]*")){
            this.degreeName = degreeName;
        } else this.degreeName = "Unknown";
        this.collage = collage;
        if (conferringYear.matches("[0-9][0-9][0-9][0-9]")) {
            this.conferringYear = conferringYear;
        } else this.conferringYear = "Unknown";
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        if (degreeName.matches("[a-zA-Z ]*")){
            this.degreeName = degreeName;
        }
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getConferringYear() {
        return conferringYear;
    }

    public void setConferringYear(String conferringYear) {
        if (conferringYear.matches("[0-9][0-9][0-9][0-9]")) {
            this.conferringYear = conferringYear;
        }
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
