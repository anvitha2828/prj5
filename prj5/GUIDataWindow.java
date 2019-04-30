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
 * @author Matthew Pinho (mpinho16)
 * @author Peter Kistler (pdblvkis)
 * @author Nicholas Cardaci (nicho17)
 * @author Anvitha Nachiappan (anvitha)
 * @version 2019.04.20
 */
public class GUIDataWindow {
    private final int windowWidth = 1400;
    private final int windowHeight = 800;
    private final int columnWidth = 5;
    private final int columnHeight = 40;
    private final int legendWidth = 150;
    private final int legendHeight = 190;
    private final int barLengthFactor = 1;
    private final int barWidth = 10;
    private Window window;
    private Button next;
    private Button previous;
    private int pageNumber; // starts at 0.
    // current representation
    private final int lastPage;
    private LList list;
    private final int xLegend;
    private final int yLegend;
    private String sortType;
    private String representType = "hobby";


    /**
     * Initializes the GUI.
     * 
     * @param reader
     *            DataReader which produces the LList of songs used in the GUI.
     */
    public GUIDataWindow(DataReader reader) {
        list = reader.getSongs();
        lastPage = (int)Math.ceil(list.size() / 9); // highest possible number
                                                    // of pages

        // create window
        window = new Window("Song Survey Visualization");
        window.setSize(windowWidth, windowHeight);

        // create buttons
        previous = new Button("<-- Prev");
        next = new Button("Next -->");
        Button quit = new Button("Quit");
        Button representByHobby = new Button("Represent Hobby");
        Button representByMajor = new Button("Represent Major");
        Button representByState = new Button("Represent State");
        Button sortByArtistName = new Button("Sort by Artist Name");
        Button sortBySongTitle = new Button("Sort by Song Title");
        Button sortByReleaseYear = new Button("Sort by Release Year");
        Button sortByGenre = new Button("Sort by Genre");

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

        sortBySongTitle.onClick(this, "clickedSortBySongTitle");
        sortByReleaseYear.onClick(this, "clickedSortByReleaseYear");
        sortByGenre.onClick(this, "clickedSortByGenre");
        sortByArtistName.onClick(this, "clickedSortByArtistName");
        quit.onClick(this, "clickedQuit");
        previous.onClick(this, "clickedPrevious");
        next.onClick(this, "clickedNext");
        representByState.onClick(this, "clickedRepresentByState");
        representByMajor.onClick(this, "clickedRepresentByMajor");
        representByHobby.onClick(this, "clickedRepresentByHobby");

        // legend position
        xLegend = window.getGraphPanelWidth() - legendWidth - 10;
        yLegend = window.getGraphPanelHeight() - legendHeight - 10;

        update();
    }


    /**
     * Sorts songs by title.
     */
    public void clickedSortBySongTitle(Button button) {
        list.sortBy("title");
        sortType = "";
        update();
    }


    /**
     * Sorts songs by artist name.
     */
    public void clickedSortByArtistName(Button button) {
        list.sortBy("artist");
        sortType = "artist";
        update();
    }


    /**
     * Sorts songs by genre.
     */
    public void clickedSortByGenre(Button button) {
        list.sortBy("genre");
        sortType = "genre";
        update();
    }


    /**
     * Sorts songs by release year.
     */
    public void clickedSortByReleaseYear(Button button) {
        list.sortBy("year");
        sortType = "year";
        update();
    }


    /**
     * Represents song information by major.
     */
    public void clickedRepresentByMajor(Button button) {
        representType = "major";
        update();
    }


    /**
     * Represents song information by state.
     */
    public void clickedRepresentByState(Button button) {
        representType = "state";
        update();
    }


    /**
     * Represents song information by hobby.
     */
    public void clickedRepresentByHobby(Button button) {
        representType = "hobby";
        update();
    }


    /**
     * Closes the GUI.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Simulates clicking "Next" on the GUI.
     */
    public void clickedNext(Button button) {
        pageNumber++;
        update();
    }


    /**
     * Simulates clicking "Previous" on the GUI.
     */
    public void clickedPrevious(Button button) {
        pageNumber--;
        update();
    }


    /**
     * Updates everything in GUI as needed in response to clicks on the Window.
     */
    private void update() {
        window.removeAllShapes();
        updateGlyphs();
        updateLegend();
        checkPageNumber();
    }


    /**
     * Prevents going to nonexistent pages. Disables/enables page navigation
     * buttons as needed.
     */
    private void checkPageNumber() {
        // Previous button is disabled if page is 0.
        // Otherwise is kept enabled.
        if (pageNumber <= 0) {
            previous.disable();
        }
        else {
            previous.enable();
        }

        // Next button is disabled if page is the last page.
        // Otherwise is kept enabled.
        if (pageNumber >= lastPage) {
            next.disable();
        }
        else {
            next.enable();
        }
    }


    /**
     * Updates legend in response to change in representation.
     */
    private void updateLegend() {
        // column
        window.addShape(new Shape(xLegend + 70, yLegend + 120, 5, 50,
            Color.BLACK));

        // "Song Title" text
        TextShape songT = new TextShape(xLegend + 40, yLegend + 100,
            "Song Title");
        songT.setBackgroundColor(Color.WHITE);
        window.addShape(songT);

        // "Heard" text
        TextShape heard = new TextShape(xLegend + 15, yLegend + 135, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);

        // "Likes" text
        TextShape likes = new TextShape(xLegend + 85, yLegend + 135, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);

        // Labels chosen based on representation wanted.
        String title;
        String enumVal1;
        String enumVal2;
        String enumVal3;
        String enumVal4;

        if (representType == "major") {
            title = "Major Legend";

            enumVal1 = "Comp Sci";
            enumVal2 = "Math & CMDA";
            enumVal3 = "Other Engineering";
            enumVal4 = "Other";
        }
        else if (representType == "state") {
            title = "State Legend";

            enumVal1 = "Northeast US";
            enumVal2 = "SouthEast US";
            enumVal3 = "Rest of US";
            enumVal4 = "Outside US";
        }
        else {
            title = "Hobby Legend";

            enumVal1 = "Reading";
            enumVal2 = "Art";
            enumVal3 = "Sports";
            enumVal4 = "Music";
        }

        // Generates shapes for labels.
        TextShape titleText = new TextShape(xLegend + 25, yLegend + 7, title);
        titleText.setBackgroundColor(Color.WHITE);

        TextShape enumVal1Text = new TextShape(xLegend + 3, yLegend + 30,
            enumVal1, Color.MAGENTA);
        enumVal1Text.setBackgroundColor(Color.WHITE);

        TextShape enumVal2Text = new TextShape(xLegend + 3, yLegend + 47,
            enumVal2, Color.BLUE);
        enumVal2Text.setBackgroundColor(Color.WHITE);

        TextShape enumVal3Text = new TextShape(xLegend + 3, yLegend + 64,
            enumVal3, Color.ORANGE);
        enumVal3Text.setBackgroundColor(Color.WHITE);

        TextShape enumVal4Text = new TextShape(xLegend + 3, yLegend + 81,
            enumVal4, Color.GREEN);
        enumVal4Text.setBackgroundColor(Color.WHITE);

        window.addShape(titleText);
        window.addShape(enumVal1Text);
        window.addShape(enumVal2Text);
        window.addShape(enumVal3Text);
        window.addShape(enumVal4Text);

        // background box
        Shape back = new Shape(xLegend, yLegend, legendWidth, legendHeight,
            Color.BLACK);
        back.setBackgroundColor(Color.WHITE);
        window.addShape(back);
    }


    /**
     * Updates all glyphs in response to signals send to GUI.
     */
    private void updateGlyphs() {
        int i = 0;
        Song song;
        int index;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                index = pageNumber * 9 + i;
                if (index >= list.size()) {
                    break;
                }

                song = list.get(pageNumber * 9 + i);
                generateGlyph(x, y, song);
                i++;
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
            - columnWidth / 2) + 60; // x position of column.
        // y position of column.
        int yPos = (int)((y + .75) * .28 * window.getGraphPanelHeight());
        window.addShape(new Shape(xPos, yPos, columnWidth, columnHeight,
            Color.BLACK));

        // x position of all liked bars for given song.
        int xLike = xPos + columnWidth;

        // Array holding all heard/liked information on given song.
        int[][] info = song.getInfo(representType);

        // heard bars
        int xMagentaH = barLength(info[0][0]);
        int xBlueH = barLength(info[1][0]);
        int xOrangeH = barLength(info[2][0]);
        int xGreenH = barLength(info[3][0]);

        Shape magentaH = new Shape(xPos - xMagentaH, yPos, xMagentaH, barWidth,
            Color.MAGENTA);
        Shape blueH = new Shape(xPos - xBlueH, yPos + barWidth, xBlueH,
            barWidth, Color.BLUE);
        Shape orangeH = new Shape(xPos - xOrangeH, yPos + 2 * barWidth,
            xOrangeH, barWidth, Color.ORANGE);
        Shape greenH = new Shape(xPos - xGreenH, yPos + 3 * barWidth, xGreenH,
            barWidth, Color.GREEN);

        window.addShape(magentaH);
        window.addShape(blueH);
        window.addShape(orangeH);
        window.addShape(greenH);

        // liked bars
        int xMagentaL = barLength(info[0][1]);
        int xBlueL = barLength(info[1][1]);
        int xOrangeL = barLength(info[2][1]);
        int xGreenL = barLength(info[3][1]);

        Shape magentaL = new Shape(xLike, yPos, xMagentaL, barWidth,
            Color.MAGENTA);
        Shape blueL = new Shape(xLike, yPos + barWidth, xBlueL, barWidth,
            Color.BLUE);
        Shape orangeL = new Shape(xLike, yPos + 2 * barWidth, xOrangeL,
            barWidth, Color.ORANGE);
        Shape greenL = new Shape(xLike, yPos + 3 * barWidth, xGreenL, barWidth,
            Color.GREEN);

        window.addShape(magentaL);
        window.addShape(blueL);
        window.addShape(orangeL);
        window.addShape(greenL);

        // add TextShape description
        String description = "";
        int disp = 0;
        if (sortType == "genre") {
            description += "genre: " + song.getGenre();
        }
        else if (sortType == "artist") {
            description += "artist: " + song.getArtist();
        }
        else if (sortType == "year") {
            description += "release year: " + song.getYear();
        }
        else {
            disp = 15;
        }

        // title of song.
        TextShape title = new TextShape(xPos, yPos - 35 + disp, song
            .getTitle());
        title.setBackgroundColor(Color.WHITE);
        title.setX(title.getX() - title.getWidth() / 2);
        window.addShape(title);

        // extra description of song, if needed.
        TextShape descrip = new TextShape(xPos, yPos - 20, description);
        descrip.setBackgroundColor(Color.WHITE);
        descrip.setX(descrip.getX() - descrip.getWidth() / 2);
        window.addShape(descrip);
    }


    /**
     * Returns the length of a bar based on count of likes or heards in song's
     * info array.
     * 
     * @param count
     *            Number of likes or heards.
     * @return Length of a bar.
     */
    private int barLength(int count) {
        return barLengthFactor * count;
    }
}
