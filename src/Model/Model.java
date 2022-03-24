package Model;

import observer.Observable;
import observer.Observer;

import java.util.ArrayList;

public class Model implements Observable {
    public ArrayList<Observer> observers = new ArrayList();
    private int celsus;
    private int kelvin;
    public Model(int celsus, int kelvin) {
        this.celsus = celsus;
        this.kelvin = kelvin;
    }
    public Integer getCelsus() {
        return celsus;
    }
    public void setCelsus(Integer celsus) {
        this.celsus = celsus;

    }
    public Integer getKelvin() {
        return kelvin;
    }
    public void setKelvin(Integer kelvin) {
        this.kelvin = kelvin;
    }

    @Override
    public void addobserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void remove(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObs() {
        for (Observer observer:this.observers) {
            observer.update(this);
        }
    }
}

