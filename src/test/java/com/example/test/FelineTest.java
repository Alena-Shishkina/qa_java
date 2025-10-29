package com.example.test;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
    private final static String EXPECTED_FAMILY = "Кошачьи";
    private final static String PREDATOR_ANIMAL_KIND = "Хищник";
    private final static int DEFAULT_COUNT_OF_KITTENS = 1;
    private final static int KITTENS_COUNT = 5;

    @Spy
    Feline feline;

    @Test
    public void getFamilyTest() {
        String actualFamily = feline.getFamily();
        assertEquals("Ожидалось другое семейство", EXPECTED_FAMILY, actualFamily);

    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        verify(feline, times(1)).getFood(PREDATOR_ANIMAL_KIND);
    }

    @Test
    public void getKittensDefaultCountTest() {
        int actualCountOfKittens = feline.getKittens();
        verify(feline).getKittens(DEFAULT_COUNT_OF_KITTENS);
        assertEquals("Фактическое количество котят не соответствует ожидаемому", DEFAULT_COUNT_OF_KITTENS, actualCountOfKittens);

    }

    @Test
    public void getKittensTest() {
        int actualCountOfKittens = feline.getKittens(KITTENS_COUNT);
        verify(feline).getKittens(Mockito.anyInt());
        assertEquals("Фактическое количество котят не соответствует ожидаемому", KITTENS_COUNT, actualCountOfKittens);
    }


}
