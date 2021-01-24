package p03_IteratorTest;


import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;


import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] ELEMENTS={"A","B","C","D"};


    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator=new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingListIteratorShouldThrowWithNullAsParameter() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMoveShouldReturnCorrectBoolean(){
     // int counter=0;
     // while (listIterator.move()) {
     //     counter++;
     // }
     // assertEquals(3,counter);
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());

    }

    @Test
    public void testHasNextShouldReturnCorrectBoolean(){
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWithoutElementsPresent () throws OperationNotSupportedException {
        ListIterator listIterator=new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldPrintCorrectElement() {

        for (int index=0; listIterator.hasNext();listIterator.move()) {
            assertEquals(ELEMENTS[index++], listIterator.print());
        }
    }

}
