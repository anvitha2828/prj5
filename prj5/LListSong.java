package prj5;

import java.util.Arrays;
import prj5.Song;

public class LListSong<Song> {

    /**
     * 
     */
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

    private Node<Song> head;
    private String[] param;

    // the size of the linked list
    private int size;


    /**
     * Creates a new LinkedList object
     */
    public LListSong() {
        head = null;
        size = 0;

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
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(Song song) {
        // check if the object is null
        if (song == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Song> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<Song>(song);

        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<Song>(song));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(Song song) {
        Node<Song> current = head;

        // account for matching head
        if ((null != head) && (song.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if (song.equals(current.next.data)) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                current.next = null;
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index) {
        // // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<Song> current = head;
            int currentIndex = 0;

            // account for 1 size
            if ((index == 0)) {
                head = head.next;
                size--;
                return true;
            }

            // account for 2+ size
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<Song> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
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
    public Song getSong(int index) {
        Node<Song> current = head;
        int currentIndex = 0;
        Song data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(Song song) {
        Node<Song> current = head;
        while (current != null) {
            if (song.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(Song song) {
        int lastIndex = -1;
        Node<Song> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (song.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<Song> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<Song> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LListSong<Song> other = ((LListSong<Song>)obj);
            if (other.size() == this.size()) {
                Node<Song> current = head;
                Node<Song> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    public void swap(int index1, int index2) {
        Node<Song> temp;
        @SuppressWarnings("unchecked")
        Node<Song> t1 = (Node<Song>)getSong(index1);
        @SuppressWarnings("unchecked")
        Node<Song> t2 = (Node<Song>)getSong(index2);
        temp = t1;
        t1 = t2;
        t2 = temp;
    }


    /// CHECK METHOD
    /**
     * private void changeParam(String str) {
     * if (str == "title") {
     * for (int i = 0; i < size; i++) {
     * param[i] = ((prj5.Song)getSong(i)).getTitle();
     * }
     * }
     * else if (str == "genre") {
     * for (int i = 0; i < size; i++) {
     * param[i] = ((prj5.Song)getSong(i)).getGenre();
     * }
     * }
     * else if (str == "artist") {
     * for (int i = 0; i < size; i++) {
     * param[i] = ((prj5.Song)getSong(i)).getArtist();
     * }
     * }
     * else if (str == "year") {
     * for (int i = 0; i < size; i++) {
     * param[i] = ((prj5.Song)getSong(i)).getTitle();
     * }
     * }
     * else {
     * throw new IllegalArgumentException();
     * }
     * }
     */

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
     * Sorts the list by input parameter.
     * 
     * @param str
     *            Song parameter by which is sorted.
     */
    /**
     * public void sortBy(String str) {
     * changeParam(str); // param is now set according to input parameter.
     * 
     * for (int lh = 0; lh < size; lh++) {
     * String earliest = "";
     * int pEarliest = -1; // default values.
     * String curr;
     * 
     * for (int rh = lh + 1; rh < size; rh++) {
     * curr = param[rh]; // String on rh to compare.
     * 
     * // If earlier than earliest, new earliest.
     * if (foundNewEarliest(earliest, curr)) {
     * earliest = curr;
     * pEarliest = rh;
     * }
     * }
     * 
     * if (pEarliest != -1) {
     * // The case when lh String is already where it should be.
     * swap(lh, pEarliest);
     * }
     * }
     * }
     */

}
