/**
 * Created by tkrieger on 28.07.2016.
 */
public class Ware {
    private String titel;
    private String beschreibung;

    public Ware(String titel, String beschreibung){
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getTitel() {
        return titel;
    }
}
