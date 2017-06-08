import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Created by D065030 on 28.07.2016.
 */
public class Auktion {
    private Ware ware;
    private Gebot gebot;
    private double preis;
    private Calendar end;

    public static final double increment = 1.0;

    public Auktion(Ware ware, int dauer){
        preis = 0.0;
        this.ware = ware;
        this.end = Calendar.getInstance();
        end.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
    }

    public Gebot getGebot() {
        return gebot;
    }

    public double getPreis() {
        return preis;
    }

    public Calendar getEnd() {
        return end;
    }

    public Ware getWare(){
        return this.ware;

    }

    public boolean isActive(){
        return end.after(Calendar.getInstance());
    }

    public boolean gebotAbgeben(Gebot g){
        this.writeLog(g);
        if (end.after(Calendar.getInstance())) {
            double minNeu;
            if (this.gebot == null) {
                this.preis = this.increment;
                this.gebot = g;
                return true;
            }
            minNeu = preis + increment;

            if (g.getMaxBetrag() < minNeu) {
                return false;
            }

            if (this.gebot.getBieter() == g.getBieter()) {
                if (this.gebot.getMaxBetrag() < g.getMaxBetrag()) {
                    this.gebot = g;
                    return true;
                }
                return false;
            }

            if (g.getMaxBetrag() >= minNeu) {
                if (g.getMaxBetrag() > this.gebot.getMaxBetrag()) {
                    this.preis = Math.min(this.gebot.getMaxBetrag()+increment, g.getMaxBetrag()); ///????
                    this.gebot = g;
                    return true;
                } else {
                    this.preis = Math.min(g.getMaxBetrag() + increment, this.gebot.getMaxBetrag()); //?????
                }
            }
            return false;
        } else {
            return false;
        }
    }

    private void writeLog(Gebot g){
        try(PrintWriter prw = new PrintWriter(new FileWriter("auktionen.txt"))){
            prw.println("[" + Calendar.getInstance().getTime().toString() + "] Gebot von " + g.getBieter().getFullName()
                    + "für" + this.ware.getTitel() + ": " + g.getMaxBetrag());
        } catch (IOException ex){

        }
    }
}
