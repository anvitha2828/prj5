package prj5;

public class Song {
    private String title;
    private String genre;
    private String artist;
    private int year;


    public Song(String name, String art, int yea, String gen) {
        title = name;
        genre = gen;
        artist = art;
        year = yea;
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
