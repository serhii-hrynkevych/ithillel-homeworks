package serhii.hrynkevych;

import java.util.List;

public class DayJournal {
    public List<String> events;
    public boolean squirrel;

    @Override
    public String toString() {
        return "{events=" + events + ", squirrel=" + squirrel + "}";
    }
}
