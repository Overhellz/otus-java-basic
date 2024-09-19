package com.rodiond26.overhellz.otus.basic.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String hostAddress, int port) throws IOException {
        socket = new Socket(hostAddress, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String serverMessage = in.readUTF();
                if (serverMessage.startsWith("/")) {
                    if (serverMessage.startsWith("/exitok")) {
                        break;
                    }
                } else {
                    System.out.println(serverMessage);
                }
                System.out.println("> ");
                String clientMessage = scanner.nextLine();
                out.writeUTF(clientMessage);
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
