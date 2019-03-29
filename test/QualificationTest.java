import models.Qualification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QualificationTest {

    Qualification qualificationOne, qualificationTwo, qualificationThree;

    @Before
    public void setUp() throws Exception {
        qualificationOne = new Qualification("PHD",
                "rock","WIT","2008");
    }

    @After
    public void tearDown() throws Exception {
        qualificationOne = qualificationTwo = qualificationThree = null;
    }

    @Test
    public void validDataInConstructorAccepted() {
        assertEquals("WIT", qualificationOne.getCollage());
        assertEquals("2008", qualificationOne.getConferringYear());
        assertEquals("rock", qualificationOne.getDegreeName());
        assertEquals("PHD", qualificationOne.getDegreeType());
    }


    @Test
    public void inValidDataInConstructorDefaultsAssigned() {
        //name (0 chars), invalid genre, invalid qualification length (<10), null artist
        qualificationTwo = new Qualification("ADW",
                "654",
                "9", "4");
        assertEquals("9", qualificationTwo.getCollage());
        assertEquals("Unknown", qualificationTwo.getConferringYear());
        assertEquals("Unknown", qualificationTwo.getDegreeName());
        assertEquals("ADW", qualificationTwo.getDegreeType());
    }


    @Test
    public void setQualificationDegreeType() {
        //name on boundary 30 chars
        assertEquals("PHD", qualificationOne.getDegreeType());

        qualificationOne.setDegreeType("01234567890123456789012345678");   //29 chars
        assertEquals("01234567890123456789012345678", qualificationOne.getDegreeType());

        qualificationOne.setDegreeType("012345678901234567890123456789");  //30 chars
        assertEquals("012345678901234567890123456789", qualificationOne.getDegreeType());

        qualificationOne.setDegreeType("0123456789012345678901234567890"); //31 chars
        assertEquals("0123456789012345678901234567890", qualificationOne.getDegreeType());
    }

//    @Test
//    public void setQualificationLength() {
//        //valid qualification length set
//        assertEquals(163, qualificationOne.getQualificationLength());
//
//        qualificationOne.setQualificationLength(10);     //10 (lower boundary)
//        assertEquals(10, qualificationOne.getQualificationLength());
//        qualificationOne.setQualificationLength(11);     //11 (lower boundary + 1)
//        assertEquals(11, qualificationOne.getQualificationLength());
//        qualificationOne.setQualificationLength(9);     //9 (lower boundary - 1)
//        assertEquals(11, qualificationOne.getQualificationLength());
//
//        qualificationOne.setQualificationLength(1200);     //1200 (upper boundary)
//        assertEquals(1200, qualificationOne.getQualificationLength());
//        qualificationOne.setQualificationLength(1201);     //1201 (upper boundary + 1)
//        assertEquals(1200, qualificationOne.getQualificationLength());
//        qualificationOne.setQualificationLength(1199);     //1199 (upper boundary - 1)
//        assertEquals(1199, qualificationOne.getQualificationLength());
//    }
//
//    @Test
//    public void setQualificationGenre() {
//        assertEquals("ROCK", qualificationOne.getQualificationGenre());
//
//        //valid values - genre must be: Rock, Pop, Blues, Rap, Dance, Classical
//        qualificationOne.setQualificationGenre("pop");
//        assertEquals("POP", qualificationOne.getQualificationGenre());
//        qualificationOne.setQualificationGenre("Blues");
//        assertEquals("BLUES", qualificationOne.getQualificationGenre());
//        qualificationOne.setQualificationGenre("RAP");
//        assertEquals("RAP", qualificationOne.getQualificationGenre());
//        qualificationOne.setQualificationGenre("danCE");
//        assertEquals("DANCE", qualificationOne.getQualificationGenre());
//        qualificationOne.setQualificationGenre("CLASSICAL");
//        assertEquals("CLASSICAL", qualificationOne.getQualificationGenre());
//
//        //invalid values
//        qualificationOne.setQualificationGenre("Jazz");
//        assertEquals("CLASSICAL", qualificationOne.getQualificationGenre());
//    }
//
//    @Test
//    public void setArtist() {
//        assertEquals("Artist Name as 30 characters!!", qualificationOne.getArtist().getArtistName());
//
//        //set Artist with a value artist object
//        qualificationOne.setArtist(new Artist("New Artist", "newbie@artist.com", "23211"));
//        assertEquals("New Artist", qualificationOne.getArtist().getArtistName());
//        assertEquals("newbie@artist.com", qualificationOne.getArtist().getArtistEmail());
//        assertEquals("23211", qualificationOne.getArtist().getArtistPhone());
//
//        //attempt to set Artist with a null object
//        qualificationOne.setArtist(null);
//        assertEquals("New Artist", qualificationOne.getArtist().getArtistName());
//        assertEquals("newbie@artist.com", qualificationOne.getArtist().getArtistEmail());
//        assertEquals("23211", qualificationOne.getArtist().getArtistPhone());
//    }
//
//    @Test
//    public void toStringUsesAllFields() {
//        assertThat(qualificationOne.toString().contains("012345678901234567890123456789"), is(true));
//        assertThat(qualificationOne.toString().contains("ROCK"), is(true));
//        assertThat(qualificationOne.toString().contains("" + (int)(163 % 60)), is(true));
//        assertThat(qualificationOne.toString().contains("" + (int)(163 / 60)), is(true));
//        assertThat(qualificationOne.toString().contains("Artist Name as 30 characters!!"), is(true));
//    }
}