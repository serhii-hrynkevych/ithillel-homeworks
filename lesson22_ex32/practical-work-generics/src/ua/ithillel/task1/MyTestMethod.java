package ua.ithillel.task1;

public class MyTestMethod {

    public static <T extends Number> String calcNum(T[] array, T value) {
        int count = 0;
        for (T t : array) {
            if (t.doubleValue() > value.doubleValue()) { //привожу к double так как знаю условие задачи.
                count++;
            }
        }
        return "Количество элементов массива типа (" + array.getClass().getName()
                + ") со значением большим за value=" + value + ": " + count;
    }

    public static <T extends Number> String calcSum(T[] array, T value) {
        double count = 0;
        for (T t : array) {
            if (t.doubleValue() > value.doubleValue()) {
                count = count + t.doubleValue();
            }
        }
        return "Сумма элементов массива типа (" + array.getClass().getName()
                + ") со значением большим за value=" + value + ": " + count;
    }
}
