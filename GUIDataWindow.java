package prj5;

import CS2114.Button;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * GUI Data Window
 *
 * @author <Anvitha Nachiappan> <anvitha>
 * @version <4/15/19>
 */
public class GUIDataWindow {
    private Sorter sorter;
    private int pageNumber;
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


    public GUIDataWindow(Sorter sort) {
        sorter = sort;
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

    }


    public void clickedSortBySongTitle() {
        sorter.sortBy("title");
    }


    public void clickedSortByArtistName() {
        sorter.sortBy("artist");
    }


    public void clickedSortByGenre() {
        sorter.sortBy("genre");
    }


    public void clickedSortByReleaseYear() {
        sorter.sortBy("year");
    }


    public void clickedRepresentByState() {

    }


    public void clickedRepresentByMajor() {

    }


    public void clickedRepresentByHobby() {
        update();
    }


    public void clickedQuit() {
        System.exit(0);
    }


    public void clickedNext() {
        pageNumber++;
        update();
    }


    public void clickedPrevious() {
        pageNumber--;
        update();
    }


    private void update() {
        updateLegend();
        updateGlyphs();
    }


    private void updateLegend() {

    }


    private void updateGlyphs() {
        window.removeAllShapes();
        int count = 0;
        for (int i = 0; i <= 9; i++) {
            // list.get(i + pageNumber);
            generateGlyph(i);
        }
    }


    private void generateGlyph(int i) {

    }

}
