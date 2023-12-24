import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    public static ArrayList lst;
    @BeforeAll
    public static void setUp(){
        lst = new ArrayList<String>();
        lst.add("apple");
        lst.add("banana");
    }

    @Test
    public void insertTest(){
        assertEquals(2,lst.size(),"Size is not correct");
        lst.add("orange");
        assertEquals(3,lst.size(),"Size is not correct");

        assertEquals("apple",lst.get(0),"Wrong Element");
        assertEquals("banana",lst.get(1),"Wrong Element");
        assertEquals("orange",lst.get(2),"Wrong Element");
    }
    @Test
    public void replaceTest(){
        lst.set(1, "orange");

        assertEquals(2, lst.size(), "Wrong size");
        // Assert individual elements
        assertEquals("apple", lst.get(0), "Wrong element");
        assertEquals("orange", lst.get(1), "Wrong element");
    }
}







