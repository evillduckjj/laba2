import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class myLinkedListTest {

    @Test
    void myLinkedListCopyConstructor_Default_True() {
        myLinkedList list = LinkedListFabric();
        myLinkedList result= new myLinkedList(list);
        assertEquals(result.size(), 4);
        assertEquals(result.toString(), "abcd");
    }
    @Test
    void addFirst_Default_True() {
        myLinkedList<String> list = new myLinkedList();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        assertEquals(list.size(), 4);
        assertEquals(list.toString(), "dcba");


    }

    @Test
    void addLast_Default_True() {
        myLinkedList list = LinkedListFabric();
        list.addLast("ss");
        assertEquals(list.size(), 5);
        assertEquals(list.toString(), "abcdss");
    }

    @Test
    void removeFirst_Default_True() {
        myLinkedList list = LinkedListFabric();
        list.removeFirst();
        list.removeFirst();
        assertEquals(list.size(), 2);
        assertEquals(list.toString(), "cd");
        list.removeFirst();
        list.removeFirst();
        assertEquals(list.size(), 0);
        assertEquals(list.toString(), "");

    }

    @Test
    void removeFirst_NullSize_RuntimeException() {
        myLinkedList<String> list = new myLinkedList<>();
        assertThrows(RuntimeException.class, ()-> {
            list.removeFirst();
        });
        assertEquals(list.size(), 0);
        assertEquals(list.toString(), "");

    }

    @Test
    void removeAll_Default_True() {
        myLinkedList list = LinkedListFabric();
        list.removeAll();
        assertEquals(list.size(), 0);
        assertEquals(list.toString(), "");
    }

    @Test
    void removeAll_NullSize_RuntimeException() {
        myLinkedList<String> list = new myLinkedList<>();

        assertThrows(RuntimeException.class, ()-> {
            list.removeAll();
        });
        assertEquals(list.size(), 0);
        assertEquals(list.toString(), "");
    }
    @Test
    void size_Default_True() {
        myLinkedList list = LinkedListFabric();
        assertEquals(list.size(), 4);
    }

    @Test
    void remove_Default_True() {
        myLinkedList list = LinkedListFabric();
        list.remove("d");
        list.remove("b");
        assertEquals(list.size(), 2);
        assertEquals(list.toString(), "ac");
        list.remove("a");
        assertEquals(list.size(), 1);
        assertEquals(list.toString(), "c");
    }

    @Test
    void remove_WrongItem_Exception() {
        myLinkedList list = LinkedListFabric();
        assertThrows(IllegalArgumentException.class, ()->{
            list.remove("f");
        });
        assertEquals(list.size(), 4);
    }

    @Test
    void toArray_Default_True() {
        myLinkedList list = LinkedListFabric();
        Object[] resultArray = {"a", "b", "c", "d"};
        assertArrayEquals(list.toArray(), resultArray);
    }


    private myLinkedList LinkedListFabric () {
        myLinkedList<String> list = new myLinkedList<>();
        list.addFirst("d");
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
         return list;
    }
}