package serhii.hrynkevych;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private final int numberOfElements;
    private final int minNumber;
    private final int maxNumber;

    public NumberGenerator(int numberOfElements, int minNumber, int maxNumber) {
        this.numberOfElements = numberOfElements;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public List<Integer> generateList() {
        List<Integer> listArray = new ArrayList<>();
        for (int i = 0; i < this.numberOfElements; i++) {
            listArray.add(randomNumber());
        }
        return listArray;
    }

    public Set<Integer> generateSet() {
        Set<Integer> listSet = new HashSet<>();
        if (this.numberOfElements > (Math.abs(this.minNumber) + Math.abs(this.maxNumber) + 1)) {
            throw new UnsupportedOperationException();
        }
        int addedNumber = randomNumber();
        for (int i = 0; i < this.numberOfElements; i++) {
            if (addedNumber > this.maxNumber) {
                addedNumber = this.minNumber;
            }
            listSet.add(addedNumber);
            addedNumber += 1;
        }
        return listSet;
    }

    private int randomNumber() {
        return (int) (Math.random() * (this.maxNumber - this.minNumber) + this.minNumber);
    }
}
