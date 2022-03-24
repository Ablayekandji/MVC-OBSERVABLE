package observer;

public interface Observable {
    public void addobserver(Observer obs);
    public void remove(Observer obs);
    public void notifyObs();

}
