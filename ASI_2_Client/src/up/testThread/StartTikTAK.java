package up.testThread;

public class StartTikTAK implements Runnable {

    public Thread th;
    TikTak ttObj;

    public StartTikTAK(String name, TikTak tObj){
        th = new Thread(this, name);
        ttObj = tObj;
        th.start();
    }

    @Override
    public void run() {
        if (th.getName().compareTo("Tik") == 0){
            for (int i = 0; i < 6; i++){
                ttObj.tik(true);
            }
            ttObj.tik(false);
        }else{
            for (int i = 0; i < 6; i++){
                ttObj.tak(true);
            }
            ttObj.tak(false);
        }
    }
}
