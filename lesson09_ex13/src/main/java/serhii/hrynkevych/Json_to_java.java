package serhii.hrynkevych;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Json_to_java
{
    public static void main( String[] args ) {
        String filePath = "C:\\\\java\\\\ithillel-homeworks\\\\lesson09_ex13\\\\src\\\\main\\\\java\\\\serhii\\\\hrynkevych\\\\journal_ru.json";
        List<DayJournal> journal = jacksonMethod(filePath);
        outputData(journal);
    }

    public static List<DayJournal> gsonMethod(String filePath) {
        List<DayJournal> journal = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            journal = Arrays.asList(gson.fromJson(reader, DayJournal[].class));
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        }
        return journal;
    }

    public static List<DayJournal> jacksonMethod(String filePath) {
        List<DayJournal> journal = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try (Reader reader = new FileReader(filePath)) {
            journal = Arrays.asList(mapper.readValue(reader, DayJournal[].class));
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        }
        return journal;
    }

    public static void outputData(List<DayJournal> journal) {
        for (DayJournal dayJournal : journal) {
            System.out.println(dayJournal);
        }
        System.out.println(journal.size());
    }
}
