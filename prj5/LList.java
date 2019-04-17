package prj5;

import java.util.Arrays;
import java.util.Iterator;
import prj5.Song;

public class LList implements Iterable<Song> {

    /**
     * 
     * @version 4/14/2015
     * @version 9.4.15
     * @version 10.29.15
     * @version 10/15/2016
     * @version 03/17/2017
     */
    public static class Node {

        // The data element stored in the node.
        private Song data;

        // The next node in the sequence.
        private Node next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(Song d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public Song getData() {
            return data;
        }


        public void setData(Song data2) {

        }
    }

    private Node head;
    private int size;
    private String[] param;
    private LListIterator iter;


    /**
     * Creates a new LinkedList object
     */
    public LList() {
        head = null;
        size = 0;
        param = new String[0];
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition song cannot be null
     * @param song
     *            the object to add
     * @throws IllegalArgumentException
     *             if song is null
     */
    public void add(Song song) {
        iter = iterator();

        if (song == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        if (isEmpty()) {
            head = new Node(song);
        }
        else {
            Node curr = head;
            while (iter.hasNext()) {
                iter.next();
                curr = curr.next;
            }

            curr.next = new Node(song);
        }

        size++;
        param = new String[size];
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public Song get(int index) {
        iter = iterator();

        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }

        Song song = head.data;

        for (int i = 0; i < index; i++) {
            song = iter.next();
        }

        return song;
    }


    private void changeParam(String str) {
        if (str == "title") {
            for (int i = 0; i < size; i++) {
                param[i] = get(i).getTitle();
            }
        }
        else if (str == "genre") {
            for (int i = 0; i < size; i++) {
                param[i] = get(i).getGenre();
            }
        }
        else if (str == "artist") {
            for (int i = 0; i < size; i++) {
                param[i] = get(i).getArtist();
            }
        }
        else if (str == "year") {
            for (int i = 0; i < size; i++) {
                param[i] = get(i).getYear();
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

        for (int lh = 0; lh < size - 1; lh++) {
            String earliest = param[lh];
            int pEarliest = -1; // default values.
            String curr;

            for (int rh = lh + 1; rh < size; rh++) {
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
    public boolean foundNewEarliest(String str1, String str2) {
        Exception thrown = null;
        int s1 = 0;
        int s2 = 0;
        try {
            s1 = Integer.parseInt(str1);
            s2 = Integer.parseInt(str2);
        }
        catch (Exception e) {
            thrown = e;
        }

        if (thrown != null) {
            String[] str = new String[] { str1, str2 };
            String[] sorted = new String[] { str1, str2 };
            Arrays.sort(sorted);
            if (str[0] != sorted[0]) {
                return true;
            }
        }
        else {
            int[] num = new int[] { s1, s2 };
            int[] sorted = new int[] { s1, s2 };
            Arrays.sort(sorted);
            if (num[0] != sorted[0]) {
                return true;
            }
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
    public void swapElements(int p1, int p2) {
        if (p2 != p1 && p2 <= size && p1 <= size) {
            String temp = param[p1];
            param[p1] = param[p2];
            param[p2] = temp;

            Node node1 = getNodeAt(p1);
            Node node2 = getNodeAt(p2);

            Song sTemp = node1.data;
            node1.data = node2.data;
            node2.data = sTemp;
        }
    }


    private Node getNodeAt(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }

        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }


    public LListIterator iterator() {
        return new LListIterator();
    }


    private class LListIterator implements Iterator<Song> {

        private Node curr;


        public LListIterator() {
            curr = head;
        }


        public boolean hasNext() {
            return curr.next != null;
        }


        @Override
        public Song next() {
            curr = curr.next;
            return curr.getData();
        }
    }
}
