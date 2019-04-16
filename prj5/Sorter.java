import java.util.Arrays;

/**
 * Sorts songs according to paramters.
 * 
 * @author Matthew Pinho (mpinho16)
 * @version 2019.04.16
 */
public class Sorter {
    private LList<Song> list;
    private String[] param;


    public Sorter(LList<Song> songs) {
        list = songs;
        param = new String[list.getLength()];
        sortBy("title");
    }


    /**
     * Retrieves the list of songs.
     * 
     * @return list.
     */
    public LList getList() {
        return list;
    }


    /**
     * Changes the param array according to input parameter.
     * 
     * @param str
     *            Song parameter according to which param is changed.
     */
    private void changeParam(String str) {
        if (str == "title") {
            for (int i = 0; i < list.getLength(); i++) {
                param[i] = list.get(i).getTitle();
            }
        }
        else if (str == "genre") {
            for (int i = 0; i < list.getLength(); i++) {
                param[i] = list.get(i).getGenre();
            }
        }
        else if (str == "artist") {
            for (int i = 0; i < list.getLength(); i++) {
                param[i] = list.get(i).getArtist();
            }
        }
        else if (str == "year") {
            for (int i = 0; i < list.getLength(); i++) {
                param[i] = list.get(i).getTitle();
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Sorts the list by input parameter.
     * 
     * @param str
     *            Song parameter by which is sorted.
     */
    public void sortBy(String str) {
        changeParam(str); // param is now set according to input parameter.

        for (int lh = 0; lh < list.getLength(); lh++) {
            String earliest = "";
            int pEarliest = -1; // default values.
            String curr;

            for (int rh = lh + 1; rh < list.getLength(); rh++) {
                curr = param[rh]; // String on rh to compare.

                // If earlier than earliest, new earliest.
                if (foundNewEarliest(earliest, curr)) {
                    earliest = curr;
                    pEarliest = rh;
                }
            }

            if (pEarliest != -1) {
                // The case when lh String is already where it should be.
                swapElements(lh, pEarliest);
            }
        }
    }


    /**
     * Determines if second String comes earlier than the first.
     * 
     * @param str1
     * @param str2
     * @return Whether str2 is earlier than str1.
     */
    private boolean foundNewEarliest(String str1, String str2) {
        String[] str = new String[] { str1, str2 };
        String[] sorted = new String[] { str1, str2 };
        Arrays.sort(sorted);
        if (str[0] != sorted[0]) {
            return true;
        }

        return false;
    }


    /**
     * Swaps the p1 and p2 entries in the param array and subsequently in the
     * list.
     * 
     * @param p1
     *            Index of first Song.
     * @param p2
     *            Index of second Song.
     */
    private void swapElements(int p1, int p2) {
        String temp = param[p1];
        param[p1] = param[p2];
        param[p2] = param[p1];

        list.swapElements(p1, p2);
    }
}
