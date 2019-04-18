package prj5;

import java.io.FileNotFoundException;

public class Input {


    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                new DataReader(args[0], args[1]);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                new DataReader("MusicSurveyData2018.csv", "SongList2018.csv");
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
