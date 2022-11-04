package up.testThread;

import up.Main;

import java.util.Random;
import java.util.concurrent.Callable;

public class UnicNumberRand implements Callable<Integer> {

    private int nrThread;

    public UnicNumberRand(int th){
        this.nrThread = th;
    }

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);

        int id = rand.nextInt(200);
        Main.tabInt[id] = nrThread;

        System.out.println("zakończenie pracy " + nrThread);

        return null;
    }
}
