package prj5;

/**
 * Test class for LList.
 * 
 * @author Matthew Pinho
 * @author Peter Kistler
 * @author Nicholas Cardaci
 * @author Anvitha Nachiappan
 * @version 2019.04.16
 */
public class LListTest extends student.TestCase {
    private LList list;
    private Song jack;
    private Song queen;
    private Song king;

    /**
     * Sets up before each test method run.
     */
    public void setUp() {
        list = new LList();
        jack = new Song("Jack", "Hearts", "1800", "Metal");
        queen = new Song("Queen", "Spades", "1900", "Pop");
        king = new Song("King", "Diamonds", "2000", "Jazz");

        list.add(jack);
        list.add(queen);
        list.add(king);
    }
    
    
    /**
     * tests sortBy throws the correct exception
     */
    public void testSortByException() {
        Exception ex = null;
        try {
            list.sortBy("filthy");
        }
        catch (Exception e) {
            ex = e;
            assertNotNull(ex);
        }
        assertTrue(ex instanceof IllegalArgumentException);
    }
    
    
    /**
     * Checks that songs are added correctly.
     */
    public void testAdd() {
        assertEquals(list.size(), 3);
        assertFalse(list.isEmpty());
        
        Exception thrown = null;
        try {
            list.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        
        list.clear();
        list.clear();
        assertTrue(list.isEmpty());
        Exception thrown1 = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            thrown1 = e;
        }
        assertNotNull(thrown1);
        Exception thrown2 = null;
        try {
            list.get(1);
        }
        catch (Exception e) {
            thrown2 = e;
        }
        assertNotNull(thrown2);
        list.add(jack);
        assertEquals(jack, list.get(0));
        list.add(queen);
        assertEquals(queen, list.get(1));
    }
    
    
    /**
     * tests that swapElements throws the correct exception
     */
    public void testSwapElementsException() {
        Exception ex = null;
        try {
            list.swapElements(0, -1);
        }
        catch (Exception e) {
            ex = e;
            assertNotNull(ex);
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        
        ex = null;
        try {
            list.swapElements(0, 100);
        }
        catch (Exception e) {
            ex = e;
            assertNotNull(ex);
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
    }
    

    /**
     * Checks that swaps two elements in the list.
     */
    public void testSwapElements() {
        list.swapElements(1, 1);
        assertEquals(jack, list.get(0));
        assertEquals(queen, list.get(1));
        
        list.swapElements(0, 1);
        assertEquals(queen, list.get(0));
        assertEquals(jack, list.get(1));
    }

    /**
     * Checks that second input is earlier than first.
     */
    public void testHasFoundEarliest() {
        String str1 = "ab";
        String str2 = "bc";

        assertFalse(list.foundNewEarliest(str1, str2));
        assertTrue(list.foundNewEarliest(str2, str1));
    }

    /**
     * Checks that sortation is done correctly.
     */
    public void testSortBy() {
        list.sortBy("title");
        assertEquals(jack, list.get(0));
        assertEquals(king, list.get(1));
        
        list.sortBy("artist");
        assertEquals(king, list.get(0));
        assertEquals(jack, list.get(1));
        
        list.sortBy("genre");
        assertEquals(king, list.get(0));
        assertEquals(queen, list.get(2));
        
        list.sortBy("year");
        assertEquals(jack, list.get(0));
        assertEquals(queen, list.get(1));
    }
}
