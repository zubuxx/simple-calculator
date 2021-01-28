package pl.rownicki.observer;

public interface Observer {
    void update(String command, boolean isLastOperation);
}
