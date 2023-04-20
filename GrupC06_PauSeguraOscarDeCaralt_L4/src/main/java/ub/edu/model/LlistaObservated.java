package ub.edu.model;

public interface LlistaObservated {
    public void registerObserver(LlistaObserver o);
    public void removeObserver(LlistaObserver o);
    public void notifyObservers();
}
