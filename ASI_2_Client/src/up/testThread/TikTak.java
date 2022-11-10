package up.testThread;

public class TikTak {

    public synchronized void tik(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("wyświetlam tik");
        notify();
        System.out.println("tik zwalnia wątki");
        try{
            System.out.println(" tik czeka");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void tak(boolean work){
        if(!work){
            notify();
            return;
        }
        System.out.println("wyświetlam tak");
        notify();
        System.out.println("tak zwalnia wątki");
        try{
            System.out.println(" tak czeka");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
