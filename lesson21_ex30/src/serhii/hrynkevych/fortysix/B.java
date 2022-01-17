package serhii.hrynkevych.fortysix;
//46) Can you find out the error in the below code?

class A
{
    private static class B
    {

    }
}

//class B extends A.B
//{
//
//}

//answer
//Class B can not extend Class A.B. Because, A.B is declared as private. It is not visible outside the class A.
//Класс B не может расширять класс A.B. Потому что A.B объявлен закрытым. Он не виден за пределами класса А.
