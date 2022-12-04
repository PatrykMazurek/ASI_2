package up;

import up.server.UDPServer;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Server s = new Server(5501);
//        s.serverConnection();
        // uruchominei aplikacji serwerowej do przekazywania plików
//        FileServer fs = new FileServer(5501);
//        fs.serverConnection();

        UDPServer udpServer = new UDPServer();
        udpServer.udpConnect();
    }
}
