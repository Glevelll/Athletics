import java.util.Random;

public class High_jump extends Form implements Dicqualification{
    private static int Disq = 1;
    public High_jump() {
        this.name = "Прыжки в высоту";
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



