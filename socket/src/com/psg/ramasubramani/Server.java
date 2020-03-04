package com.psg.ramasubramani;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * @author rn5
 *
 */
public class Server {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

		LinkedList<String> messageList = new LinkedList<String>();
		messageList.add("Hello");
		messageList.add("I am good");
		messageList.add("Good night");

		// Creates an unbound server socket. Port Number 6666.
		ServerSocket serverSocket = new ServerSocket(6666);
		boolean stop = false;

		while (!stop) {

			// Listens for a connection to be made to this socket and accepts it.
			// The method blocks until a connection is made. A new Socket is created
			Socket socket = serverSocket.accept();
			
			// Receive Message from client
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

			// Reads text from a character-input stream, buffering characters so as to
			// provide for the
			// efficient reading of characters, arrays, and lines.The buffer size may be
			// specified,
			// or the default size may be used. The default is large enough for most
			// purposes.
			String line = (String) objectInputStream.readObject();
			if (line.equals("Bye"))
				stop = true;
			System.out.println("Message from Client : " + line);

			// Send message to client
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(messageList.removeFirst());
			
			objectOutputStream.close();
			objectInputStream.close();

			if (stop) {
				stop = true;
				socket.close();
				serverSocket.close();
				break;
			}
	        Thread.sleep(1000);
		}
	}

}
