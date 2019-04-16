package prj5;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * 
 * @author Matthew Pinho
 *
 */
public class GUIDataWindow {
    // private Sorter s;
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
    private int pageNumber; // starts at 0.
    private String represent;
    private final int columnWidth = 10;
    private final int columnHeight = 40;
    private final int lastPage = Math.ceil(list.getSize() / 9);
    private final int barWidth = 10;
    private LList list;
    private int[][] demographics;

    /**
     * 
     * @param songs
     */
    public GUIDataWindow(LList songs) {
        represent = "hobby";
        list = songs;

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
        sortByGenre = new Button("Sort by Genre");

        // add to window
        window.addButton(quit, WindowSide.SOUTH);
        window.addButton(previous, WindowSide.NORTH);
        window.addButton(representByState, WindowSide.SOUTH);
        window.addButton(representByMajor, WindowSide.SOUTH);
        window.addButton(representByHobby, WindowSide.SOUTH);
        window.addButton(sortByArtistName, WindowSide.NORTH);
        window.addButton(sortByGenre, WindowSide.NORTH);
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        window.addButton(sortBySongTitle, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        sortBySongTitle.onClick("clickedSortBySongTitle");
        sortByReleaseYear.onClick("clickedSortBySongTitle");
        sortByGenre.onClick("clickedSortBySongTitle");
        sortByArtistName.onClick("clickedSortBySongTitle");
        quit.onClick("clickedQuit");
        previous.onClick("clickedPrevious");
        next.onClick("clickedNext");
        representByState.onClick("clickedRepresentByState");
        representByMajor.onClick("clickedRepresentByMajor");
        representByHobby.onClick("clickedRepresentByHobby");

        update();
    }

    /**
     * 
     */
    public void clickedSortBySongTitle() {
        list.sortBy("title");
        update();
    }

    /**
     * 
     */
    public void clickedSortByArtistName() {
        list.sortBy("artist");
        update();
    }

    /**
     * 
     */
    public void clickedSortByGenre() {
        list.sortBy("genre");
        update();
    }

    /**
     * 
     */
    public void clickedSortByReleaseYear() {
        list.sortBy("year");
        update();
    }

    /**
     * 
     */
    public void clickedRepresentByMajor() {
        represent = "major";
        update();
    }

    /**
     * 
     */
    public void clickedRepresentByState() {
        represent = "state";
        update();
    }

    /**
     * 
     */
    public void clickedRepresentByHobby() {
        represent = "hobby";
        update();
    }

    /**
     * Closes the GUI.
     */
    public void clickedQuit() {
        System.exit(0);
    }

    /**
     * Simulates clicking "Next" on the GUI.
     */
    public void clickedNext() {
        pageNumber++;
        update();
        if (pageNumber >= lastPage) {
            next.disable();
        }
        else {
            next.enable();
        }
    }

    /**
     * Simulates clicking "Previous" on the GUI.
     */
    public void clickedPrevious() {
        pageNumber--;
        update();
        if (pageNumber <= 0) {
            previous.disable();
        }
        else {
            previous.enable();
        }
    }


    /**
     * Updates everything in GUI as needed in response to clicks on the Window.
     */
    private void update() {
        updateLegend();
        updateGlyphs();
    }


    /**
     * Updates legend in response to change in represenation.
     */
    private void updateLegend() {
        // background
        window.addShape(new Shape(10, 10, 10, 10));
        // bar
        window.addShape(new Shape(10, 10, 10, 10));
        window.addShape(new TextShape(10, 10, "Song"));
        window.addShape(new TextShape(10, 10, "Heard"));
        window.addShape(new TextShape(10, 10, "Likes"));

        TextShape title;
        TextShape enumVal1;
        TextShape enumVal2;
        TextShape enumVal3;
        TextShape enumVal4;

        if (represent == "major") {
            title = new TextShape(10, 10, "Major Legend");
            enumVal1 = new TextShape(10, 10, "Comp Sci");
            enumVal2 = new TextShape(10, 10, "Math & CMDA");
            enumVal3 = new TextShape(10, 10, "Other Engineering");
            enumVal4 = new TextShape(10, 10, "Other");
        }
        else if (represent == "state") {
            title = new TextShape(10, 10, "State Legend");
            enumVal1 = new TextShape(10, 10, "Northeast US");
            enumVal2 = new TextShape(10, 10, "SouthEast US");
            enumVal3 = new TextShape(10, 10, "Rest of US");
            enumVal4 = new TextShape(10, 10, "Outside US");
        }
        else {
            title = new TextShape(10, 10, "Hobby Legend");
            enumVal1 = new TextShape(10, 10, "Reading");
            enumVal2 = new TextShape(10, 10, "Music");
            enumVal3 = new TextShape(10, 10, "Sports");
            enumVal4 = new TextShape(10, 10, "Art");
        }

        window.addShape(title);
        window.addShape(enumVal1);
        window.addShape(enumVal2);
        window.addShape(enumVal3);
        window.addShape(enumVal4);
    }


    /**
     * Updates all glyphs in response to signals send to GUI.
     */
    private void updateGlyphs() {
        window.removeAllShapes();
        int i = 0;
        Song song;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                song = list.getSong(pageNumber + i);
                generateGlyph(x, y, song);
                i++;

                if (pageNumber + i >= list.size()) {
                    return;
                }
            }
        }
    }


    /**
     * Generates a glyph on the Window representing one Song in a 3 x 3 mesh.
     * 
     * @param x
     *            The row index of the glyph.
     * @param y
     *            The column index of the glyph.
     * @param song
     *            A Song from the list.
     */
    private void generateGlyph(int x, int y, Song song) {
        // generate column
        int xPos = (int)((x + 1) * .25 * window.getGraphPanelWidth()
            - columnWidth / 2);
        int yPos = (int)((y + 1) * .25 * window.getGraphPanelHeight());
        window.addShape(new Shape(xPos, yPos, columnWidth, columnHeight));
        
        // generate bars
        
        // add TextShape description
        window.addShape(new TextShape(xPos, yPos + 5, song.getTitle()));
    }
    
    private int[][] readData(String str, Song song)
    {
        
    }
}
