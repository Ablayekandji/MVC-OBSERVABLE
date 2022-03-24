package Controller;

import Model.Model;
import View.View;
import observer.Observable;
import observer.Observer;

import javax.swing.*;

public class Controller implements Observer {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        initView();
    }
    public void initView() {
        view.getCelsusTextfield().setText(String.valueOf(model.getCelsus()));
        view.getKelvinTextfield().setText(String.valueOf(model.getKelvin()));
    }
    public void initController() {
        view.getCelsusSave().addActionListener(e -> saveCelsus());
        view.getKelvinSave().addActionListener(e -> saveKelvin());
        view.getDernierConv().addActionListener(e -> inf());
        view.getClose().addActionListener(e -> quiter());
    }
    private void saveCelsus() {
        model.notifyObs();
        JOptionPane.showMessageDialog(null, "Conversion avec succes T en Kelvin : " + (model.getCelsus()+273), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    private void saveKelvin() {

        //model.setKelvin(Integer.parseInt(view.getKelvinTextfield().getText()));
        model.notifyObs();
        JOptionPane.showMessageDialog(null, "Conversion avec succes T en Celsus : " + (model.getKelvin()-273), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    private void inf() {

        JOptionPane.showMessageDialog(null, "Dernier conversion: T en C =" + (model.getCelsus()+273)+ " et T en k =" + (model.getKelvin()-273) +" .", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    private void quiter() {
        System.exit(0);
    }

    @Override
    public void update(Observable observable) {
        Model model = (Model)observable;
        JTextField celsusbi= view.getCelsusTextfield();
        model.setCelsus(Integer.parseInt(celsusbi.getText()));
        JTextField kelvinbi= view.getKelvinTextfield();
        model.setKelvin(Integer.parseInt(kelvinbi.getText()));
    }
}
