package homework;

import java.io.IOException;

/**
 *
 In the main method I will instantiate a Server object and then I will call the startServer method
 */

public class Main {

    public static void main(String[] args) throws IOException {
           Server server = Server.getServerInstance();
           server.startServer();

    }
}