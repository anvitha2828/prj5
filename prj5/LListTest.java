package prj5;

public class LListTest extends student.TestCase {
    private LList list;
    private Song jack;
    private Song queen;
    private Song king;


    public void setUp() {
        list = new LList();
        jack = new Song("Jack","Hearts", "1800", "Metal");
        queen = new Song("Queen","Spades","1900", "Pop");
        king = new Song("King", "Diamonds", "2000", "Jazz");

        list.add(jack);
        list.add(queen);
        list.add(king);
    }


    public void testSwapElements() {
        list.swapElements(0, 1);
        assertEquals(queen, list.get(0));
        assertEquals(jack, list.get(1));
    }


    public void testHasFoundEarliest() {
        String str1 = "ab";
        String str2 = "bc";

        assertFalse(list.foundNewEarliest(str1, str2));
        assertTrue(list.foundNewEarliest(str2, str1));
    }


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
