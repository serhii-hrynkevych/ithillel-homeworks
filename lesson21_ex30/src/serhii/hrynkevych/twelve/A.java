package serhii.hrynkevych.twelve;
//12) Why the below code is showing compilation error?

class A
{
    class B
    {
        {
            System.out.println(1);
        }

//        static
//        {
//            System.out.println(2);
//        }
    }
}

//answer:
//Нестатические внутренние классы не должны содержать статических инициализаторов
