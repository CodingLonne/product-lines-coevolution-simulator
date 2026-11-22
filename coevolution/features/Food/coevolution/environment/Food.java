package coevolution.environment;

public class Food extends Entity {
    private final double energy;

    public Food(World world, double x, double y, double energy) {
        super(world, x, y, 4);
        this.energy = energy;
    }

    public double getEnergy() { return energy; }
}