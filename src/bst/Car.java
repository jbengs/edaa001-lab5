package bst;

public class Car {
    private int reg;

    public Car(int reg) {
        this.reg = reg;
    }

    public int getReg() {
        return reg;
    }

    @Override
    public String toString() {
        return "" + reg;
    }
}
