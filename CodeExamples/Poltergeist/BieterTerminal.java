import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

/**
 * Created by tkrieger on 28.07.2016.
 */
public class BieterTerminal {
    private Bieter bieter;
    private Auktionshaus ahaus;
    private JFrame frame;
    private JPanel panel;
    private JLabel timelabel;

    public BieterTerminal(Bieter bieter, Auktionshaus ah){
        this.bieter = bieter;
        this.ahaus = ah;

        //GUI
        frame = new JFrame(bieter.getFullName() + "'s" + "Terminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        timelabel = new JLabel(Calendar.getInstance().getTime().toString());
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true) {
                    timelabel.setText(Calendar.getInstance().getTime().toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }).start();
        frame.add(timelabel, BorderLayout.NORTH);
        panel = new JPanel();
        buildList();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        ahaus.register(this);
    }

    private void buildList(){
        panel.removeAll();
        List<Auktion> auktionen = ahaus.getAuktionen();
        panel.setLayout(new GridLayout(auktionen.size(), 5, 6, 3));
        for(Auktion a : auktionen) {
            panel.add(new JLabel(a.getWare().getTitel()));
            panel.add(new JLabel(Double.toString(a.getPreis())));
            if (a.getGebot() == null) {
                panel.add(new JLabel("---"));
            } else {
                panel.add(new JLabel(a.getGebot().getBieter().getFullName()));
            }
            panel.add(new JLabel(a.getEnd().getTime().toString()));
            AuktionsButton button = new AuktionsButton(a);
            button.setActionCommand(Integer.toString(auktionen.indexOf(a)));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startGebot(a);
                }
            });
            panel.add(button);
        }
        frame.revalidate();
    }

    private void startGebot(Auktion a){
        String input = JOptionPane.showInputDialog("Bitte geben sie ein neues Gebot ein\n Mindestens " + (a.getPreis()+a.increment), a.getPreis()+a.increment);
        if(!proofOfNumber(input)){
            JOptionPane.showMessageDialog(this.frame, "Falsche eingabe!!!");
        } else {
            Gebot g = new Gebot(new Double(input), bieter);
            if (a.gebotAbgeben(g)) {
                JOptionPane.showMessageDialog(this.frame, "Sie sind nun Höchstbietender!!!");
            } else {
                if (a.isActive()) {
                    JOptionPane.showMessageDialog(this.frame, "Gebot zu gering!");
                } else {
                    JOptionPane.showMessageDialog(this.frame, "Auktion leider beendet...");
                }
            }
        }

        ahaus.updateTerminals();
    }


    private boolean proofOfNumber(String inserted){
        if(inserted.isEmpty()){
            return false;
        }
        boolean check = true;
        for(int i = 0; i < inserted.length(); i++){
            char c = inserted.charAt(i);
            if (!((c > 47 && c < 58 ) || c == 46)){
                check = false;
            }
        }
        return check;
    }

    public void updateTerminal(){
        buildList();
    }
}
