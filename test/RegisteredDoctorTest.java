import models.Doctor;
import models.General;
import models.Intern;
import models.Qualification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegisteredDoctorTest {
    General doctorOne, doctorTwo;
    ArrayList<Qualification> qualifications = new ArrayList<>();
    Qualification qualificationOne;

    @BeforeEach
    void setUp() {
        qualificationOne = new Qualification("Masters", "medicine", "Trinity", "1982");
        qualifications.add(qualificationOne);
        doctorOne = new General("Bob bobert", "20/15/2222", 'u', "seaseme street", "3325", qualifications ,true);
    }

    @AfterEach
    void tearDown() {
         doctorOne = doctorTwo = null;
    }

    @Test
    void setQualifiedInIreland() {
        assertEquals(true, doctorOne.isQualifiedInIreland());

        doctorOne.setQualifiedInIreland(false); //31 chars
        assertEquals(false, doctorOne.isQualifiedInIreland());

        doctorOne.setQualifiedInIreland(true); //31 chars
        assertEquals(true, doctorOne.isQualifiedInIreland());
    }


    @Test
    void toStringTest() {
        assertThat(doctorOne.toString().contains("true"), is(true));
    }
}