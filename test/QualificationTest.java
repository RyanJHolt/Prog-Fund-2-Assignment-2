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
                "roc654",
                "9", "4");
        assertEquals("9", qualificationTwo.getCollage());
        assertEquals("Unknown", qualificationTwo.getConferringYear());
        assertEquals("Unknown", qualificationTwo.getDegreeName());
        assertEquals("ADW", qualificationTwo.getDegreeType());
    }


    @Test
    public void setQualificationDegreeName() {
        assertEquals("rock", qualificationOne.getDegreeName());

        qualificationOne.setDegreeName("health");   //29 chars
        assertEquals("health", qualificationOne.getDegreeName());

        qualificationOne.setDegreeName("Med Science");  //30 chars
        assertEquals("Med Science", qualificationOne.getDegreeName());

        qualificationOne.setDegreeType("54"); //31 chars
        assertEquals("Med Science", qualificationOne.getDegreeName());
    }

    @Test
    public void setQualificationConferringYear() {
        assertEquals("2008", qualificationOne.getConferringYear());

        qualificationOne.setConferringYear("54");   //29 chars
        assertEquals("2008", qualificationOne.getConferringYear());

        qualificationOne.setConferringYear("413");  //30 chars
        assertEquals("2008", qualificationOne.getConferringYear());

        qualificationOne.setConferringYear("3212"); //31 chars
        assertEquals("3212", qualificationOne.getConferringYear());
    }



    @Test
    public void toStringUsesAllFields() {
        assertThat(qualificationOne.toString().contains("2008"), is(true));
        assertThat(qualificationOne.toString().contains("rock"), is(true));
        assertThat(qualificationOne.toString().contains("WIT"), is(true));
        assertThat(qualificationOne.toString().contains("PHD"), is(true));

    }
}