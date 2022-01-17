package serhii.hrynkevych.classdescriptionext;

public class InitField {

    protected static String staticField;
    protected String field;

    static {
        staticField = "Static test";
        System.out.println("Static init:" + staticField);
    }

    {
        field = "Test";
        System.out.println("Object init:" + field);
    }

    public static void main(String[] args) {
        InitFieldTwo init2 = new InitFieldTwo();
        System.out.println(init2.field);
    }

//    public static void main(String[] args) {
//        InitField init1 = new InitField();
//        System.out.println(init1.field);
//
//        InitField init2 = new InitField();
//        System.out.println(init2.field);
//    }
}
