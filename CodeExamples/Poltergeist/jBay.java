/**
 * Created by tkrieger on 28.07.2016.
 */
public class jBay {
    public static void main(String[] args) {
        Auktionshaus jbay = new Auktionshaus();

        // here the poltergeist is created
        AuktionsCreator creator = new AuktionsCreator();
        // then several times used to create an nen Auktion Object...
        jbay.addAuktion(creator.createHourAuktion("Turnschuhe", "Tolle Turnschuhe, kaum getragen"));
        jbay.addAuktion(creator.createDayAuktion("iPad", "Nagelneues iPad 3"));
        jbay.addAuktion(creator.createWeekAuktion("Currywurst", "Scharf ohne Pommes"));
        jbay.addAuktion(creator.createMonthAuktion("Wasser", "1L Schurwald - Quelle"));
        // ... which is completely unnecessary - it would be easier to calculate the time directly here

        BieterTerminal bt = new BieterTerminal(new Bieter("Donald", "Duck"), jbay);
        BieterTerminal bt2 = new BieterTerminal(new Bieter("Micky", "Maus"), jbay);
    }
}
