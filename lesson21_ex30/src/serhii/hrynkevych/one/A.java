package serhii.hrynkevych.one;
//Can you find out the error in the following code?

class A
{
    class B
    {
        void methodB() //не может быть static
        {
            System.out.println("Method B");
        }
    }
}
