package up;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Client c = new Client("localhost", 5501);
//        c.connect();
//        c.sendMessage();
//        c.disconnect();
        FileClient fc = new FileClient("localhost", 5501, "pliki\\");
        fc.connect();
        fc.sendFileToServer();
        fc.getFileFromServer();
        fc.disconnect();
    }
}
