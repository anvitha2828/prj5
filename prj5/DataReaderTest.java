// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Peter Kistler (pdblvkis)
package prj5;

import java.io.FileNotFoundException;

/**
 * Tests the DataReader class.
 *
 * @author Peter Kistler (pdblvkis)
 * @version 04/16/2019
 */
public class DataReaderTest extends student.TestCase {

    private DataReader phil;


    /**
     * sets up the testing environment
     */
    public void setUp() {
        try {
            phil = new DataReader("MusicSurveyData2018.csv",
                "SongList2018.csv");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } // end catch
    } // end setUp


    /**
     * tests the readSongs method
     * 
     * @throws FileNotFoundException
     */
    public void testReadSongs() throws FileNotFoundException {
        assertEquals("song title Hotline Bling/n" + "Drake, 2015, R&B.", phil.getSongs().get(0)
            .toString());
        assertEquals("Creep, Radiohead, 1992, Alternative.", phil.getSongs()
            .get(1).toString());
        assertEquals("All of Me, John Legend, 2013, R&B.", phil.getSongs().get(
            2).toString());
        assertEquals("My Heart Will Go On, Celine Dion, 1997, Pop.", phil
            .getSongs().get(3).toString());

        assertEquals(
            "The Flight of the Bumblebee, Rimsky-Korsakov, 1899, Classical.",
            phil.getSongs().get(71).toString());
    }

}
