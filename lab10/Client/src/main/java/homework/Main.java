package homework;

import java.io.IOException;

/**
 *
 In the main method I will create a client object that I will instantiate with a host and server port
 */

public class Main {
    public static void main(String[] args) throws IOException {

        Client client = new Client("127.0.0.1",3456);
        client.startCilent();

    }

}