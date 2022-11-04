package up.testThread;


import up.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnable {

    public void startThread(int numberThread){
        ExecutorService service = Executors.newFixedThreadPool(numberThread);
        for (int i = 0; i< numberThread; i++){
            service.submit( new UnicNumber(i));
        }
        service.shutdown();
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
