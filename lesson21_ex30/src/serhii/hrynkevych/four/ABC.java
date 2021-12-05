package serhii.hrynkevych.four;
//4) How do you access field ‘i’ of class ‘XYZ’ in the below example?


public class ABC
{
    public class XYZ
    {
        int i = 111;

        public int getI() {
            return i;
        }
    }
}

//answer:
//ABC abc = new ABC();
//    ABC.XYZ xyz = abc.new XYZ();
//    int i = xyz.getI();
//    System.out.println(i);
//
//    new ABC().new XYZ().getI();
