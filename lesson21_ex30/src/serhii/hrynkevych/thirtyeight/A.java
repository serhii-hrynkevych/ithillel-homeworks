package serhii.hrynkevych.thirtyeight;
//38) How do you instantiate the Class B in the below code outside the Class A?

class A
{
    void methodA()
    {
        class B
        {

        }
    }
}

//answer
//Not possible. Because, Class B is nothing but the local inner class.
// It is visible within the method in which it is defined.
//Невозможно.
// Потому что класс B - это не что иное, как локальный внутренний класс. Он виден внутри метода, в котором он определен.
