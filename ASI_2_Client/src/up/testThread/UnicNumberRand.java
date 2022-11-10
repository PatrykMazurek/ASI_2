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
//        return randNumber();
        return randNumberSync();
    }

    private int randNumberSync(){
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);
        int number;

        synchronized (this){
            boolean find = false;
            while (true){
                number = rand.nextInt(300);
                if (!Main.unicNumber.contains(number)){
                    find = true;
                }
                //                for(int i = 0; i<200; i++){
//                    if (Main.tabInt[i] == number) { find = true;}
//                }
                if(find){
                    System.out.println("Zapisanie wartości " + number +
                            " do " + nrThread + " tablicy " );
                    Main.tabInt[nrThread] = number;
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return number;
    }

    private synchronized int randNumber(){
        Random rand = new Random();
        System.out.println("Rozpoczęcie pracy " + nrThread);
        int number;
        boolean find = false;
        while (true){
            number = rand.nextInt(500);
            for(int i = 0; i<200; i++){
                if (Main.tabInt[i] == number) { find = true;}
            }
            if(!find){
                Main.tabInt[nrThread] = number;
                break;
            }
        }
        return number;
    }
}
