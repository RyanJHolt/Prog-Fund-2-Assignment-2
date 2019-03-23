import models.Qualification;
import models.Specialist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class SpecialistTest {
    Specialist doctorOne, doctorTwo, doctorThree;
    ArrayList<Qualification> qualifications = new ArrayList<>();
    Qualification qualificationOne;
    HashSet<String> specialist = new HashSet<>();


    @Before
    public void setUp() throws Exception {
        //name on boundary 30 chars, valid email, valid phone (leading zero)
        qualificationOne = new Qualification("Masters", "medicine", "Trinity", "1982");
        qualifications.add(qualificationOne);
        specialist.add("test");
        //name on boundary 30 chars, valid genre, valid doctor length, valid Artist
        //Genre must be: Rock, Pop, Blues, Rap, Dance, Classical
        doctorOne = new Specialist("Bob bobert", "20/15/2222", 'm', "seaseme street", "3325", qualifications , true, specialist);
    }

    @After
    public void tearDown() throws Exception {
        doctorOne = doctorTwo = doctorThree = null;
    }

    @Test
    public void validDataInConstructorAccepted(){
        //name on boundary 30 chars, valid genre, valid doctor length, valid Artist
        //Genre must be: Rock, Pop, Blues, Rap, Dance, Classical
        assertEquals("Bob bobert", doctorOne.getName());
        assertEquals("3325", doctorOne.getContactNumber());
        assertEquals("Male", doctorOne.getFullGender());
        assertEquals("20/15/2222", doctorOne.getDob());
        assertEquals(true,doctorOne.isQualifiedInIreland());
        assertEquals("seaseme street",doctorOne.getAddress());
        assertEquals(qualifications,doctorOne.getQualifications());
        assertEquals(specialist,doctorOne.getSpecialist());
    }

    @Test
    public void inValidDataInConstructorDefaultsAssigned() {
        doctorTwo = new Specialist("wda",
                "2", 'w',
                "9", "awd", null, true, null
        );
        assertEquals("Unknown", doctorTwo.getName());
        assertEquals("Unknown", doctorTwo.getDob());
        assertEquals("Unknown", doctorTwo.getFullGender());
        assertEquals("Unknown", doctorTwo.getContactNumber());
    }


    @Test
    public void setDoctorName(){
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
    }

//    @Test
//    public void setdoctorLength() {
//        //valid doctor length set
//        assertEquals(163, doctorOne.getdoctorLength());
//
//        doctorOne.setdoctorLength(10);     //10 (lower boundary)
//        assertEquals(10, doctorOne.getdoctorLength());
//        doctorOne.setdoctorLength(11);     //11 (lower boundary + 1)
//        assertEquals(11, doctorOne.getdoctorLength());
//        doctorOne.setdoctorLength(9);     //9 (lower boundary - 1)
//        assertEquals(11, doctorOne.getdoctorLength());
//
//        doctorOne.setdoctorLength(1200);     //1200 (upper boundary)
//        assertEquals(1200, doctorOne.getdoctorLength());
//        doctorOne.setdoctorLength(1201);     //1201 (upper boundary + 1)
//        assertEquals(1200, doctorOne.getdoctorLength());
//        doctorOne.setdoctorLength(1199);     //1199 (upper boundary - 1)
//        assertEquals(1199, doctorOne.getdoctorLength());
//    }
//
//    @Test
//    public void setdoctorGenre() {
//        assertEquals("ROCK", doctorOne.getdoctorGenre());
//
//        //valid values - genre must be: Rock, Pop, Blues, Rap, Dance, Classical
//        doctorOne.setdoctorGenre("pop");
//        assertEquals("POP", doctorOne.getdoctorGenre());
//        doctorOne.setdoctorGenre("Blues");
//        assertEquals("BLUES", doctorOne.getdoctorGenre());
//        doctorOne.setdoctorGenre("RAP");
//        assertEquals("RAP", doctorOne.getdoctorGenre());
//        doctorOne.setdoctorGenre("danCE");
//        assertEquals("DANCE", doctorOne.getdoctorGenre());
//        doctorOne.setdoctorGenre("CLASSICAL");
//        assertEquals("CLASSICAL", doctorOne.getdoctorGenre());
//
//        //invalid values
//        doctorOne.setdoctorGenre("Jazz");
//        assertEquals("CLASSICAL", doctorOne.getdoctorGenre());
//    }
//
//    @Test
//    public void setArtist() {
//        assertEquals("Artist Name as 30 characters!!", doctorOne.getArtist().getArtistName());
//
//        //set Artist with a value artist object
//        doctorOne.setArtist(new Artist("New Artist", "newbie@artist.com", "23211"));
//        assertEquals("New Artist", doctorOne.getArtist().getArtistName());
//        assertEquals("newbie@artist.com", doctorOne.getArtist().getArtistEmail());
//        assertEquals("23211", doctorOne.getArtist().getArtistPhone());
//
//        //attempt to set Artist with a null object
//        doctorOne.setArtist(null);
//        assertEquals("New Artist", doctorOne.getArtist().getArtistName());
//        assertEquals("newbie@artist.com", doctorOne.getArtist().getArtistEmail());
//        assertEquals("23211", doctorOne.getArtist().getArtistPhone());
//    }
//
//    @Test
//    public void toStringUsesAllFields() {
//        assertThat(doctorOne.toString().contains("012345678901234567890123456789"), is(true));
//        assertThat(doctorOne.toString().contains("ROCK"), is(true));
//        assertThat(doctorOne.toString().contains("" + (int) (163 % 60)), is(true));
//        assertThat(doctorOne.toString().contains("" + (int) (163 / 60)), is(true));
//        assertThat(doctorOne.toString().contains("Artist Name as 30 characters!!"), is(true));
}
