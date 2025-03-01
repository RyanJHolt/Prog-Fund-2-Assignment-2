import models.Intern;
import models.Qualification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class DoctorTest {
    Intern doctorOne, doctorTwo, doctorThree;
    ArrayList<Qualification> qualifications = new ArrayList<>();
    Qualification qualificationOne;


    @Before
    public void setUp() throws Exception {
        qualificationOne = new Qualification("Masters", "medicine", "Trinity", "1982");
        qualifications.add(qualificationOne);
        doctorOne = new Intern("Bob bobert", "20/15/2222", 'u', "seaseme street", "3325", qualifications);
    }

    @After
    public void tearDown() throws Exception {
        doctorOne = doctorTwo = doctorThree = null;
    }

    @Test
    public void validDataInConstructorAccepted() {
        assertEquals("Bob bobert", doctorOne.getName());
        assertEquals("3325", doctorOne.getContactNumber());
        assertEquals("Unknown", doctorOne.getFullGender());
        assertEquals("20/15/2222", doctorOne.getDob());
        assertEquals("seaseme street", doctorOne.getAddress());
        assertEquals(qualifications, doctorOne.getQualifications());
    }

    @Test
    public void inValidDataInConstructorDefaultsAssigned() {
        doctorTwo = new Intern("wda",
                "2", 'w',
                "9", "awd", null);
        assertEquals("Unknown", doctorTwo.getName());
        assertEquals("Unknown", doctorTwo.getDob());
        assertEquals("Unknown", doctorTwo.getFullGender());
        assertEquals("Unknown", doctorTwo.getContactNumber());
    }


    @Test
    public void setDoctorName() {
        //space between words
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName("BobBobert");   //One Word
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName("BobBobert ");   //One Word Space at End
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName(" BobBobert");   //One Word Space at Beginning
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName("");  //No letters
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName("Bob bobert bob"); //3 words
        assertEquals("Bob bobert", doctorOne.getName());

        doctorOne.setName("Bill Potts"); //3 words
        assertEquals("Bill Potts", doctorOne.getName());
    }

    @Test
    public void setdoctorDob() {
        //valid doctor length set
        assertEquals("20/15/2222", doctorOne.getDob());

        doctorOne.setDob("20/15/22");     // 2 for year
        assertEquals("20/15/2222", doctorOne.getDob());
        doctorOne.setDob("2/15/2222");     // 1 for day
        assertEquals("20/15/2222", doctorOne.getDob());
        doctorOne.setDob("20/1/2222");     // 1 for month
        assertEquals("20/15/2222", doctorOne.getDob());

        doctorOne.setDob("20152222");     // no slashes
        assertEquals("20/15/2222", doctorOne.getDob());
        doctorOne.setDob("2022/15/22");     // reverse order
        assertEquals("20/15/2222", doctorOne.getDob());
        doctorOne.setDob("2015/2222");     //one slash (
        assertEquals("20/15/2222", doctorOne.getDob());
        doctorOne.setDob("AB/WA/EFAS");     //one slash (
        assertEquals("20/15/2222", doctorOne.getDob());
    }

    @Test
    public void setdoctorGender() {
        assertEquals("Unknown", doctorOne.getFullGender());

        //valid values - genre must be: Rock, Pop, Blues, Rap, Dance, Classical
        doctorOne.setGender('F');
        assertEquals("Female", doctorOne.getFullGender());
        doctorOne.setGender('f');
        assertEquals("Female", doctorOne.getFullGender());
        doctorOne.setGender('M');
        assertEquals("Male", doctorOne.getFullGender());
        doctorOne.setGender('a');
        assertEquals("Male", doctorOne.getFullGender());
        doctorOne.setGender('m');
        assertEquals("Male", doctorOne.getFullGender());
        doctorOne.setGender('u');
        assertEquals("Male", doctorOne.getFullGender());
    }


    @Test
    public void toStringUsesAllFields() {
        assertThat(doctorOne.toString().contains("Bob"), is(true));
        assertThat(doctorOne.toString().contains("3325"), is(true));
        assertThat(doctorOne.toString().contains("Unknown"), is(true));
        assertThat(doctorOne.toString().contains("20/15/2222"), is(true));
        assertThat(doctorOne.toString().contains("seaseme street"), is(true));
    }
}

