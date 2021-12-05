package serhii.hrynkevych.thirty;
//30) What will be the output of the following program?

class X
{
    static
    {
        class Y
        {
            {
                System.out.println(1);
            }
        }
    }

    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
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
//d) Prints nothing
