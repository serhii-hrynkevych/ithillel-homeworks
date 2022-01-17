package serhii.hrynkevych.fortytwo;
//42) In the below code, Class C extends Class A which has Class B as a member inner class.
// Then, can you tell whether the members of Class B are also inherited to Class C or not?

//42) В приведенном ниже коде класс C расширяет класс A, который имеет класс B как внутренний класс-член.
// Тогда можете ли вы сказать, унаследованы ли члены класса B от класса C или нет?

class A
{
    int a;

    class B
    {
        int b;
    }
}

class C extends A
{

}

//answer
//No. Only members of Class A are inherited to Class C, not the members of Class B.
//Нет. Только члены класса A наследуются классу C, но не члены класса B.
