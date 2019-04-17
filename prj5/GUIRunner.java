package prj5;

public class GUIRunner {
    private static LList songs;
    private static Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;
    private Song song7;
    private Song song8;
    private Song song9;


    public GUIRunner() {
        song1 = new Song("Hotline Bling", "Drake", "2015", "R&B");
        song2 = new Song("Creep", "Radiohead", "1992", "Alternative");
        song3 = new Song("All of Me", "John Legend", "2013", "R&B");
        song4 = new Song("My Heart Will Go On", "Celine Dion", "1997", "Pop");
        song5 = new Song("River Flows in You", "Yirma", "2011", "Instrumental");
        song6 = new Song("Beauty and the Beast", "Disney", "1991", "Soundtrack");
        song7 = new Song("A Whole New World", "Disney", "1992", "Soundtrack");
        song8 = new Song("Let it Go", "Disney", "2013", "Soundtrack");
        song9 = new Song("Hello", "Adele", "2014", "Soul");

       
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        

    }


    public static void main(String[] args) {
        GUIDataWindow gDW = new GUIDataWindow(songs);
    }
}
