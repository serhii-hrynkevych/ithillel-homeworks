package serhii.hrynkevych;

public class Troll extends Character {

    public Troll() {
//        setWeapon(new AxeBehavior());
    }

    @Override
    public void fight() {
        System.out.print("Ход тролля - ");
        super.fight();
    }
}
