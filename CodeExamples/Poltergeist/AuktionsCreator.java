/**
 * Created by tkrieger on 08.06.2017.
 */

/**
 * this is our POLTERGEIST - completely stateless and unnecessary
 * it only calculates the time and returning the Auktion Object.
 * So not very obvious for any programmer...
  */

public class AuktionsCreator {
    public Auktion createHourAuktion(String titel, String beschreibung ){
        Ware w = new Ware(titel, beschreibung);
        return new Auktion(w, 60);
    }

    public Auktion createDayAuktion(String titel, String beschreibung ){
        Ware w = new Ware(titel, beschreibung);
        return new Auktion(w, 60*24);
    }

    public Auktion createWeekAuktion(String titel, String beschreibung ){
        Ware w = new Ware(titel, beschreibung);
        return new Auktion(w, 60*24*7);
    }

    public Auktion createMonthAuktion(String titel, String beschreibung ){
        Ware w = new Ware(titel, beschreibung);
        return new Auktion(w, 60*24*7*30);
    }
}
