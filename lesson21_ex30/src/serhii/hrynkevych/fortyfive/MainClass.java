package serhii.hrynkevych.fortyfive;
//45) What will be the output of the following program?

class A
{
    interface I
    {
        int i = 4444;

        void show(int i);
    }

    class B implements I
    {
        public void show(int i)
        {
            System.out.println(this.i);
        }
    }

    void methodA(int i)
    {
        new B().show(i);
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new A().methodA(1111);
    }
}

//answer
//4444
