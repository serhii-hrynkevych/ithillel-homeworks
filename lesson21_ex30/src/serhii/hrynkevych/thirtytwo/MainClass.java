package serhii.hrynkevych.thirtytwo;

class A
{
    abstract class B
    {
        abstract void method();
    }

    {
        new B()
        {

            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}

//answer
//BBB
