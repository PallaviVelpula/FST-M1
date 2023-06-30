package activities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Activity1 {
    static ArrayList<String > list;
    @BeforeEach
    public void setUp(){
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    public void insertTest(){
        Assertions.assertEquals(2, list.size());
        list.add("gamma");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("alpha", list.get(0));
        Assertions.assertEquals("beta", list.get(1));
        Assertions.assertEquals("gamma", list.get(2));
    }

    @Test
    public void replaceTest(){
        Assertions.assertEquals(2, list.size());
        list.add("gamma");
        Assertions.assertEquals(3, list.size());
        list.set(1, "delta");
        Assertions.assertEquals("alpha", list.get(0));
        Assertions.assertEquals("delta", list.get(1));
        Assertions.assertEquals("gamma", list.get(2));
    }
}
