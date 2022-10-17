package up;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Client c = new Client("localhost", 5501);
//        c.connect();
//        c.sendMessage();
//        c.disconnect();

//        FileClient fc = new FileClient("localhost", 5501, "pliki\\");
//        fc.connect();
//        fc.sendFileToServer();
//        fc.getFileFromServer();
//        fc.disconnect();

        packageZIP pz = new packageZIP();
        File[] files = Paths.get("pliki").toFile().listFiles();
//        pz.packageArchive(files, "plik.zip");
        pz.unpackageArchive(Path.of("pliki_out"), "plik.zip");

    }
}
