import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

class SimpleServer {
    public static void main(String[] args) {
        try {
            try (ServerSocket server = new ServerSocket(49152)) {
                Socket client = server.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("Hello, Client!");
                out.println("Good bye!");
                client.close();
            }
        } catch (IOException e) {
            System.out.println("エラーが発生しました: " + e);
        }
    }
}
