package serhii.hrynkevych.classdescriptionext;

public class Scheduler {

    public enum Weekday {
        MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"),
        THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");

        String value;
        Weekday(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) {
        Weekday wd = Weekday.FRIDAY;
        System.out.println(wd.toString());
    }
}
