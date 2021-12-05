package serhii.hrynkevych.thirtynine;
//39) You know that member inner classes can’t have static members in them.
// If it is true then why the below code doesn’t show any errors even though class B has a static field?

class A
{
    class B
    {
        static final int i = 111;
    }
}

//answer
//Member inner classes can have static fields if they are final. It is applicable to only fields not to methods.
//Внутренние классы-члены могут иметь статические поля, если они являются окончательными.
// Это применимо только к полям, а не к методам.
