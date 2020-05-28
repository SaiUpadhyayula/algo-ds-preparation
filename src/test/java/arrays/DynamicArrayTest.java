package arrays;

import exception.ElementNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DynamicArrayTest {

    @Test
    public void testDynamicArrayCreation() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        assertEquals(0, dynamicArray.size());
        Assert.assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void testAdd() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.add(8);
        dynamicArray.add(9);
        assertEquals(10, dynamicArray.capacity());
        dynamicArray.add(10);
        dynamicArray.add(11);
        assertEquals(15, dynamicArray.capacity());
        assertEquals(12, (int) dynamicArray.add(12));
    }

    @Test
    public void testGet() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(11);
        assertEquals(11, (int) dynamicArray.get(0));
    }

    @Test(expected = ElementNotFoundException.class)
    public void testGetWithInvalidIndex() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(11);
        assertEquals(12, (int) dynamicArray.get(1));
    }

    @Test
    public void testSet() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(0);
        dynamicArray.add(1);
        dynamicArray.add(32);

        dynamicArray.set(2, 2);
        assertEquals(2, (int) dynamicArray.get(2));
    }

    @Test
    public void testRemove() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(0);
        dynamicArray.add(1);
        dynamicArray.add(32);

        int remove = dynamicArray.remove(2);
        assertEquals(32, remove);
        assertEquals(2, dynamicArray.size());
    }
}