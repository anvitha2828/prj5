package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {

    private LList songBank;
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
    public DataReader(String surveyFile, String songFile)
        throws FileNotFoundException {
        songBank = new LList();

        /*
         * Each of the HashMaps maps a scanned-in String to an integer value
         * (row number)
         * corresponding to the ENUM value in the array. The empty String ("")
         * maps to the last row in the array, which will never be used.
         */
        maj = new HashMap<String, Integer>();
        maj.put("Computer Science", 0);
        maj.put("Other Engineering", 1);
        maj.put("Math or CMDA", 2);
        maj.put("Other", 3);
        maj.put("", 4);

        stt = new HashMap<String, Integer>();
        stt.put("Southeast", 0);
        stt.put("Northeast", 1);
        stt.put("United States (other than Southeast or Northwest)", 2);
        stt.put("Outside of United States", 3);
        stt.put("", 4);

        hob = new HashMap<String, Integer>();
        hob.put("reading", 0);
        hob.put("art", 1);
        hob.put("sports", 2);
        hob.put("music", 3);
        hob.put("", 4);

        readSongs(songFile);
        readSurveys(surveyFile);
        songBank.sortBy("genre");
        printSongs();
        songBank.sortBy("title");
        printSongs();
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
     * @param filename
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    private void readSongs(String filename) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWee = new Scanner(new File(filename));
        scanWee.nextLine();
        while (scanWee.hasNextLine()) {
            String parcel = scanWee.nextLine();
            String[] parsed = parcel.split(",", -1);
            songBank.add(new Song(parsed[0], parsed[1], parsed[2], parsed[3]));
        } // end while
    }


    /**
     * Reads data from the MusicSurveyData2018.csv file.
     * 
     * @param filename
     *            The name of the file to read.
     * @throws FileNotFoundException
     */
    private void readSurveys(String filename) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanWoo = new Scanner(new File(filename));
        scanWoo.nextLine();
        while (scanWoo.hasNextLine()) {
            addSongInfo(scanWoo.nextLine()); // single song
        } // end while
    } // end readSurveys


    /**
     * Takes an String input corresponding to a SINGLE student response, and
     * updates the survey results for each song, correspondingly.
     * 
     * @param str
     *            One whole line in the file, corresponding to ONE student
     *            response.
     */
    private void addSongInfo(String str) {
        String[] chopped = str.split(",", -1);
        int majVal = maj.get(chopped[2]);
        int sttVal = stt.get(chopped[3]);
        int hobVal = hob.get(chopped[4]);

        Song song;
        int songNum = 0;

        // Each i corresponds to ONE song.
        for (int i = 5; i < chopped.length; i += 2) {
            song = songBank.get(songNum);
            // Heard: Yes
            if (chopped[i].equals("Yes")) {
                song.getInfo("major")[majVal][0]++;
                song.getInfo("state")[sttVal][0]++;
                song.getInfo("hobby")[hobVal][0]++;
            }
            // Heard: No
            else if (chopped[i].equals("No")) {
                song.getInfo("major")[majVal][2]++;
                song.getInfo("state")[sttVal][2]++;
                song.getInfo("hobby")[hobVal][2]++;
            }
            // Liked: Yes
            if (chopped[i + 1].equals("Yes")) {
                song.getInfo("major")[majVal][1]++;
                song.getInfo("state")[sttVal][1]++;
                song.getInfo("hobby")[hobVal][1]++;
            }
            // Liked: No
            else if (chopped[i + 1].equals("No")) {
                song.getInfo("major")[majVal][3]++;
                song.getInfo("state")[sttVal][3]++;
                song.getInfo("hobby")[hobVal][3]++;
            }
            
            songNum++;
        }
    }


    private void print(Song song) {
        StringBuilder builder = new StringBuilder();
        System.out.println("Song Title: " + song.getTitle());
        System.out.println("Song Artist: " + song.getArtist());
        System.out.println("Song Genre: " + song.getGenre());
        System.out.println("Song Year: " + song.getYear());

        System.out.println("Heard");
        builder.append("reading:" + percent(song, 0, 0));
        builder.append(" art:" + percent(song, 1, 0));
        builder.append(" sports:" + percent(song, 2, 0));
        builder.append(" music:" + percent(song, 3, 0));

        System.out.println(builder.toString());
        builder = new StringBuilder();

        System.out.println("Likes");
        builder.append("reading:" + percent(song, 0, 1));
        builder.append(" art:" + percent(song, 1, 1));
        builder.append(" sports:" + percent(song, 2, 1));
        builder.append(" music:" + percent(song, 3, 1));

        System.out.println(builder.toString());
        System.out.println();
    }


    private int percent(Song song, int i, int j) {
        int[][] arr = song.getInfo("hobby");
        double yes = arr[i][j];
        double no = arr[i][j + 2];

        if (yes == 0 && no == 0) {
            return 0;
        }

        return (int)(yes / (yes + no) * 100);
    }


    private void printSongs() {
        for (int i = 0; i < songBank.size(); i++) {
            print(songBank.get(i));
        }
    }
}