package serhii.hrynkevych;

public class Main {

    public static void main(String[] args) {
        int target = 14;
        System.out.println(find(1,"1", target));
    }

    public static String find(int current, String history, int target) {
        if (current == target) {
            return history;
        } else if (current > target) {
            return null;
        }
        String found = find(current + 5, "(" + history + " + 5)", target);
        if (found == null) {
            return find(current * 3, "(" + history + " * 3)", target);
        } else {
            return found;
        }
    }
}

//        int inputNumber = 4567;
//        System.out.println(findSteps(inputNumber, 1, "1"));
//    }
//
//    public static String findSteps(int inputNumber, int startNumber, String result) {
//        if (startNumber + 5 == inputNumber) {
//            result = "(" + result + " + 5)";
//        }
//        if (startNumber < inputNumber) {
//            result = findSteps(inputNumber, startNumber + 5, "(" + result + " + 5)");
//        }
//        if (startNumber * 3 == inputNumber) {
//            result = "(" + result + " * 3)";
//        }
//        if (startNumber < inputNumber) {
//            result = findSteps(inputNumber, startNumber * 3, "(" + result + " * 3)");
//        }
//        return result;
