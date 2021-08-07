package bst;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;
    private BinarySearchTree<Car> bstC;
    private BinarySearchTree<String> bstString;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
        bstC = new BinarySearchTree<Car>((e1, e2) -> ((Comparable) e1.getReg()).compareTo(e2.getReg()));
        bstString = new BinarySearchTree<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        bst = null;
        bstString = null;
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertTrue(bst.add(1));
        assertTrue(bst.add(2));
        assertFalse(bst.add(2));
        assertFalse(bst.add(1));
        assertEquals(bst.size(), 2);
        assertTrue(bst.add(3));
        assertTrue(bst.add(0));
        assertEquals(bst.size(), 4);

        assertTrue(bstString.add("testA"));
        assertTrue(bstString.add("testB"));
        assertFalse(bstString.add("testA"));
        assertFalse(bstString.add("testB"));
        assertEquals(bstString.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void addCars() {

        assertEquals(bstC.size(), 0);
        assertTrue(bstC.add(new Car((234))));
        assertTrue(bstC.add(new Car(456)));
        assertTrue(bstC.add(new Car(123)));
        assertEquals(bstC.size(), 3);
        assertFalse(bstC.add(new Car((234))));
        assertFalse(bstC.add(new Car(456)));
        assertFalse(bstC.add(new Car(123)));
        assertEquals(bstC.size(), 3);
    }

    @org.junit.jupiter.api.Test
    void height() {

        assertEquals(bst.height(), 0);
        bst.add(4);
        assertEquals(bst.height(), 1);
        bst.add(5);
        bst.add(6);
        bst.add(20);
        bst.add(21);
        bst.add(22);
        assertEquals(bst.height(), 6);
        bst.add(0);
        assertEquals(bst.height(), 6);
        bst.add(1);
        assertEquals(bst.height(), 6);
        bst.add(2);
        assertEquals(bst.height(), 6);
        bst.add(-2);
        assertEquals(bst.height(), 6);
        bst.add(7);
        bst.add(8);
        bst.add(9);
        assertEquals(bst.height(), 7);


        assertEquals(bstString.height(), 0);
        bstString.add("c");
        assertEquals(bstString.height(), 1);
        bstString.add("d");
        bstString.add("e");
        bstString.add("f");
        assertEquals(bstString.height(), 4);
        bstString.add("a");
        assertEquals(bstString.height(), 4);
        bstString.add("b");
        assertEquals(bstString.height(), 4);

        assertEquals(bstC.height(), 0);
        bstC.add(new Car(123));
        bstC.add(new Car(234));
        bstC.add(new Car(012));
        assertEquals(bstC.height(), 2);
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(bst.size(), 0);
        bst.add(2);
        assertEquals(bst.size(), 1);
        bst.add(4);
        assertEquals(bst.size(), 2);
        bst.add(1);
        assertEquals(bst.size(), 3);

        assertEquals(bstString.size(), 0);
        bstString.add("b");
        assertEquals(bstString.size(), 1);
        bstString.add("c");
        assertEquals(bstString.size(), 2);
        bstString.add("a");
        assertEquals(bstString.size(), 3);

        assertEquals(bstC.size(), 0);
        bstC.add(new Car(123));
        bstC.add(new Car(234));
        bstC.add(new Car(012));
        assertEquals(bstC.size(), 3);
    }

    @org.junit.jupiter.api.Test
    void clear() {
        bst.add(5);
        bst.add(6);
        bst.add(20);
        bst.add(1);
        bst.add(22);
        assertEquals(bst.size(), 5);
        bst.clear();
        assertEquals(bst.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void printTree() {
    }

    @org.junit.jupiter.api.Test
    void rebuild() {
    }
}