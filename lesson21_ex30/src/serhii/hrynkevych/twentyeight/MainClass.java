package serhii.hrynkevych.twentyeight;
//28) What will be the output of the following program?

class A
{
    int i = 1;

    class B
    {
        int i = 2;

        class C extends A
        {
            void methodC()
            {
                System.out.println(i);
            }
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new A().new B().new C().methodC();
    }
}

//answer
//1
