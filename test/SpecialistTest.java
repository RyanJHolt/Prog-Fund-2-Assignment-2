import models.General;
import models.Intern;
import models.Qualification;
import models.Specialist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SpecialistTest {

    Specialist doctorOne, doctorTwo, doctorThree;
    ArrayList<Qualification> qualifications = new ArrayList<>();
    Qualification qualificationOne;
    HashSet<String> specialOne;

    @BeforeEach
    void setUp() {
        qualificationOne = new Qualification("Masters", "medicine", "Trinity", "1982");
        qualifications.add(qualificationOne);
        doctorOne = new Specialist("Bob bobert", "20/15/2222", 'u', "seaseme street", "3325", qualifications ,true,specialOne);
    }

    @AfterEach
    void tearDown() {
        doctorOne = null;
        qualificationOne = null;
        specialOne = null;
    }

    @Test
    void calcRegistrationFee() {
        doctorOne.setQualifiedInIreland(true);
        assertEquals(425,doctorOne.calcRegistrationFee());
    }

    @Test
    void getSpecialist() {
    }

    @Test
    void setSpecialist() {
    }

    @Test
    void testToString() {
    }
}