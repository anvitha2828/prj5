package prj5;

public class SongTest extends student.TestCase {
    private Song s;


    /**
     * sets up a song object to be tested later
     */
    public void setUp() {
        s = new Song("Hotline Bling", "Drake", 2015, "R&B");
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
        assertEquals(s.getYear(), 2015);
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
        assertEquals(s.toString(), "Hotline Bling, Drake, 2015, R&B.");
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
        Song song = new Song("Hotline Bling", "Drake", 2015, "R&B");
        assertTrue(s.equals(song));
        Song song1 = new Song("Hotline Bling", "Drake", 2011, "R&B");
        assertFalse(s.equals(song1));
        Song song2 = new Song("Hotline Blong", "Drake", 2015, "R&B");
        assertFalse(s.equals(song2));

    }
}
