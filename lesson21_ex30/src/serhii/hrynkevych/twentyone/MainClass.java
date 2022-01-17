package serhii.hrynkevych.twentyone;
//21) What will be the output of the following program?

abstract class X
{
    static String s1 = "STATIC";

    String s2 = "NON-STATIC";

    abstract void methodX();

    static abstract class Y
    {
        String s1 = "NON-STATIC";

        static String s2 = "STATIC";

        abstract void methodY();
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new X()
        {
            void methodX()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();

        new X.Y()
        {
            void methodY()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();
    }
}

//answer
//STATIC NON-STATIC
//NON-STATIC STATIC
