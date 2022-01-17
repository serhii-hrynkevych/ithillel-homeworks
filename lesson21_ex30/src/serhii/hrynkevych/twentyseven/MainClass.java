package serhii.hrynkevych.twentyseven;
//27) What will be the output of the below program?

class ABC
{
    class XYZ
    {
        String s = "Inner - XYZ";
    }
}

class XYZ extends ABC
{
    String s = "Outer - XYZ";

    class ABC extends XYZ
    {

    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(new XYZ().new ABC().s);
    }
}

//Inner - XYZ
