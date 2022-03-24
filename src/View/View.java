package View;

import Model.Model;
import observer.Observable;
import observer.Observer;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class View implements Observer {

    private JFrame frame;
    private JLabel celsusLabel;
    private JLabel kelvinLabel;
    private JTextField celsusTextfield;
    private JTextField kelvinTextfield;
    private JButton celsusSave;
    private JButton kelvinSave;
    private JButton dernierConv;
    private JButton close;
    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create UI elements
        celsusLabel = new JLabel("T en Celsus :");
        kelvinLabel = new JLabel("T en kelvin :");
        celsusTextfield = new JTextField();
        kelvinTextfield = new JTextField();
        celsusSave = new JButton("Valider");
        kelvinSave = new JButton("Valider");
        dernierConv = new JButton("Infos!");
        close = new JButton("Quitter!");
        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(celsusLabel)
                        .addComponent(kelvinLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(celsusTextfield)
                        .addComponent(kelvinTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(celsusSave)
                        .addComponent(kelvinSave))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(dernierConv)
                        .addComponent(close)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(celsusLabel)
                        .addComponent(celsusTextfield).addComponent(celsusSave).addComponent(dernierConv))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(kelvinLabel)
                        .addComponent(kelvinTextfield).addComponent(kelvinSave).addComponent(close)));
        layout.linkSize(SwingConstants.HORIZONTAL, celsusSave, kelvinSave);
        layout.linkSize(SwingConstants.HORIZONTAL, dernierConv, close);
        frame.getContentPane().setLayout(layout);
    }
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JLabel getCelsusLabel() {
        return celsusLabel;
    }
    public void setCelsusLabel(JLabel celsusLabel) {
        this.celsusLabel = celsusLabel;
    }
    public JLabel getKelvinLabel() {
        return kelvinLabel;
    }
    public void setKelvinLabel(JLabel kelvinLabel) {
        this.kelvinLabel = kelvinLabel;
    }
    public JTextField getCelsusTextfield() {
        return celsusTextfield;
    }
    public void setCelsusTextfield(JTextField celsusTextfield) {
        this.celsusTextfield = celsusTextfield;
    }
    public JTextField getKelvinTextfield() {
        return kelvinTextfield;
    }
    public void setKelvinTextfield(JTextField kelvinTextfield) {
        this.kelvinTextfield = kelvinTextfield;
    }
    public JButton getCelsusSave() {
        return celsusSave;
    }
    public void setCelsusSave(JButton celsusSave) {
        this.celsusSave = celsusSave;
    }
    public JButton getKelvinSave() {
        return kelvinSave;
    }
    public void setKelvinSave(JButton kelvinSave) {
        this.kelvinSave = kelvinSave;
    }
    public JButton getDernierConv() {
        return dernierConv;
    }
    public void setDernierConv(JButton dernierConv) {
        this.dernierConv = dernierConv;
    }
    public JButton getClose() {
        return close;
    }
    public void setClose(JButton close) {
        this.close = close;
    }

    @Override
    public void update(Observable observable) {

        Model model = (Model)observable;
        JTextField celsusbi= getCelsusTextfield();
        model.setCelsus(Integer.parseInt(celsusbi.getText()));
        JTextField kelvinbi= getKelvinTextfield();
        model.setKelvin(Integer.parseInt(kelvinbi.getText()));

    }
}