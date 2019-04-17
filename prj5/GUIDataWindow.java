package prj5;

import java.awt.Color;
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
    private Song songTest;
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
    // private final int lastPage;
    private final int barLengthFactor = 10;
    private final int barWidth = 10;
    private LList list;


    /**
     * 
     * @param songs
     */
    public GUIDataWindow(LList songs) {
        songTest = new Song("Hotline Bling", "Drake", 2015, "R&B");
        represent = "hobby";
        list = songs;
        // lastPage = (int)Math.ceil(list.size() / 9);

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
        /**
         * pageNumber++;
         * update();
         * if (pageNumber >= lastPage) {
         * next.disable();
         * }
         * else {
         * next.enable();
         * }
         */
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

        // bar
        window.addShape(new Shape(673, 220, 5, 50, Color.BLACK));
        TextShape songT = new TextShape(640, 200, "Song Title");
        songT.setBackgroundColor(Color.WHITE);
        window.addShape(songT);
        TextShape heard = new TextShape(625, 230, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        TextShape likes = new TextShape(685, 230, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);

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
            enumVal1 = new TextShape(620, 120, "Northeast US", Color.MAGENTA);
            enumVal2 = new TextShape(620, 140, "SouthEast US", Color.GREEN);
            enumVal3 = new TextShape(620, 160, "Rest of US", Color.YELLOW);
            enumVal4 = new TextShape(620, 180, "Outside US", Color.BLUE);
        }
        else {
            title = new TextShape(620, 100, "Hobby Legend");
            title.setBackgroundColor(Color.WHITE);

            enumVal1 = new TextShape(620, 120, "Reading", Color.MAGENTA);
            enumVal1.setBackgroundColor(Color.WHITE);
            enumVal2 = new TextShape(620, 140, "Music", Color.GREEN);
            enumVal2.setBackgroundColor(Color.WHITE);
            enumVal3 = new TextShape(620, 160, "Sports", Color.YELLOW);
            enumVal3.setBackgroundColor(Color.WHITE);
            enumVal4 = new TextShape(620, 180, "Art", Color.BLUE);
            enumVal4.setBackgroundColor(Color.WHITE);
        }

        window.addShape(title);
        window.addShape(enumVal1);
        window.addShape(enumVal2);
        window.addShape(enumVal3);
        window.addShape(enumVal4);

        // background box
        Shape s = new Shape(610, 90, 125, 190, Color.BLACK);
        s.setBackgroundColor(Color.WHITE);
        window.addShape(s);
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
                song = list.get(pageNumber + i);
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
        int[][] info = new int[4][2];// song.getInfo(represent);

        // heards bars
        Shape pinkH = new Shape(10, 10, barLength(info[1][1]), barWidth,
            Color.MAGENTA);
        Shape blueH = new Shape(10, 10, barLength(info[2][1]), barWidth,
            Color.BLUE);
        Shape orangeH = new Shape(10, 10, barLength(info[3][1]), barWidth,
            Color.ORANGE);
        Shape greenH = new Shape(10, 10, barLength(info[4][1]), barWidth,
            Color.GREEN);

        // likes bars
        Shape pinkL = new Shape(10, 10, barLength(info[1][2]), barWidth,
            Color.MAGENTA);
        Shape blueL = new Shape(10, 10, barLength(info[2][2]), barWidth,
            Color.BLUE);
        Shape orangeL = new Shape(10, 10, barLength(info[3][2]), barWidth,
            Color.ORANGE);
        Shape greenL = new Shape(10, 10, barLength(info[4][2]), barWidth,
            Color.GREEN);

        // add TextShape description
        window.addShape(new TextShape(xPos, yPos + 5, song.getTitle()));
        window.addShape(pinkH);
        window.addShape(blueH);
        window.addShape(orangeH);
        window.addShape(greenH);

        window.addShape(pinkL);
        window.addShape(blueL);
        window.addShape(orangeL);
        window.addShape(greenL);
    }


    /**
     * Returns the length of a bar based on count of likes or heards.
     * 
     * @param count
     *            Number of likes or heards.
     * @return Length of a bar.
     */
    private int barLength(int count) {
        return barLengthFactor * count;
    }
}
