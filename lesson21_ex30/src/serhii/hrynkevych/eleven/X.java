package serhii.hrynkevych.eleven;
//11) What will be the output of the following program?

class X
{
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }

    public X()
    {
        new Y();
    }

    static class Y
    {
        {
            System.out.println(3);
        }

        static
        {
            System.out.println(4);
        }
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();

        X.Y y = new X.Y();
    }
}

//answer:
//2
//1
//4
//3
//3
