package serhii.hrynkevych;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JournalTest {

    private Journal journalTesting;

    @BeforeEach
    void setUp() {
        String filePath = "C:\\java\\homeworks\\lesson19_ex28\\app\\src\\main\\resources\\journal_ru.json";
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            List<DayJournal> journalTest = Arrays.asList(gson.fromJson(reader, DayJournal[].class));
            journalTesting = new Journal(new ArrayList<>(journalTest));
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        }
    }

    @Test
    void testSelectionUniqueEvents() {
        int sizeUniqueEvents = journalTesting.selectionUniqueEvents().size();

        assertEquals(26, sizeUniqueEvents);
    }

    @Test
    void testCorrelation() {
        String resultExpected = journalTesting.correlation("чистил зубы");

        assertEquals("чистил зубы = -0.3805211953235953", resultExpected);
    }

    @Test
    void testCountNewUniqueEvent() {
        int[] resultExpected = new int[] {78, 7, 5, 0};

        int[] table = journalTesting.countNewUniqueEvent("ел салат");

        assertArrayEquals(resultExpected, table);
    }

    @Test
    void testKor() {
        Journal journal = new Journal();
        int[] table = new int[]{85, 0, 0, 5};
        double resultExpected = journal.kor(table);

        assertEquals(1, resultExpected, 1e-9);
    }

    @Test
    void testOutputKor() {
        Journal journalTesting = new Journal();

        String outputKorExpected = journalTesting.outputKor("пил пиво", 0.00003);

        assertNull(outputKorExpected);
    }

    @Test
    void testGsonMethod() {
        List<DayJournal> journals = Main.gsonMethod("C:\\java\\homeworks\\lesson19_ex28\\app\\src\\main\\resources\\journal_ru.json");
        assertEquals(90, journals.size());
    }
}