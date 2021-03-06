// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nicholas Cardaci (nicho17)
// -- Peter Kistler (pdblvkis)
// -- Anvitha Nachiappan (anvitha)
// -- Matthew Pinho (mpinho16)s
package prj5;

/**
 * This is the SongTest class. Tests the song class to ensure it acts as
 * expected.
 * 
 * @author Anvitha Nachiappan <anvitha>
 * @author Nicholas Cardaci <nicho17>
 * @author Matthew Pinho <mpinho16>
 * @author Peter Kistler <pdblvkis>
 *
 * @version 4/19/2019
 */
public class SongTest extends student.TestCase {
    private Song s;


    /**
     * sets up a song object to be tested later
     */
    public void setUp() {
        s = new Song("Hotline Bling", "Drake", "2015", "R&B");
    }


    /**
     * Tests the getTitle method to ensure it acts as expected
     */
    public void testGetTitle() {
        assertEquals(s.getTitle(), "Hotline Bling");
    }


    /**
     * Tests the getArtist method to ensure it acts as expected
     */
    public void testGetArtist() {
        assertEquals(s.getArtist(), "Drake");
    }


    /**
     * Tests the getYear method to ensure it acts as expected
     */
    public void testGetYear() {
        assertEquals(s.getYear(), "2015");
    }


    /**
     * Tests the getGenre method to ensure it acts as expected
     */
    public void testGetGenre() {
        assertEquals(s.getGenre(), "R&B");
    }


    /**
     * Tests the toString method to ensure it acts as expected
     */
    public void testToString() {
        assertEquals(s.toString(), "song title Hotline Bling\r\n"
            + "song artist Drake\r\n" + "song genre R&B\r\n"
            + "song year 2015");
    }


    /**
     * Tests getInfo to ensure it acts as expected
     */
    public void testGetInfo() {
        assertNotNull(s.getInfo("major"));
        assertNotNull(s.getInfo("state"));
        assertNotNull(s.getInfo("hobby"));
        assertNull(s.getInfo("hi"));
    }


    /**
     * Tests the equals method to ensure it acts as expected
     */
    public void testEquals() {
        Object obj = new Object();
        assertFalse(obj.equals(s));
        obj = null;
        assertFalse(s.equals(obj));
        assertTrue(s.equals(s));
        Song song = new Song("Hotline Bling", "Drake", "2015", "R&B");
        assertTrue(s.equals(song));
        Song song1 = new Song("Hotline Bling", "Drake", "2011", "R&B");
        assertFalse(s.equals(song1));
        Song song2 = new Song("Hotline Blong", "Drake", "2015", "R&B");
        assertFalse(s.equals(song2));
        assertFalse(s.equals(4));
        Song song4 = new Song("Hotline ", "Drake", "2011", "R&B");
        Song song5 = new Song("Hotline Blong", "D", "2011", "R&B");
        Song song6 = new Song("Hotline Blong", "Drake", "2", "R&B");
        Song song7 = new Song("Hotline Blong", "Drake", "2015", "R");
        assertFalse(s.equals(song4));
        assertFalse(s.equals(song5));
        assertFalse(s.equals(song6));
        assertFalse(s.equals(song7));
    }
}
