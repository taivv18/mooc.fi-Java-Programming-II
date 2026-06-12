public class Container {

    private int liquid;

    public Container() {
        this.liquid = 0;
    }

    public int contains() {
        return this.liquid;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }
        this.liquid += amount;
        if (this.liquid >= 100) {
            this.liquid = 100;
        }
    }

    public void remove(int amount) {
        amount = amount > this.liquid ? this.liquid : amount;

        this.liquid -= amount;
        if (this.liquid < 0) {
            this.liquid = 0;
        }
    }

    public String toString() {
        return this.contains() + "/100";
    }
}
