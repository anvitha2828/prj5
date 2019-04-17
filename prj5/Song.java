package prj5;

/**
 * This is the song class. Allows user to make a song object with title, genre,
 * artist, and year
 * 
 * @author Anvitha Nachiappan <anvitha>
 * @author Nicholas Cardaci <nicho17>
 * @author Matthew Pinho <mpinho16>
 * @author Peter Kistler <pdblvkis>
 *
 */
public class Song {
    private String title;
    private String genre;
    private String artist;
    private String year;
    private int[][] majorHeardLikes;
    private int[][] stateHeardLikes;
    private int[][] hobbyHeardLikes;


    /**
     * Constructor for song
     * 
     * @param name
     *            Song name
     * @param art
     *            artist name
     * @param yea
     *            year
     * @param gen
     *            genre
     */
    public Song(String name, String art, String yea, String gen) {
        title = name;
        genre = gen;
        artist = art;
        year = yea;
        majorHeardLikes = new int[4][2];
        stateHeardLikes = new int[4][2];
        hobbyHeardLikes = new int[4][2];
    }


    /**
     * returns the title
     * 
     * @return String
     *         returns Title
     */
    public String getTitle() {
        return title;
    }


    /**
     * returns artist
     * 
     * @return String
     *         returns artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Returns Genre
     * 
     * @return int
     *         returns the year
     */
    public String getYear() {
        return year;
    }


    /**
     * Returns Genre
     * 
     * @return String
     *         returns the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * returns the array of heards and likes
     * 
     * @param s
     *            specifies the major, state, or hobby
     * @return int[][]
     *         2D array value containing number of likes and heard
     */
    public int[][] getInfo(String s) {
        if (s == "major") {
            return majorHeardLikes;
        }
        if (s == "state") {
            return stateHeardLikes;
        }
        if (s == "hobby") {
            return hobbyHeardLikes;
        }
        return null;
    }


    /**
     * returns the String version of the Song
     * 
     * @return String
     *         returns the String version of the Song
     * 
     */
    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder("song title " + getTitle());
        bob.append("\n" + "song artist " + getArtist());
        bob.append("\n" + "song genre " + getGenre());
        bob.append("\n" + "year " + getYear());
        bob.append("\n" + "heard" + "\n");
        bob.append("reading" + percentageRead() + " art" + percentageArt()
            + " sports" + percentageSport() + " music" + percentageMusic());
        bob.append("\n" + "likes" + "\n");
        bob.append("reading" + percentageRead() + " art" + percentageArt()
        + " sports" + percentageSport() + " music" + percentageMusic());
        return bob.toString();
    }
    
    
    /**
     * percent 
     */
    private int percentageRead() {
        int j = 0;
        int tot = 0;
            j += getInfo("hobby")[0][0];
            tot += getInfo("hobby")[0][1];
        if (tot == 0)
            tot = 1;
        return j / tot * 100;
    }
    
    
    /**
     * percent 
     */
    private int percentageArt() {
        int j = 0;
        int tot = 0;
            j += getInfo("hobby")[1][0];
            tot += getInfo("hobby")[1][1];
        if (tot == 0)
            tot = 1;
        return j / tot * 100;
    }
    
    
    /**
     * percent 
     */
    private int percentageSport() {
        int j = 0;
        int tot = 0;
            j += getInfo("hobby")[2][0];
            tot += getInfo("hobby")[2][1];
        if (tot == 0)
            tot = 1;
        return j / tot * 100;
    }
    
    
    /**
     * percent 
     */
    private int percentageMusic() {
        int j = 0;
        int tot = 0;
            j += getInfo("hobby")[3][0];
            tot += getInfo("hobby")[3][1];
        if (tot == 0)
            tot = 1;
        return j / tot * 100;
    }


    /**
     * returns true if equal false if not
     * 
     * @param obj
     *            Object to compare
     * @return boolean
     *         returns true if equal false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            Song song = (Song)obj;
            return (this.getArtist().equals(song.getArtist()) && this.getGenre()
                .equals(song.getGenre()) && this.getTitle().equals(song
                    .getTitle()) && this.getYear() == song.getYear());
        }
        return false;
    }
}
