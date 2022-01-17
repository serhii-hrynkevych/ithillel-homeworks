package serhii.hrynkevych.seven;
//7) Is the below program written correctly? If yes, what will be the output?

abstract class A
{
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };
    }
}

//Answer:
//Yes, program is correct. Output will be,
//2
//1
