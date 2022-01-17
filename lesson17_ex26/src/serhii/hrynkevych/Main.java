package serhii.hrynkevych;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<InputLines> inputLines = new ArrayList<>();
        try {
            File file = new File("C:/java/homeworks/lesson17_ex26/src/serhii/hrynkevych/base.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                inputLines.add(new InputLines(line.split(" ")));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (InputLines set : inputLines) {
//            System.out.println(set);
//        }

        TreeMap<String, TreeMap<String, Integer>> myTreeMap = new TreeMap<>();
        for (InputLines line : inputLines) {
            if (!myTreeMap.containsKey(line.getClientName())) {
                myTreeMap.put(line.getClientName(), new TreeMap<>());
                myTreeMap.get(line.getClientName()).put(line.getGoodDescription(), line.getPrice());
            } else {
                if (myTreeMap.get(line.getClientName()).containsKey(line.getGoodDescription())) {
                    int newValue = myTreeMap.get(line.getClientName()).get(line.getGoodDescription()) + line.getPrice();
                    myTreeMap.get(line.getClientName()).put(line.getGoodDescription(), newValue);
                } else {
                    myTreeMap.get(line.getClientName()).put(line.getGoodDescription(), line.getPrice());
                }
            }
        }

//        for (InputLines line : inputLines) {
//            if (myTreeMap.get(line.getClientName()).containsKey(line.getGoodDescription())) {
//                int newValue = myTreeMap.get(line.getClientName()).get(line.getGoodDescription()) + line.getPrice();
//                myTreeMap.get(line.getClientName()).put(line.getGoodDescription(), newValue);
//            } else {
//                myTreeMap.get(line.getClientName()).put(line.getGoodDescription(), line.getPrice());
//            }
//        }

        Set<Map.Entry<String, TreeMap<String, Integer>>> entrySetOut = myTreeMap.entrySet();
        for (Map.Entry<String, TreeMap<String, Integer>> entryOut : entrySetOut) {
            System.out.println(entryOut.getKey() + ":");
            Set<Map.Entry<String, Integer>> entrySet1Out = entryOut.getValue().entrySet();
            for (Map.Entry<String, Integer> entry1Out : entrySet1Out) {
                System.out.println(entry1Out.getKey() + " " + entry1Out.getValue());
            }
            System.out.println();
        }
    }
}
