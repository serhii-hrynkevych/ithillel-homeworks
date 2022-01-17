package serhii.hrynkevych;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    String testLine = "aaa, 000";
    MyPhoneBook myPhoneBookTest;

    @BeforeEach
    void setUp() {
        myPhoneBookTest = new MyPhoneBook();
    }

    @Test
    void workProgram() {
        int result = Main.workProgram("fff");
        assertEquals(9, result);
    }
//
    @Test
    void addNewPhone() {
        String result = Main.addNewPhone(myPhoneBookTest, testLine);
        String expected = "Новая запись успешно добавлена\n";
        assertEquals(expected, result);
    }
}