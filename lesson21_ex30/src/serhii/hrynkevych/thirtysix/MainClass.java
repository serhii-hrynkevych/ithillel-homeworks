package serhii.hrynkevych.thirtysix;
//36) What will be the output of the following program?

class OuterClass
{
    static class InnerClassOne
    {
        int i = 1221;

        int getI()
        {
            return i = i++ - ++i;
        }
    }

    static class InnerClassTwo extends InnerClassOne
    {
        @Override
        int getI()
        {
            return i = i-- + --i;
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        OuterClass.InnerClassOne one = new OuterClass.InnerClassOne();

        System.out.println(one.getI());

        one = new OuterClass.InnerClassTwo();

        System.out.println(one.getI());
    }
}

//answer
//-2
//2440
