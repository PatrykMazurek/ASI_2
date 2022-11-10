package up;

import up.testThread.StartTikTAK;
import up.testThread.TestRunnable;
import up.testThread.TikTak;
import up.testThread.testCallable;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] tabInt;
    public static List<Integer> unicNumber;

    public static void main(String[] args) {
	// write your code here
        unicNumber = new ArrayList<>();

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
//        testCallable tc = new testCallable();
//        tc.startThread(5);
//        System.out.println("Zakończenie wątka głównego");

        TikTak tikTak = new TikTak();

        StartTikTAK t1 = new StartTikTAK("tik", tikTak);
        StartTikTAK t2 = new StartTikTAK("tak", tikTak);

//        Thread tik = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 6; i++){
//                    tikTak.tik(true);
//                }
//                tikTak.tik(false);
//            }
//        });
//        tik.start();
//
//        Thread tak = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 6; i++){
//                    tikTak.tak(true);
//                }
//                tikTak.tak(false);
//            }
//        });
//
//        tak.start();


    }
}
