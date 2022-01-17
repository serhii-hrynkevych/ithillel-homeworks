package serhii.hrynkevych.thirtyfive;
//35) Can you find out the error in the following code?

class X
{
    void methodX()
    {
        class Y
        {
//            static void methodY() //can't be static
//            {
//
//            }
        }
    }
}

//answer
//Local inner classes can’t have static methods
