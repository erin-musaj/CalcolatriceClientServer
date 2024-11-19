import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        int[] num = new int[2];
        String op;

        try {
            //Mette il server in ascolto
            ServerSocket ss = new ServerSocket(6969);
            System.out.println("server in ascolto");

            //Accetta la connessione del client
            Socket cs = ss.accept();

            System.out.println("Conesso a " + cs.getInetAddress());

            //crea il buffer per ricevere i dati
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            //crea il buffer per inviare dati
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            out.println("operando 1:");
            num[0]= Integer.parseInt(in.readLine());
            out.println("operando 2:");
            num[1]= Integer.parseInt(in.readLine());
            out.println("operatore:");
            op = in.readLine();

            switch (op) {
                case "+":
                    out.println("Risultato: " + (num[0] + num[1]));
                    break;
                case "-":
                    System.out.println("Risultato: " + (num[0] - num[1]));
                    break;
                case "*":
                    System.out.println("Risultato: " + (num[0] * num[1]));
                    break;
                case "/":
                    if (num[2] != 0) {
                        System.out.println("Risultato: " + (num[0] / num[1]));
                    } else {
                        System.out.println("Errore: Divisione per zero non consentita.");
                    }
                    break;
                default:
                    System.out.println("Operatore non valido.");
                    break;
            }

            in.close();
            out.close();
            cs.close();
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}