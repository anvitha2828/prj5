// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nicholas Cardaci (nicho17)
// -- Peter Kistler (pdblvkis)
// -- Anvitha Nachiappan (anvitha)
// -- Matthew Pinho (mpinho16)
package prj5;

import java.io.FileNotFoundException;

/**
 * Project runner.
 * 
 * @author Matthew Pinho (mpinho16)
 * @author Peter Kistler (pdblvkis)
 * @author Nicholas Cardaci (nicho17)
 * @author Anvitha Nachiappan (anvitha)
 * @version 2019.04.20
 */
public class Input {
    /**
     * Starts the GUI.
     * 
     * @param args
     *            Relevant filenames.
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 2) {
            new GUIDataWindow(new DataReader(args[0], args[1]));
        }
        else {
            new GUIDataWindow(new DataReader("MusicSurveyData2018.csv",
                "SongList2018.csv"));
        }
    }
}