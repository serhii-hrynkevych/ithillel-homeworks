package serhii.hrynkevych.fifteen;
//15) What will be the output of the following program?

class P
{
    String s = "PPP";

    {
        System.out.println(s);
    }

    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";

            {
                System.out.println(s);
            }
        }

        return new Q().s+s;
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        P p = new P();

        System.out.println(p.methodP());
    }
}

//answer
//PPP
//PPPQQQ
//PPPQQQPPP
