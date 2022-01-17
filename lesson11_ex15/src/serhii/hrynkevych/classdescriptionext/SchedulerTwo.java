package serhii.hrynkevych.classdescriptionext;

public class SchedulerTwo {

    public enum Weekday {
        MONDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Понедельник";
                    }
                },
        TUESDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Вторник";
                    }
                },

        WEDNESDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Среда";
                    }
                },
        THURSDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Четверг";
                    }
                },
        FRIDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Пятница";
                    }
                },
        SATURDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Суббота";
                    }
                },
        SUNDAY
                {
                    @Override
                    public String toString()
                    {
                        return "Воскресенье";
                    }
                }
    }

    public static void main(String[] args) {
        System.out.println(Weekday.FRIDAY);
        Weekday wd = Weekday.FRIDAY;
        System.out.println(wd);
        System.out.println(wd.toString());
    }
}
