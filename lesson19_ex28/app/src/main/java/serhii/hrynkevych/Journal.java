package serhii.hrynkevych;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Journal {
    private final List<DayJournal> journal;

    public Journal(List<DayJournal> journal) {
        this.journal = journal;
    }

    public Set<String> selectionUniqueEvents() {
        Set<String> events = new HashSet<>();
        for (DayJournal day : journal) {
            events.addAll(day.getEvents());
        }
        return events;
    }

    public String correlation (String event) {
        int [] countUniqueEvents = countNewUniqueEvent(event);
        double kor = kor(countUniqueEvents);
        return outputKor(event, kor);
    }

    public int[] countNewUniqueEvent(String event) {
        int[] table = new int[4];
        for (DayJournal day : journal) {
            boolean includesEvent = includesEvent(event, day.getEvents());
            if (!includesEvent && !day.isSquirrel()) {
                table[0]++;
            }
            if (includesEvent && !day.isSquirrel()) {
                table[1]++;
            }
            if (!includesEvent && day.isSquirrel()) {
                table[2]++;
            }
            if (includesEvent && day.isSquirrel()) {
                table[3]++;
            }
        }
        return table;
    }

    private boolean includesEvent(String event, List<String> day) {
        return day.contains(event);
    }

    public double kor(int[] countUniqueEvents) {
        int tabl0 = countUniqueEvents[0];
        int tabl1 = countUniqueEvents[1];
        int tabl2 = countUniqueEvents[2];
        int tabl3 = countUniqueEvents[3];
        return (tabl3 * tabl0 - tabl2 * tabl1) / Math.sqrt((tabl2 + tabl3) * (tabl0 + tabl1) * (tabl1 + tabl3) * (tabl0 + tabl2));
    }

    public String outputKor(String event, double kor) {
        if (-0.1 > kor || kor > 0.1) {
            return event + " = " + kor;
        } else {
            return null;
        }
    }

    public void addNewEvent() {
        for (DayJournal day : journal) {
            if (includesEvent("ел арахис", day.getEvents()) && !includesEvent("чистил зубы", day.getEvents())) {
                day.setEvents("арахис-зубы");
            }
        }
    }
}
