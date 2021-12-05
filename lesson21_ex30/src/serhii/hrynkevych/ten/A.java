package serhii.hrynkevych.ten;
//10) Can you find out the error in the following code?

class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
    }

    void methodThree()
    {
        //new B().methodTwo(); //Локальные внутренние классы не видны вне метода или блока, в котором они определены.
    }
}
