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
        List<Integer> myListArray = new ArrayList<>();
        for (int i = 0; i < this.numberOfElements; i++) {
            myListArray.add(randomNumber());
        }
        return myListArray;
    }

    public Set<Integer> generateSet() {
        if (this.numberOfElements > this.maxNumber - this.minNumber + 1) {
            throw new UnsupportedOperationException();
        }
        Set<Integer> mySet = new HashSet<>();
        int i = 0;
        while (i < this.numberOfElements) {
            int addedNumber = randomNumber();
            if (mySet.add(addedNumber)) {
                i++;
            }
        }
        return mySet;
    }

    private int randomNumber() {
        return (int) (Math.random() * (this.maxNumber - this.minNumber) + this.minNumber);
    }
}
