package edu.escuelaing.arep.collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class LinkedListTest {


    @Test
    public void shouldAddElementsToTheLinkedListAndGetTheSize() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        assertEquals(10, linkedList.size());
    }

    @Test
    public void shouldAddAllElementsFromACollection(){
        List<Integer> toAddList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 250; i++) {
            toAddList.add(i);
        }
        linkedList.addAll(toAddList);
        assertEquals(250, linkedList.size());
    }

    @Test
    public void shouldGetTheElementAtTheSpecifiedIndex() {
        List<Integer> compareList =  new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 250; i++) {
            compareList.add(random.nextInt(1000));
        }
        linkedList.addAll(compareList);
        for (int i = 0; i < compareList.size(); i++){
            assertEquals(compareList.get(i), linkedList.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowOutOfBoundsExceptionOnGet() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        linkedList.get(1540);
    }

    @Test
    public void shouldRemoveElementAtSpecifiedIndex() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        assertEquals(0, (int) linkedList.remove(0));
        assertEquals(9, linkedList.size());
        assertEquals(3, (int) linkedList.remove(2));
        assertEquals(8, linkedList.size());
        assertEquals(2, (int) linkedList.remove(1));
        assertEquals(7, linkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowOutOfBoundsExceptionOnRemove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        linkedList.remove(-1);
    }

}