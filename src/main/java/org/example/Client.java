package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (Socket server = new Socket("192.168.1.95", 9876)) {
            OutputStream serverOut = server.getOutputStream();
            Writer serverWriter = new OutputStreamWriter(serverOut);
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine();
                serverWriter.write(line + "\n");
                serverWriter.flush();
            }
        }
    }
}
