package serhii.hrynkevych.five;
//5) Does below program print “SUCCESS” on the console when you run it?

class A
{
    {
        new B();
    }

    static class B
    {
        {
            new A().new C();
        }
    }

    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}

//answer:
//No
//Exception in thread "main" java.lang.StackOverflowError
//	at serhii.hrynkevych.five.A$B.<init>(A.java:12)
//	at serhii.hrynkevych.five.A.<init>(A.java:6)

//No. It will throw StackOverflowError. Because, new A() and new B() will be cyclically called.
