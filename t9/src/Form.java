import java.util.Random;

public abstract class Form {
    Random rnd = new Random();
    protected String name;
    protected double res;
    protected int disqual;

    public String getName() {
        return name;
    }

    protected double finalRes(double re){
        return this.res + re;
    }



}
