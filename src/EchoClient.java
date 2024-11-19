import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        String sh = "localhost";
        int port = 6969;
        Scanner sc = new Scanner(System.in);

        try {
            Socket s = new Socket(sh, port);
            System.out.println("connesso al server");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            //da usare al posto dello scanner
            BufferedReader ui = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(in.readLine());
            out.println(ui.readLine());
            System.out.println(in.readLine());
            out.println(ui.readLine());
            System.out.println(in.readLine());
            out.println(ui.readLine());
            System.out.println(in.readLine());



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
