package serhii.hrynkevych.twentytwo;
//22) How do you access the field ‘i’ of ‘InnerClass’ in the below example?

class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}

//answer
//new OuterClass.InnerClass().i
