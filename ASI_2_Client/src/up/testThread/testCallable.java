package up.testThread;

import up.Main;

import java.util.ArrayList;
import java.util.concurrent.*;

public class testCallable {

    public void startThread(int nubmerThread){

        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor thredPool = (ThreadPoolExecutor) service;
//        ArrayList<Future<Integer>> templist = new ArrayList<>();
        int nubmer = 0;
        while (nubmer <= 200){
            if (thredPool.getActiveCount() <= 0 ){
                UnicNumberRand un = new UnicNumberRand(nubmer);
                try {
//                    templist.add(service.submit( un ));
                    service.submit(un);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nubmer++;
            }
        }

        showTable();
    }

    public void showTable(){
        for (int i = 0; i<200; i++){
            if ((i/10) == 0){
                System.out.println(Main.tabInt[i]);
//                System.out.print();
            }else{
                System.out.print(Main.tabInt[i] + " ");
            }
        }
    }
}
