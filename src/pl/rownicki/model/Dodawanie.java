package pl.rownicki.model;

public class Dodawanie implements Operacja {
    @Override
    public double oblicz(double x, double y) {
        return x+y;
    }
}
