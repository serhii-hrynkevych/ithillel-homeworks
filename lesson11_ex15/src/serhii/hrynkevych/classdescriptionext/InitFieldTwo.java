package serhii.hrynkevych.classdescriptionext;

public class InitFieldTwo extends InitField {

    static {
        staticField = "Other static";
        System.out.println("Static init two:" + staticField);
    }

    {
        field = "Other";
        System.out.println("Object init two:" + field);
    }
}
