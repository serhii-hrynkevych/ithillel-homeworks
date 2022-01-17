package serhii.hrynkevych.six;
//6) Is the below code written correctly?

class A
{
    String s = "AAA";

    void methodA()
    {
        System.out.println(s);
    }

    static class B
    {
        void methodB()
        {
            //methodA();
        }
    }
}

//answer:
//No.
//You can’t use non-static method of outer class inside a static nested class directly. You have to instantiate the outer class.
