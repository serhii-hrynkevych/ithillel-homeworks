package serhii.hrynkevych.seventeen;
//17) Why the below code is showing compilation error?

class One
{
    void methodOne()
    {
//        public class Two
//        {
//
//        }
    }
}

//answer
//Local inner classes can’t be declared with access modifiers (private or protected or public).
//Локальные внутренние классы нельзя объявлять с модификаторами доступа (частными, защищенными или общедоступными).
