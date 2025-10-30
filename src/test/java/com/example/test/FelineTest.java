package com.example.test;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
    private final static String EXPECTED_FAMILY = "Кошачьи";
    private final static String PREDATOR_ANIMAL_KIND = "Хищник";
    private final static int DEFAULT_COUNT_OF_KITTENS = 1;
    private final static int KITTENS_COUNT = 5;


    @Test
    public void testGetFamily_shouldReturnFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Ожидалось другое семейство", EXPECTED_FAMILY, actualFamily);

    }

    @Test
    public void testEatMeat_shouldCallingMethod() throws Exception {
        Feline felineSpy = spy(new Feline());
        felineSpy.eatMeat();
        verify(felineSpy).getFood(PREDATOR_ANIMAL_KIND);

    }

    @Test
    public void testEatMeat_shouldReturnAnimalFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertTrue(food.containsAll(List.of("Животные", "Птицы", "Рыба")));

    }

    @Test
    public void testGetKittens_shouldCallingMethodWithDefaultParameter() {
        Feline felineSpy = spy(new Feline());
        felineSpy.getKittens();
        verify(felineSpy).getKittens(DEFAULT_COUNT_OF_KITTENS);

    }

    @Test
    public void testGetKittens_shouldReturnDefaultQuantity() {
        Feline feline = new Feline();
        int actualCountOfKittens = feline.getKittens();
        assertEquals("Фактическое количество котят не соответствует ожидаемому", DEFAULT_COUNT_OF_KITTENS, actualCountOfKittens);

    }

    @Test
    public void testGetKittens_shouldReturnWithAnInputQuantity() {
        Feline feline = new Feline();
        int actualCountOfKittens = feline.getKittens(KITTENS_COUNT);
        assertEquals("Фактическое количество котят не соответствует ожидаемому", KITTENS_COUNT, actualCountOfKittens);

    }

}
