package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionDoesHaveManeParameterizedTest {
    private Feline feline;
    private final String gender;
    private final boolean hashMane;

    public LionDoesHaveManeParameterizedTest(String gender, boolean hashMane) {
        this.gender = gender;
        this.hashMane = hashMane;
    }

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
    }


    @Parameterized.Parameters
    public static Object[][] getParameter() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(gender, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hashMane, actual);
    }
}