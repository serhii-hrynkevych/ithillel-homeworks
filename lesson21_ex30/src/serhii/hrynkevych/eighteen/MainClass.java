package serhii.hrynkevych.eighteen;
//18) Is the below program written correctly? If yes, what will be the output?

class One
{
    {
        System.out.println("ONE");
    }

    class Two
    {
        {
            System.out.println("TWO");
        }
    }

    static
    {
        System.out.println("THREE");
    }

    static class Three
    {
        {
            System.out.println("FOUR");
        }

        static
        {
            System.out.println("FIVE");
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        One one = new One();

        One.Two two = one.new Two();

        One.Three three = new One.Three();
    }
}

//answer
//написан код на внимательность
//THREE
//ONE
//TWO
//FIVE
//FOUR
