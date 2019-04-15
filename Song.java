package prj5;

public class Song {
    private String title;
    private String genre;
    private String artist;
    private int year;


    public Song(String name, String gen, String art, int yea) {
        title = name;
        genre = gen;
        artist = art;
        year = yea;
    }


    public String getTitle() {
        return title;
    }


    public String getGenre() {
        return genre;
    }


    public String getArtist() {
        return artist;
    }


    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        // toDo
        return null;
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
