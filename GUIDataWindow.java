package prj5;

import CS2114.Button;
import CS2114.TextShape;
import CS2114.Window;

public class GUIDataWindow {
    private Window window;
    private Button quit;
    private Button next;
    private Button previous;
    private Button representByHobby;
    private Button representByMajor;
    private Button representByState;
    private Button sortByArtistName;
    private Button sortBySongTitle;
    private Button sortByReleaseYear;
    private Button sortByGenre;
    private TextShape legend;


    public GUIDataWindow() {
        // create window
        window = new Window("Song Survey Visualization");

        // create buttons
        quit = new Button("Quit");
        previous = new Button("<-- Prev");
        next = new Button("Next -->");
        representByHobby = new Button("Represent Hobby");
        representByMajor = new Button("Represent Major");
        representByState = new Button("Represent State");
        sortByArtistName = new Button("Sort by Artist Name");
        sortBySongTitle = new Button("Sort by Song Title");
        sortByReleaseYear = new Button("Sort by Release Year");

    }

}
