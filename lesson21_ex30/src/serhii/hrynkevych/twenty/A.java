package serhii.hrynkevych.twenty;
//20) Can an inner class extend it’s outer class like below?

class A
{
    class B extends A
    {
        class C extends B
        {
            class D extends C
            {

            }
        }
    }
}

//answer
//Yes, an inner class can extend it’s outer class.
//Да, внутренний класс может расширять свой внешний класс.
