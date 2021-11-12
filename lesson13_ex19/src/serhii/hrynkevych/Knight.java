package serhii.hrynkevych;

public class Knight extends Character{

    public Knight() {
//        setWeapon(new BowAndArrowBehavior());
    }

    @Override
    public void fight() {
        System.out.print("Ход рыцаря - ");
        super.fight();
    }
}
