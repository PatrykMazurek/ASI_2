package up;

import up.testThread.TestRunnable;
import up.testThread.testCallable;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static int[] tabInt;

    public static void main(String[] args) {
	// write your code here

        tabInt = new int[200];
        for(int i=0; i<200;i++){
            tabInt[i] = -1;
        }
//        Client c = new Client("localhost", 5501);
//        c.connect();
//        c.sendMessage();
//        c.disconnect();

//        FileClient fc = new FileClient("localhost", 5501, "pliki\\");
//        fc.connect();
//        fc.sendFileToServer();
//        fc.getFileFromServer();
//        fc.disconnect();

//        packageZIP pz = new packageZIP();
//        File[] files = Paths.get("pliki").toFile().listFiles();
////        pz.packageArchive(files, "plik.zip");
//        pz.unpackageArchive(Path.of("pliki_out"), "pliki.zip");

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for( int i = 0; i < 40; i++){
                    System.out.println("wartość " + i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        th.start();
//        try {
//            th.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        TestRunnable tr = new TestRunnable();
//        tr.startThread(10);
        testCallable tc = new testCallable();
        tc.startThread(10);
        System.out.println("Zakończenie wątka głównego");
    }
}
