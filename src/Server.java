import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

  public static void main(String[] args) {
    final int PORT = 8000;
    DataOutputStream out = null;
    DataInputStream in = null;

    ServerSocket serverSocket = null;
    Socket client = null;

    try {
      serverSocket = new ServerSocket(PORT);
      print(String.format("Server listening on port %s: ", PORT));

      while(true){
        client = serverSocket.accept();
        in = new DataInputStream(client.getInputStream());

        print(String.format("The client was connected on port %s ", client.getPort()));
        print("Waiting for messages: ");
        String mess = in.readUTF();
        print(String.format("%s : %s", client.getPort(), mess));
        if(mess.equals("quit")){
          client.close();
          print(String.format("The client %s was disconnected.", client.getPort()));
          break;
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void print(String message){
    System.out.println(message);
  }
}
