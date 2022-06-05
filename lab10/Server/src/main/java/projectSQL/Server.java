package projectSQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 *
 The Server class is a SingleTon class because this class will have only one instance.
 In ArrayLIst name I will remember the names of the users who logged in.
 In ArrayList messages I will store all messages given by clients
 In ArrayList friends I will store friendships between clients.

 */

public class Server {

    private final int port = 3456;
    private List<String> name = new ArrayList<>();
    private List<String> messages = new ArrayList<>();
    private  ServerSocket serverSocket;
    private List<String> friends = new ArrayList<>();

    private Server() throws IOException {}

    public static Server getServerInstance() throws IOException {
        return new Server();
    }

    /**
     * This method starts the server, connects to clients, and responds to commands sent by clients
     * Accepts any client trying to connect
     * Close an inactive client after 60 seconds
     * Create a new Thread for each cilent
     * Server can respond to commands :
     * login , Allows a client to log in
     *register, Allows a client to register
     * exit, remove a client from the server
     * send send a message to all the users from the friend list
     * friend add a person to the friend list
     * read see all the messages received
     * stop stop the server
     * @throws IOException
     */

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(port);

        System.out.println("Server started...");
        System.out.println("Wating for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client!");
            clientSocket.setSoTimeout(60000);

            Thread t = new Thread() {
                public void run() {
                    try (
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        boolean logat = false;
                        String nume = null;
                        while (in.hasNextLine()) {
                            String input = in.nextLine();
                            if (input.equalsIgnoreCase("exit")) {
                                System.out.println("Client disconnected!");
                                break;
                            }
                            else
                            if(input.equalsIgnoreCase("stop"))
                            {
                                System.out.println("Server inchis!");
                                serverSocket.close();
                                break;
                            }
                            else
                            if(input.equalsIgnoreCase("register"))
                            {
                                out.println("Nume : ");
                                input = in.nextLine();
                                if(!name.contains(input))
                                {
                                    name.add(input);
                                    out.println(input + " a fost inregistrat, acum foloseste login!");
                                }
                                else
                                {
                                    out.println("Numele este deja inregistrat!");
                                }
                            }
                            else
                            if(input.equalsIgnoreCase("login"))
                            {
                                out.println("Nume : ");
                                input = in.nextLine();
                                if(name.contains(input))
                                {
                                    out.println("Bine ai venit " + input);
                                    logat = true;
                                    nume = input;
                                    friends.add(nume);

                                }
                                else out.println("Numele nu este inregistrat!");
                            }
                            else
                            if(logat)
                            {
                                if(input.equalsIgnoreCase("read"))
                                {
                                    StringBuilder output = new StringBuilder();
                                    for (String s : messages) {
                                        if(friends.contains(s.substring(0,s.indexOf(":")-1)))
                                        {
                                            output.append(s).append(", ");
                                        }
                                    }
                                    out.println(output);
                                }
                                else
                                if(input.equalsIgnoreCase("friend"))
                                {
                                    out.println("Nume : ");
                                    input = in.nextLine();
                                    if(name.contains(input))
                                    {
                                        friends.add(input);
                                        out.println("Prieten adaugat");
                                    }
                                    else
                                    {
                                        out.println("Persoana nu e inregistrata!");
                                    }
                                }
                                else if(input.equalsIgnoreCase("send"))
                                {
                                    out.println("Text : ");
                                    input = in.nextLine();
                                    messages.add(nume + " : " + input);
                                    out.println("Mesaj trimis!");
                                }
                                else out.println("Comanda incorecta!");
                            }
                            else
                            {
                                out.println("Nu sunteti logat!");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();

        }
    }


}
