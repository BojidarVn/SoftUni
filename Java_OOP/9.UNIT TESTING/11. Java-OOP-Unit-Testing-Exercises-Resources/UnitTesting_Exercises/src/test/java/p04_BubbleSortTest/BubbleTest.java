package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Equals;

import static org.junit.Assert.assertEquals;

public class BubbleTest {

    @Test
    public void testSort(){
        int[] arr={13,-1,56,98,43,0};
        int[] expected={-1,0,13,43,56,98};
        Bubble.sort(arr);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i],arr[i]);
        }

    }
}
