import javax.swing.*;

/**
 * Created by tkrieger on 28.07.2016.
 */
public class AuktionsButton extends JButton {
    private Auktion auktion;

    public AuktionsButton(Auktion auktion) {
        super("Gebot");
        this.auktion = auktion;
    }

    public Auktion getAuktion() {
        return auktion;
    }

    public void setAuktion(Auktion auktion) {
        this.auktion = auktion;
    }
}
