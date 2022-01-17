package serhii.hrynkevych;

import java.util.List;

public class DayJournal {
    private List<String> events;
    private boolean squirrel;

    public DayJournal() {
    }

    public void setEvents(String event) {
        this.events.add(event);
    }

    public List<String> getEvents() {
        return events;
    }

    public boolean isSquirrel() {
        return squirrel;
    }

    @Override
    public String toString() {
        return "{events=" + events + ", squirrel=" + squirrel + "}\n";
    }
}
