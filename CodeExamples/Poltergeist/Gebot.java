/**
 * Created by tkrieger on 28.07.2016.
 */
public class Gebot {
    private double maxBetrag;
    private Bieter bieter;

    public Gebot(double maxBetrag, Bieter bieter) {
        this.maxBetrag = maxBetrag;
        this.bieter = bieter;
    }

    public double getMaxBetrag() {
        return maxBetrag;
    }

    public Bieter getBieter() {
        return bieter;
    }

}
