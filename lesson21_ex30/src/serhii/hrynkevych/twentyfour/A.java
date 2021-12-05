package serhii.hrynkevych.twentyfour;
//24) Write a Class C which should extend Class B in the below example?
//24) Напишите класс C, который должен расширять класс B в приведенном ниже примере?

class A
{
    class B
    {

    }
}

//answer

class C extends A.B
{
    public C()
    {
        new A().super();
    }
}
