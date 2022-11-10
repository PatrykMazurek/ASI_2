package up.testThread;

import up.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class testCallable {

    public void startThread(int nubmerThread){

        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor thredPool = (ThreadPoolExecutor) service;
        ArrayList<Future<Integer>> templist = new ArrayList<>();
        int nubmer = 0;
        while (nubmer <= 200){
            if (thredPool.getActiveCount() <= nubmerThread ){
                try {
                    UnicNumberRand un = new UnicNumberRand(nubmer);
                    templist.add(service.submit(un));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nubmer++;
            }
        }

        for (int i=0; i < 200; i++){
            Future<Integer> f = templist.get(i);
            try {
                int number = f.get(1, TimeUnit.SECONDS);
                System.out.println("Wątek zapisał do " + number + " elemntu tablicy");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();

        showTable();
    }

    public void showTable(){
        for (int i = 0; i<200; i++){
            System.out.print(Main.tabInt[i] + " ");
        }
        System.out.println();
    }
}
