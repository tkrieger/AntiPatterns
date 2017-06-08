import java.util.ArrayList;
import java.util.List;

/**
 * Created by tkrieger on 28.07.2016.
 */
public class Auktionshaus {
    private List<Auktion> auktionen;
    private List<BieterTerminal> bts;

    public Auktionshaus(){
        auktionen = new ArrayList<>();
        bts = new ArrayList<>();
    }

    public void addAuktion(Auktion a){
        this.auktionen.add(a);
        updateTerminals();
    }

    public void removeAuktion(Auktion a){
        this.auktionen.remove(a);
        updateTerminals();
    }

    public List<Auktion> getAuktionen(){
        boolean sendMessage = false;
        for (int i = 0; i < auktionen.size(); i++){
            Auktion a = auktionen.get(i);
            if(!a.isActive()){
                auktionen.remove(a);
                sendMessage = true;
            }
        }
        if(sendMessage){
            updateTerminals();
        }
        return auktionen;
    }

    public void register(BieterTerminal bt){
        bts.add(bt);
    }

    public void unregister(BieterTerminal bt){
        bts.remove(bt);
    }

    public void updateTerminals(){
        for (BieterTerminal b : bts) {
            b.updateTerminal();
        }
    }


}
