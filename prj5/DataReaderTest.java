// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peter Kistler (pdblvkis)
package prj5;

import java.io.FileNotFoundException;

/**
 * Test class for DataReader.
 * 
 * @author Matthew Pinho (mpinho16)
 * @author Peter Kistler (pdblvkis)
 * @author Nicholas Cardaci (nicho17)
 * @author Anvitha Nachiappan (anvitha)
 * @version 2019.04.20
 */
public class DataReaderTest extends student.TestCase {
    private DataReader phil;


    /**
     * sets up the testing environment
     * 
     * @throws FileNotFoundException
     */
    public void setUp() throws FileNotFoundException {
        phil = new DataReader("MusicSurveyDataTest1.csv", "SongListTest1.csv");
    } // end setUp


    /**
     * tests the redadSongs method
     * 
     * @throws FileNotFoundException
     */
    public void testReadSongs() throws FileNotFoundException {
        LList songs = phil.getSongs();
        assertEquals(
            "All These Things I've Done, The Killers, 2005, alternative.", songs
                .get(0).toString());
        assertEquals("All You Need Is Love, The Beatles, 1967, pop rock.", songs
            .get(1).toString());
        assertEquals("American Pie, Don McLean, 1971, folk rock.", songs.get(2)
            .toString());
        assertEquals("Anarchy in the UK, The Sex Pistols, 1976, punk.", songs
            .get(3).toString());
        assertEquals("Another One Bites the Dust, Queen, 1980, disco.", phil
            .getSongs().get(4).toString());

        int[][] arr = songs.get(0).getInfo("hobby");

        assertEquals(0, arr[1][0]);
        assertEquals(13, arr[2][0]);
        assertEquals(1, arr[3][0]);
        assertEquals(3, arr[0][0]);
    }

}
