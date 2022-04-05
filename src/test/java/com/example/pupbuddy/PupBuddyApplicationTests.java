package com.example.pupbuddy;

import com.example.pupbuddy.dao.IChoreDAO;
import com.example.pupbuddy.dto.Chore;
import com.example.pupbuddy.dto.Dog;
import com.example.pupbuddy.dto.Human;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import lombok.Data;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PupBuddyApplicationTests {

    /**
     * Validate service methods for Chore with a sample set of data
     */
    private Chore chore = new Chore();
    private Chore dinner = new Chore();
    private Chore secondDinner = new Chore();

    @MockBean
    private IChoreDAO choreDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void selectFeedDinner_recordsFeedDinnerActivityAsDone() throws Exception {
        givenActivitiesFeedAvailable();
        whenFeedDinnerActivityLoggedDone();
        thenFeedDinnerActivityRecordedDone();
    }

    private void givenActivitiesFeedAvailable() throws Exception {
        Mockito.when(choreDAO.save(chore)).thenReturn(chore);
    }

    private void whenFeedDinnerActivityLoggedDone() {
        chore.setChoreEnd(new Date());
    }

    private void thenFeedDinnerActivityRecordedDone() {
        // TODO in order to make this test pass, override setChoreEnd() to set choreComplete based on the value of choreEnd
        assertEquals(true, chore.isChoreComplete());
    }

    @Test
    void feedDinnerActivityLoggedAsDone_returnsErrorMessageForDuplicateTask() {
        givenFeedDinnerActivityLoggedDoneForDate();
        whenAttemptLogFeedDinnerActivityForSameDate();
        thenReturnErrorMessageDuplicateTask();
    }

    private void givenFeedDinnerActivityLoggedDoneForDate() {
        dinner = new Chore();
        dinner.setChoreId("1");
        dinner.setChoreName("Feed dinner");
        dinner.setChoreEnd(new Date(2022,1,1,18,0,0));
        Mockito.when(choreDAO.fetch("1")).thenReturn(dinner);
    }

    private void whenAttemptLogFeedDinnerActivityForSameDate() {
        secondDinner = new Chore();
        secondDinner.setChoreId("2");
        secondDinner.setChoreName("Feed dinner");
        secondDinner.setChoreEnd(new Date(2022,1,1,18,1,0));
        Mockito.when(choreDAO.fetch("2")).thenReturn(secondDinner);
    }

    private void thenReturnErrorMessageDuplicateTask() {
        assertThrows(Exception.class, () -> {
            Calendar dinnerDate = Calendar.getInstance();
            dinnerDate.setTime(choreDAO.fetch("1").getChoreEnd());
            Calendar secondDinnerDate = Calendar.getInstance();
            secondDinnerDate.setTime(choreDAO.fetch("2").getChoreEnd());
            if(dinnerDate.get(Calendar.YEAR) == secondDinnerDate.get(Calendar.YEAR)
               && dinnerDate.get(Calendar.DAY_OF_MONTH) == secondDinnerDate.get(Calendar.DAY_OF_MONTH)) {
                Mockito.when(choreDAO.save(secondDinner)).thenThrow(new Exception("Duplicate task"));
            }
            choreDAO.save(secondDinner);
        });
    }

    /**
     * Validate that the DTO properties can be set and retrieved for each class
     */
    @Test
    void verifyChoreProperties() {
        String choreName =  "TestChore";

        Chore chore = new Chore();
        chore.setChoreName(choreName);
        assertEquals(choreName, chore.getChoreName());
    }

    @Test
    void verifyDogProperties() {
        String dogName =  "Testy";

        Dog dog = new Dog();
        dog.setDogName(dogName);
        assertEquals(dogName, dog.getDogName());
    }

    @Test
    void verifyHumanProperties() {
        String humanName =  "Test Ing";

        Human human = new Human();
        human.setHumanName(humanName);
        assertEquals(humanName, human.getHumanName());
    }

}
