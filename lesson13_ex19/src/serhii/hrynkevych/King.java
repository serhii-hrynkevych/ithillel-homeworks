package serhii.hrynkevych;

public class King extends Character{

    public King() {
//        setWeapon(new SwordBehavior());
    }

    @Override
    public void fight() {
        System.out.print("Ход короля - ");
        super.fight();
    }
}
