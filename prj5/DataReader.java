package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReader {

    private LListSong<Song> songBank;


    /**
     * creates a new DataReader object to read the heckin data
     * 
     * @param songFile
     *            the list of songs for which data was collected
     * @param surveyFile
     *            the results of the data collection survey
     * @throws FileNotFoundException
     */
    public DataReader(String songFile, String surveyFile)
        throws FileNotFoundException {
        songBank = new LListSong<Song>();
        readSongs(songFile);
        readSurveys(surveyFile);
    }


    /**
     * reads the data from the SongList2018.csv file
     * 
     * @param fN
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    public LListSong<Song> readSongs(String fN) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWee = new Scanner(new File(fN));
        scanWee.nextLine();
        while (scanWee.hasNextLine()) {
            String parcel = scanWee.nextLine();
            String[] parsed = parcel.split(", *", -1);
            songBank.add(new Song(parsed[0], parsed[1], Integer.parseInt(
                parsed[2]), parsed[3]));
        }
        return songBank;
    }


    /**
     * reads data from the MusicSurveyData2018.csv file
     * 
     * @param fN
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    private void readSurveys(String fN) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWoo = new Scanner(new File(fN));
        int one = scanWoo.nextInt();
    }
}
