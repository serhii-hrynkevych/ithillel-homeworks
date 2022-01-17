package serhii.hrynkevych;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyPhoneBookTest {
    String testLine = "aaa, 000";
    MyPhoneBook myPhoneBookTest;

    @BeforeEach
    void setUp() {
        myPhoneBookTest = new MyPhoneBook();
    }

    @Test
    void testMyPhoneBookCreatedList() {
        int resultSize = myPhoneBookTest.getPhoneRecordList().size();
        assertEquals(0, resultSize);
    }

    @Test
    void testSplitInputLine() {
        String[] result = myPhoneBookTest.splitInputLine(testLine);
        String[] expectedResut = testLine.split(", ");
        assertEquals(Arrays.toString(expectedResut), Arrays.toString(result));
    }

    @Test
    void testCheckInputLine() {
        String[] testArray = testLine.split(", ");
        boolean result = myPhoneBookTest.checkInputLine(testArray);
        assertTrue(result);
    }

    @Test
    void testAddPhoneNumber() {
        boolean result = myPhoneBookTest.addPhoneNumber(testLine);
        assertTrue(result);
    }
}