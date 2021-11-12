package serhii.hrynkevych;

public class Queen extends Character{

    public Queen() {
//        setWeapon(new KnifeBehavior());
    }

    @Override
    public void fight() {
        System.out.print("Ход короевы - ");
        super.fight();
    }
}
