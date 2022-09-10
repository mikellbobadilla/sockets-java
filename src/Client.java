import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    Socket client = null;
    Scanner k = new Scanner(System.in);
    DataInputStream in = null;
    DataOutputStream out = null;
    final int PORT = 8000;
    final String HOST = "localhost";

    try {
      client = new Socket(HOST,PORT);
      out = new DataOutputStream(client.getOutputStream());

      while(true){
        print("Write a message: ");
        String mess = k.nextLine();
        out.writeUTF(mess);
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void print(String message){
    System.out.println(message);
  }
}
