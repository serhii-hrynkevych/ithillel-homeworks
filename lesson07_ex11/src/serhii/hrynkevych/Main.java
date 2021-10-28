package serhii.hrynkevych;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = openFile();
        assert reader != null;
        int i = countingString(reader);
        String line;
        System.out.println(i);
        String[][] events = new String[i][];
        Boolean[] squirrels = new Boolean[i];
        reader = openFile();
        int j = 0;
        while ((line = reader.readLine()) != null) {
            j++;
            String[] splittingLineArray = splittingLine(line);
            events[j - 1] = creatingOnlyEvents(splittingLineArray);
            squirrels[j - 1] = Boolean.parseBoolean(creatingOnlySquirrels(splittingLineArray));
        }
        System.out.println(Arrays.deepToString(events));
        System.out.println(Arrays.toString(squirrels));
        System.out.println();

        String[] allEvents = selectionOfAllEvents(events);
        String[] uniqueEvents = selectionUniqueEvents(allEvents);
        System.out.println(Arrays.toString(uniqueEvents));
        int[][] countUniqueEvents = countUniqueEvents(uniqueEvents, events, squirrels);
        System.out.println(Arrays.deepToString(countUniqueEvents));
        System.out.println();
        System.out.println("Для корреляции > 0.1 или < -0.1");
        outputKor(countUniqueEvents, uniqueEvents);
        System.out.println();
        addEvents(events);
        System.out.println("Для нового события");
        int[] countingNewEvent = countNewUniqueEvent("арахис-зубы", events, squirrels);
        System.out.println("арахис-зубы = " + kor(countingNewEvent));
    }

    public static BufferedReader openFile() {
        File file = new File("C:\\java\\ithillel-homeworks\\lesson07_ex11\\src\\serhii\\hrynkevych\\journalEvents_ru.csv");
        try {
            FileReader fileReader = new FileReader(file);
            return new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    public static int countingString(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        int i = 0;
        while (line != null) {
            i++;
            line = reader.readLine();
        }
        return i;
    }

    public static String[] splittingLine(String line) {
        return line.split(",");
    }

    public static String[] creatingOnlyEvents(String[] splittingLineArray) {
        String[] onlyEvents = new String[splittingLineArray.length - 1];
        for (int e = 0; e < splittingLineArray.length - 1; e++) { //не исправлял по совету идеи специально
            onlyEvents[e] = splittingLineArray[e];
        }
        return onlyEvents;
    }

    public static String creatingOnlySquirrels(String[] splittingLineArray) {
        return splittingLineArray[splittingLineArray.length - 1];
    }

    public static String[] selectionOfAllEvents(String[][] events) {
        int k = 0;
        for (String[] strings : events) {
            for (int m = 0; m < strings.length; m++) {
                k++;
            }
        }
        int l = 0;
        String[] allEvents = new String[k];
        for (String[] strings : events) {
            for (String string : strings) {
                allEvents[l] = string;
                l++;
            }
        }
        return allEvents;
    }

    public static String[] selectionUniqueEvents(String[] allEvents) {
        Arrays.sort(allEvents);
        int k = 1;
        for (int n = 1; n < allEvents.length; n++) {
            if (!allEvents[n - 1].equals(allEvents[n])) {
                k++;
            }
        }
        String[] uniqueEvents = new String[k];
        uniqueEvents[0] = allEvents[0];
        int l = 1;
        for (int n = 1; n < allEvents.length; n++) {
            if (!allEvents[n - 1].equals(allEvents[n])) {
                uniqueEvents[l] = allEvents[n];
                l++;
            }
        }
        return uniqueEvents;
    }

    public static int[][] countUniqueEvents(String[] uniqueEvents, String[][] events, Boolean[] squirrels) {
        int[][] table = new int[uniqueEvents.length][4];
        for (int u = 0; u < uniqueEvents.length; u++) {
            table[u] = countNewUniqueEvent(uniqueEvents[u], events, squirrels);
        }
        return table;
    }

    public static int[] countNewUniqueEvent(String event, String[][] events, Boolean[] squirrels) {
        int[] table = new int[4];
        for (int i = 0; i < events.length; i++) {
            boolean includesEvent = includesEvent(event, events[i]);
            if (!includesEvent && !squirrels[i]) {
                table[0]++;
            }
            if (includesEvent && !squirrels[i]) {
                table[1]++;
            }
            if (!includesEvent && squirrels[i]) {
                table[2]++;
            }
            if (includesEvent && squirrels[i]) {
                table[3]++;
            }
        }
        return table;
    }

    private static boolean includesEvent(String event, String[] events) {
        for (String e : events) {
            if (e.equals(event)) {
                return true;
            }
        }
        return false;
    }

    public static void outputKor (int[][] countUniqueEvents, String[] uniqueEvents) {
        for (int p = 0; p < uniqueEvents.length; p++) {
            double kor = kor(countUniqueEvents[p]);
            if (-0.1 > kor || kor > 0.1) {
                System.out.println(uniqueEvents[p] + " = " + kor);
            }
        }
    }

    public static double kor(int[] countUniqueEvents) {
        int tabl0 = countUniqueEvents[0];
        int tabl1 = countUniqueEvents[1];
        int tabl2 = countUniqueEvents[2];
        int tabl3 = countUniqueEvents[3];
        return (tabl3 * tabl0 - tabl2 * tabl1) / Math.sqrt((tabl2 + tabl3) * (tabl0 + tabl1) * (tabl1 + tabl3) * (tabl0 + tabl2));
    }

    public static void addEvents(String[][] events) {
        for (int i = 0; i < events.length; i++) {
            String[] dayEvents = events[i];
            if (includesEvent("ел арахис", dayEvents) && !includesEvent("чистил зубы", dayEvents)) {
                String[] newArray = Arrays.copyOf(events[i], events[i].length + 1);
                newArray[newArray.length - 1] = "арахис-зубы";
                events[i] = newArray;
            }
        }
    }
}
