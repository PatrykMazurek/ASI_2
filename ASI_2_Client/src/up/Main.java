package up;

import up.DB.DBConnection;
import up.DB.DBOperation;
import up.server.UDPClient;
import up.testThread.StartTikTAK;
import up.testThread.TikTak;

import java.sql.Connection;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static int[] tabInt;
    public static int number;
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


//        TestRunnable tr = new TestRunnable();
//        tr.startThread(10);
//        testCallable tc = new testCallable();
//        tc.startThread(5);
//        System.out.println("Zakończenie wątka głównego");

//        TikTak tikTak = new TikTak();
//        StartTikTAK t1 = new StartTikTAK("Tik", tikTak);
//        StartTikTAK t2 = new StartTikTAK("tak", tikTak);
//        number = 0;
//        try {
//            t1.th.join();
//            t2.th.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Wątek główny kończy pracę");

//        DBConnection c = new DBConnection();
//        Connection connection = c.connectToSQLite();
//        Connection connection = c.connectToMySql();
//        c.createTable();
        // coś rób z bazą danych
//        DBOperation operation = new DBOperation(connection);
//        operation.insertPerson("Patryk", "Mazurek", 33);
//        operation.getAllRecord();
//        Savepoint save = c.getSavePoint();
//        operation.updatePerson(2, "Marek", "Rak");
//        operation.getAllRecord();
//        c.getRollback(save);
//        System.out.println("Przywrócenie poprzedniego punktu");
//        operation.getAllRecord();
//        c.disconnect();

//        UDPClient udpClient = new UDPClient();
//        for (int i = 0; i<15;i++){
//            udpClient.sendMessage(i+"");
//        }
//        udpClient.close();

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
//        tak.start();

        BoardGame bg = new BoardGame();
        List<BoardGame> boardGameList = bg.initListGame();

        Stream<BoardGame> stream = boardGameList.stream();
        Map<Integer, List<BoardGame>> tempList =
                boardGameList.stream()
                .filter(g -> g.name.contains("g"))
                .filter(g -> g.minPlayers > 1)
                .filter(g -> g.price < 50)
                .collect(Collectors.groupingBy(BoardGame::getYear));

//        stream.filter(g -> g.name.contains("g")).forEach(System.out::println);

        bg.changeElements(boardGameList, 2016);
//        bg.findAllElements(boardGameList, 2000);


//        if( boardGameList.stream().anyMatch(g -> g.year == 2008)){
//            System.out.println("istnieje gra z tego roku");
//        }else{
//            System.out.println("nieistnieje gra z tego roku");
//        }



    }
}
