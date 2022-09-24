import java.util.Random;

public class Long_distance extends Form implements Dicqualification{
    private static int Disq = 1;
    public Long_distance() {
        this.name = "Длинные дистанции (5000 м)";
        this.res = 0;
        this.disqual = 0;
    }

    @Override
    public boolean DQ(Random rnd) {
        if (rnd.nextInt(0,100) <= 10) {
            this.disqual += Disq;
            return true;
        } else return false;
    }
}

