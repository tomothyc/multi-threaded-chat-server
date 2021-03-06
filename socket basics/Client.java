// A Java program for a Client
// Modification of the following:
// https://www.geeksforgeeks.org/socket-programming-in-java/

import java.net.*;
import java.io.*;
  
public class Client
{
  private Socket socket            = null;
  private BufferedReader  input   = null;
  private DataOutputStream out     = null;

  //constructor
  public Client(String address, int port){
    try
    {
      socket = new Socket(address, port);
      System.out.println("Connected");

      input = new BufferedReader(new InputStreamReader(System.in));

      out = new DataOutputStream(socket.getOutputStream());
    }

    catch(UnknownHostException u){
      System.out.println(u);
    }

    catch(IOException i){
      System.out.println(i);
    }

    String line = "";
    

    while (!line.equals("Over")){
      try{
        line = input.readLine();
        out.writeUTF(line);
      }
      catch(IOException i){
        System.out.println(i);
      }
    }

    //closing
    try{
      input.close();
      out.close();
      socket.close();

    }

    catch(IOException i){
      System.out.println(i);
    }
  }
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }
  }