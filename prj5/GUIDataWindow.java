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

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * the class houses the GUI window which is the mean display of the project.
 * 
 * @author Matthew Pinho
 *
 */
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
    private int pageNumber; // starts at 0.
    private String represent;
    private final int columnWidth = 5;
    private final int columnHeight = 40;
    // private final int lastPage;
    // private final int barLengthFactor = 10;
    private final int barWidth = 10;
    private LList list;


    /**
     * this is the constructor of the class it is used to initialize the class
     * used objects.
     * 
     * @param songs
     */
    public GUIDataWindow(DataReader phil) {
        represent = "hobby";
        list = phil.getSongs();
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
     * this method sets the function of Sort By Song Title
     * button.
     */
    public void clickedSortBySongTitle() {
        list.sortBy("title");
        update();
    }


    /**
     * this method sets the function of Sort By Artist Name
     * button.
     */
    public void clickedSortByArtistName() {
        list.sortBy("artist");
        update();
    }


    /**
     * this method sets the function of Sort By Genre
     * button.
     */
    public void clickedSortByGenre() {
        list.sortBy("genre");
        update();
    }


    /**
     * this method sets the function of Sort By Release Year
     * button.
     */
    public void clickedSortByReleaseYear() {
        list.sortBy("year");
        update();
    }


    /**
     * this method sets the function of Represent By Major
     * button.
     */
    public void clickedRepresentByMajor() {
        represent = "major";
        update();
    }


    /**
     * this method sets the function of Represent By State
     * button.
     */
    public void clickedRepresentByState() {
        represent = "state";
        update();
    }


    /**
     * this method sets the function of Represent By Hobby
     * button.
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

        updateGlyphs();
        updateLegend();
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
            enumVal4 = new TextShape(620, 140, "Art", Color.BLUE);
            enumVal4.setBackgroundColor(Color.WHITE);
            enumVal3 = new TextShape(620, 160, "Sports", Color.ORANGE);
            enumVal3.setBackgroundColor(Color.WHITE);
            enumVal2 = new TextShape(620, 180, "Music", Color.GREEN);
            enumVal2.setBackgroundColor(Color.WHITE);

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
        int xPos = (int)((x + .45) * .28 * window.getGraphPanelWidth()
            - columnWidth / 2);
        int yPos = (int)((y + .75) * .28 * window.getGraphPanelHeight());
        window.addShape(new Shape(xPos, yPos, columnWidth, columnHeight,
            Color.BLACK));

        int xLike = xPos + columnWidth;

        // generate bars
        @SuppressWarnings("unused")
        int[][] info = song.getInfo(represent);

        int xMagentaH = 30;// barLength(info[0][0]);
        int xBlueH = 10; // barLength(info[1][0]);
        int xOrangeH = 25;// barLength(info[2][0]);
        int xGreenH = 10;
        // barLength(info[3][0]);

        int xMagentaL = 20;
        // barLength(info[0][1]);
        int xBlueL = 40;
        // barLength(info[1][1]);
        int xOrangeL = 25;
        // barLength(info[2][1]);
        int xGreenL = 40;
        // barLength(info[3][1]);

        // heards bars
        Shape magentaH = new Shape(xPos - xMagentaH, yPos, xMagentaH, barWidth,
            Color.MAGENTA);
        Shape blueH = new Shape(xPos - xBlueH, yPos + barWidth, xBlueH,
            barWidth, Color.BLUE);
        Shape orangeH = new Shape(xPos - xOrangeH, yPos + 2 * barWidth,
            xOrangeH, barWidth, Color.ORANGE);
        Shape greenH = new Shape(xPos - xGreenH, yPos + 3 * barWidth, xGreenH,
            barWidth, Color.GREEN);

        // likes bars
        Shape magentaL = new Shape(xLike, yPos, xMagentaL, barWidth,
            Color.MAGENTA);
        Shape blueL = new Shape(xLike, yPos + barWidth, xBlueL, barWidth,
            Color.BLUE);
        Shape orangeL = new Shape(xLike, yPos + 2 * barWidth, xOrangeL,
            barWidth, Color.ORANGE);
        Shape greenL = new Shape(xLike, yPos + 3 * barWidth, xGreenL, barWidth,
            Color.GREEN);

        // add TextShape description
        @SuppressWarnings("unused")
        String description = song.getTitle();
        if (represent != "title") {
            description += " " + song.getTitle();
        }
        if (represent == "hobby") {

        }

        TextShape title = new TextShape(xPos, yPos - 35, song.getTitle());
        title.setBackgroundColor(Color.WHITE);
        title.setX(title.getX() - title.getWidth() / 2);
        TextShape artist = new TextShape(xPos, yPos - 20, "by " + song
            .getArtist());
        artist.setBackgroundColor(Color.WHITE);
        artist.setX(artist.getX() - artist.getWidth() / 2);
        window.addShape(title);
        window.addShape(artist);
        window.addShape(magentaH);
        window.addShape(blueH);
        window.addShape(orangeH);
        window.addShape(greenH);

        window.addShape(magentaL);
        window.addShape(blueL);
        window.addShape(orangeL);
        window.addShape(greenL);
    }
}
