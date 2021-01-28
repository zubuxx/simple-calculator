package pl.rownicki.model;

public class Procent implements Operacja {
    @Override
    public double oblicz(double x, double y) {
        return x*0.01*y;
    }
}
