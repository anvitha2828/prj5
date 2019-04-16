package prj5;

public class Song {
    private String title;
    private String genre;
    private String artist;
    private int year;
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
    public Song(String name, String art, int yea, String gen) {
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
    public int getYear() {
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
        StringBuilder bob = new StringBuilder(getTitle());
        bob.append(", " + getArtist());
        bob.append(", " + getYear());
        bob.append(", " + getGenre());
        bob.append(".");
        return bob.toString();
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
