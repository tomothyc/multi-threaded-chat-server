// A Java program for a Server
// Modification of the following:
// https://www.geeksforgeeks.org/socket-programming-in-java/
import java.net.*;
import java.io.*;
  
public class Server
{

  private Socket socket = null;
  private ServerSocket server = null;
  private DataInputStream in = null;

  public Server(int port)
  {
    try {
      server = new ServerSocket(port);
      System.out.println("Server started");

      socket = server.accept();
      System.out.println("Client found");

      in = new DataInputStream(new BufferedInputeStream(socket.getInputStream()));

      String line = "";

      while (!line.equals("Over")){
        try {
          line = in.readUTF();
          System.out.println(line);
        }
        catch(IOException i){
          System.out.println(i);
        }
      }
      
      //closing
      System.out.println("Closing");

      socket.close();
      in.close();
    }
    catch(IOException i){
    System.out.println(i);
    }
  }

  public static void main(String args[]){
    Server server = new Server(5000);
  }
}