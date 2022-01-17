package serhii.hrynkevych.nine;
//9) What will be the output of the below program?

class A
{
    static String s = "AAA";

    class B
    {
        String s = "BBB";

        void methodB()
        {
            System.out.println(s);
        }
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();

        System.out.println(a.s);

        A.B b = a.new B();

        System.out.println(b.s);

        b.methodB();
    }
}

//answer:
//AAA
//BBB
//BBB
