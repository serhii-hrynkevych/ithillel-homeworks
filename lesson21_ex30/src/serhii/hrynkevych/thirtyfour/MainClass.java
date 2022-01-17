package serhii.hrynkevych.thirtyfour;

class X
{
    {
        class Y
        {
            {
                System.out.println(1);
            }
        }

        new Y();
    }

    static
    {
        class Z
        {
            {
                System.out.println(2);
            }
        }

        new Z();
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}

//answer
//2
//1
