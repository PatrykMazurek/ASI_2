package up.testThread;

import up.Main;

import java.util.Random;

public class UnicNumber implements Runnable{

    private int nrThread;
    public UnicNumber(int nrThread){
        this.nrThread = nrThread;
    }

    @Override
    public void run() {
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);
        for (int i=0; i<20;i++){
            int id = rand.nextInt(200);
            Main.tabInt[id] = nrThread;
        }
        System.out.println("zakończenie pracy " + nrThread);
    }
}
