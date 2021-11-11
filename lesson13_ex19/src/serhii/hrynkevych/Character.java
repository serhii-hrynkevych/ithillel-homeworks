package serhii.hrynkevych;

public abstract class Character {
    private WeaponBehavior weapon;

    public Character() {
    }

    public void fight() {
        this.weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }

    public abstract void display();

}
