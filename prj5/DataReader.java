package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {

    private LList songBank;
    private HashMap<String, Integer> binary;
    private HashMap<String, Integer> maj;
    private HashMap<String, Integer> stt;
    private HashMap<String, Integer> hob;


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
        songBank = new LList();
        
        binary = new HashMap<String, Integer>();
        binary.put("Yes", 1);
        binary.put("No", 0);
        binary.put("", 0);

        maj = new HashMap<String, Integer>();
        maj.put("reading", 0);
        maj.put("art", 1);
        maj.put("sports", 2);
        maj.put("music", 3);

        stt = new HashMap<String, Integer>();
        stt.put("Southeast", 0);
        stt.put("Northeast", 1);
        stt.put("United States (other than Southeast or Northwest)", 2);
        stt.put("Outside of United States", 3);

        hob = new HashMap<String, Integer>();
        hob.put("Computer Science", 0);
        hob.put("Other Engineering", 1);
        hob.put("Math or CMDA", 2);
        hob.put("Other", 3);
        
        readSongs(songFile);
        readSurveys(surveyFile);
    }
    
    
    /**
     * getter method for the LList of songs
     * 
     * @return the songBank field
     */
    public LList getSongs() {
        return songBank;
    }


    /**
     * reads the data from the SongList2018.csv file
     * 
     * @param fN
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    private void readSongs(String fN) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWee = new Scanner(new File(fN));
        scanWee.nextLine();
        while (scanWee.hasNextLine()) {
            String parcel = scanWee.nextLine();
            String[] parsed = parcel.split(",", -1);
            songBank.add(new Song(parsed[0], parsed[1], parsed[2], parsed[3]));
        } // end while
    }


    /**
     * reads data from the MusicSurveyData2018.csv file
     * 
     * @param fN
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    public void readSurveys(String fN) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWoo = new Scanner(new File(fN));
        scanWoo.nextLine();
        while (scanWoo.hasNextLine()) {
            int cnt = 0;
            String thisGuy = scanWoo.nextLine();
            String[] chopped = thisGuy.split(",", -1);
            
            int majInt = maj.get(chopped[2]);
            int sttInt = maj.get(chopped[3]);
            int hobInt = maj.get(chopped[4]);
            
            for (int i = 5; i < chopped.length; i += 2) {
                songBank.get(cnt).getInfo("major")[majInt][0] += binary.get(
                    chopped[i]);
                songBank.get(cnt).getInfo("major")[majInt][1] += binary.get(
                    chopped[i + 1]);
                songBank.get(cnt).getInfo("state")[sttInt][0] += binary.get(
                    chopped[i]);
                songBank.get(cnt).getInfo("state")[sttInt][1] += binary.get(
                    chopped[i + 1]);
                songBank.get(cnt).getInfo("hobby")[hobInt][0] += binary.get(
                    chopped[i]);
                songBank.get(cnt).getInfo("hobby")[hobInt][1] += binary.get(
                    chopped[i + 1]);
            } // end for i
            cnt++;
        } // end while
    } // end readSurveys
}
