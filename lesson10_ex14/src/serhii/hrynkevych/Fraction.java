package serhii.hrynkevych;

public class Fraction {
    private int intPart;
    private short decimalPart;
    //если переменную далее в коде покрывать try-catch - идея говорит - нельзя final
    //если нет try-catch - идея говорит только final. этого я пока не понял

    Fraction(int intPart, short decimalPart) {
        this.intPart = intPart;
        this.decimalPart = decimalPart;
    }

    Fraction(String str) {
        String[] numSplit = str.split(",");
        try {
            this.intPart = Integer.parseInt(numSplit[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода целого значения");
            System.exit(1);
        }

        try {
            if (this.intPart < 0) {
                this.decimalPart = (short) (-1 * Short.parseShort(numSplit[1]));
            } else {
                this.decimalPart = Short.parseShort(numSplit[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода дробного значения");
            System.exit(1);
        }
    }

    public int getIntPart() {
        return intPart;
    }

    public short getDecimalPart() {
        return decimalPart;
    }

    public static int[] addition(Fraction num1, Fraction num2) {
        int[] result = new int[2];
        int[] newArrayDecimalParts = equalizationDecimalPart(num1, num2);

        result[0] = num1.getIntPart() + num2.getIntPart();
        result[1] = newArrayDecimalParts[0] + newArrayDecimalParts[1];
        int lengthDecimalPart = countingLength(newArrayDecimalParts[0]);
        int lengthResult1 = countingLength(result[1]);
        if (lengthResult1 > lengthDecimalPart) {
            result[0] += 1;
            result[1] -= exponentiation(10, lengthDecimalPart - 1);
        }
        return result;
    }

    public static int[] subtraction(Fraction num1, Fraction num2) {
        int[] result = new int[2];
        int[] newArrayDecimalParts = equalizationDecimalPart(num1, num2);

        result[0] = num1.getIntPart() - num2.getIntPart();
        result[1] = newArrayDecimalParts[0] - newArrayDecimalParts[1];
        return result;
    }

    private static int[]equalizationDecimalPart(Fraction num1, Fraction num2) {
        int[] arrayDecimalParts = new int[2];
        arrayDecimalParts[0] = Integer.parseInt(String.valueOf(num1.getDecimalPart()));
        arrayDecimalParts[1] = Integer.parseInt(String.valueOf(num2.getDecimalPart()));
        return equalizationLengthDecimalPart(arrayDecimalParts);
    }

    public static int[] equalizationLengthDecimalPart(int[] arrayDecimalParts) {
        int lengthDecimalPartNum1 = countingLength(Math.abs(arrayDecimalParts[0]));
        int lengthDecimalPartNum2 = countingLength(Math.abs(arrayDecimalParts[1]));
        int lengthDecimalPartDifference;
        if (lengthDecimalPartNum1 < lengthDecimalPartNum2) {
            lengthDecimalPartDifference = lengthDecimalPartNum2 - lengthDecimalPartNum1;
            arrayDecimalParts[0] = (exponentiation(arrayDecimalParts[0], lengthDecimalPartDifference));
        }
        if (lengthDecimalPartNum1 > lengthDecimalPartNum2) {
            lengthDecimalPartDifference = lengthDecimalPartNum1 - lengthDecimalPartNum2;
            arrayDecimalParts[1] = (exponentiation(arrayDecimalParts[1], lengthDecimalPartDifference));
        }
        return arrayDecimalParts;
    }

    private static int countingLength(int num) {
        int count = 0;
        if (num < 10) {
            return count + 1;
        }
        return count +1 + countingLength(num / 10);
    }

    private static int exponentiation(int decimalPart, int degree) {
        if (degree == 0) {
            return decimalPart;
        }
        return exponentiation(decimalPart * 10, degree - 1);
    }
}
