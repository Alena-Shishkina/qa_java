package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    private final static String GENDER_MALE = "Самец";
    private final static String GENDER_FEMALE = "Самка";
    private final static String EXCEPTION_GENDER = "Мужской";
    private final static String EXCEPTION_MESSAGE = "Используйте допустимые значения пола животного - самей или самка";
    private final static int KITTENS_COUNT = 2;

    @Mock
    Feline feline;

    @Test
    public void testGetFood_shouldCallingMethodAnimalClass() throws Exception {
        Lion lion = new Lion(GENDER_MALE, feline);
        lion.getFood();
        verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void testGetFood_shouldReturnAnimalFoodList() throws Exception {
        Lion lion = new Lion(GENDER_MALE, feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals("Ожидался другой рацион", expectedFood, actualFood);
    }

    @Test
    public void testDoesHaveMane_shouldReturnException() {
        try {
            new Lion(EXCEPTION_GENDER, feline);
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

    @Test
    public void testGetKittens_shouldCallingMethodWithAnInputParameter() throws Exception {
        Lion lion = new Lion(GENDER_FEMALE, feline);
        lion.getKittens(KITTENS_COUNT);
        verify(feline).getKittens();

    }

    @Test
    public void testGetKittens_shouldReturnWithAnInputQuantity() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion(GENDER_FEMALE, feline);
        int actualCountOfKittens = lion.getKittens(KITTENS_COUNT);
        assertEquals("Фактическое количество котят не соответствует ожидаемому", KITTENS_COUNT, actualCountOfKittens);
    }
}

