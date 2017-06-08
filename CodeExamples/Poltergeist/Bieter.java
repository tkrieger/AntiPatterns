/**
 * Created by tkrieger on 28.07.2016.
 */
public class Bieter {
    private String nachname;
    private String vorname;

    public Bieter(String vorname, String nachname){
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public void setVorname(String vor){
        this.vorname = vor;
    }

    public void setNachname(String nach){
        this.nachname = nach;
    }

    public String getFullName(){
        return vorname + " " + nachname;
    }
}
