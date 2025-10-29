package com.example.test;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    private Cat cat;
    private final static String CAT_SOUND = "Мяу";

    @Mock
    Feline feline;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String actualSound = cat.getSound();
        assertEquals(CAT_SOUND, actualSound);

    }

    @Test
    public void getFoodTest() throws Exception {
        cat.getFood();
        verify(feline).eatMeat();
    }
}
