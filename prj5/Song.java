package prj5;

public class Song {
    private String title;
    private String genre;
    private String artist;
    private int year;
    private int[][] majorHeardLikes;
    private int[][] stateHeardLikes;
    private int[][] hobbyHeardLikes;


    public Song(String name, String art, int yea, String gen) {
        title = name;
        genre = gen;
        artist = art;
        year = yea;
        majorHeardLikes = new int[4][2];
        stateHeardLikes = new int[4][2];
        hobbyHeardLikes = new int[4][2];
    }


    public String getTitle() {
        return title;
    }


    public String getArtist() {
        return artist;
    }


    public int getYear() {
        return year;
    }


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


    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder(getTitle());
        bob.append(", " + getArtist());
        bob.append(", " + getYear());
        bob.append(", " + getGenre());
        bob.append(".");
        return bob.toString();
    }


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
