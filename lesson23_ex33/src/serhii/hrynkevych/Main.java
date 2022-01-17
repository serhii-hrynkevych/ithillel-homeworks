package serhii.hrynkevych;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        verOneHomework();
        System.out.println("\n***\n");
        verTwoHomework();
    }

    private static String textToString() {
        return "Проснувшись однажды утром после беспокойного сна, Грегор Замза обнаружил, что он у себя" +
                " в постели превратился в страшное насекомое. Лежа на панцирнотвердой спине," +
                " он видел, стоило ему приподнять голову, свой коричневый, выпуклый," +
                " разделенный дугообразными чешуйками живот, на верхушке которого еле держалось готовое" +
                " вот-вот окончательно сползти одеяло. Его многочисленные, убого тонкие по сравнению" +
                " с остальным телом ножки беспомощно копошились у него перед глазами.\n" +
                "\n" +
                "«Что со мной случилось?» — подумал он. Это не было сном. Его комната," +
                " настоящая, разве что слишком маленькая, но обычная комната, мирно покоилась в своих четырех" +
                " хорошо знакомых стенах. Над столом, где были разложены распакованные образцы сукон — Замза был" +
                " коммивояжером, — висел портрет, который он недавно вырезал из иллюстрированного журнала" +
                " и вставил а красивую золоченую рамку. На портрете была изображена дама в меховой шляпе и боа," +
                " она сидела очень прямо и протягивала зрителю тяжелую меховую муфту, в которой целиком исчезала" +
                " ее рука.\n" +
                "\n" +
                "Затем взгляд Грегора устремился в окно, и пасмурная погода — слышно было, как по жести подоконника" +
                " стучат капли дождя — привела его и вовсе в грустное настроение. «Хорошо бы еще немного поспать" +
                " и забыть всю эту чепуху», — подумал он, но это было совершенно неосуществимо, он привык спать" +
                " на правом боку, а в теперешнем своем состоянии он никак не мог принять этого положения." +
                " С какой бы силой ни поворачивался он на правый бок, он неизменно сваливался опять на спину." +
                " Закрыв глаза, чтобы не видеть своих барахтающихся мог, он проделал это добрую сотню раз" +
                " и отказался от этих попыток только тогда, когда почувствовал какую-то неведомую дотоле," +
                " тупую и слабую боль в боку.\n" +
                "\n" +
                "«Ах ты, господи, — подумал он, — какую я выбрал хлопотную профессию! Изо дня в день в разъездах." +
                " Деловых волнений куда больше, чем на месте, в торговом доме, а кроме того, изволь терпеть тяготы" +
                " дороги, думай о расписании поездов, мирись с плохим, нерегулярным питанием, завязывай со все" +
                " новыми и новыми людьми недолгие, никогда не бывающие сердечными отношения. Черт бы побрал все это!»" +
                " Он почувствовал вверху живота легкий зуд; медленно подвинулся на спине к прутьям кровати," +
                " чтобы удобнее было поднять голову; нашел зудевшее место, сплошь покрытое, как оказалось," +
                " белыми непонятными точечками; хотел было ощупать это место одной из ножек, но сразу отдернул ее," +
                " ибо даже простое прикосновение вызвало у него, Грегора, озноб.";
    }

    private static List<String> textFileToList() throws IOException {
        return Files.lines(Paths.get("C:\\java\\homeworks\\lesson23_ex33\\src\\serhii\\hrynkevych" +
                "\\resources\\text.txt"))
                .map(text -> text.split("[\\s.,«»!?;:—]+"))
                .map(List::of)
                .flatMap(Collection::stream)
                .filter(word -> word.length() > 0)
                .collect(Collectors.toList());
    }

    private static void verOneHomework() throws IOException {
        String text = textToString();

        //List<String> textToList = Arrays.asList(text.split("[\\s.,«»!?;:—]+"));
        List<String> textToList = textFileToList();

        textToList.stream()
                .distinct()
                .map(String::toLowerCase)
                .sorted(Comparator.comparing(s -> s.charAt(0)))
                .forEach(System.out::println);

        System.out.println("\n---\n");

        Map<Character, List<String>> mapTextList = textToList.stream()
                .distinct()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));

        mapTextList.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(value -> System.out.println(value.getValue().toString().replaceAll("[\\[\\],]", "")));
    }

    private static void verTwoHomework() throws IOException {
        String text = textToString();

        //List<String> textToList = Arrays.asList(text.split("[\\s.,«»!?;:—]+"));
        List<String> textToList = textFileToList();

        textToList.stream()
                .distinct()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s.charAt(0)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()).stream()
                .map(str -> String.join(" ", str))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
