package serhii.hrynkevych.operations;

public class Switch {
    public static void main(String[] arg) {
        switchFirst();
        System.out.println("---");
        switchSecond();
        System.out.println("---");
        switchThird();
        System.out.println("---");
        switchThird();
    }

    public static void switchFirst() {
        int number= 5;

        if(number==1) {
            System.out.println("One");
        } else if(number==2) {
            System.out.println("Two");
        } else if(number==3) {
            System.out.println("Three");
        } else if(number==4) {
            System.out.println("Four");
        } else if(number==5) {
            System.out.println("Five");
        } else if(number==6) {
            System.out.println("Six");
        } else if(number==7) {
            System.out.println("Seven");
        } else if(number==8) {
            System.out.println("Eight");
        } else if(number==9) {
            System.out.println("Nine");
        } else if(number==10) {
            System.out.println("Ten");
        } else {
            System.out.println("Unknown");
        }
    }

    public static void switchSecond() {
        int number = 50;   // Проверяемое число

        switch(number) {
            case 1: System.out.println("One");
            case 2: System.out.println("Two");
            case 3: System.out.println("Three");
            case 4: System.out.println("Four");
            case 5: System.out.println("Five");
            case 6: System.out.println("Six");
            case 7: System.out.println("Seven");
            case 8: System.out.println("Eight");
            case 9: System.out.println("Nine");
            case 10: System.out.println("Ten");
            default: System.out.println("Unknown");
        }
    }

    public static void switchThird() {
        int number= 5;

        switch(number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public static void switchFourth() {
        int number= 1;

        switch(number) {
            case 1:
            case 2:
                System.out.println("One or Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Unknown");
        }
    }
}
