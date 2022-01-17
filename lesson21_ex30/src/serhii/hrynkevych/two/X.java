package serhii.hrynkevych.two;
//What will be the output of the following program?

class X
{
    static int x = 3131;

    static class Y
    {
        static int y = x++;

        static class Z
        {
            static int z = y++;
        }
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(X.x); //3131

        System.out.println(X.Y.y); //3131

        System.out.println(X.Y.Z.z); //3131
    }
}