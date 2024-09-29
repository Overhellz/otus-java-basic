package com.rodiond26.overhellz.otus.basic.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

@RequiredArgsConstructor
@Getter
public class Client {

    private final String host;
    private final int port;

    public void start() {
        try (Socket socket = new Socket(host, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);
        ) {
            new Thread(() -> {
                try {
                    System.out.println("<Подключение к серверу>");
                    while (true) {
                        String serverMessage = in.readUTF();
                        if (serverMessage.startsWith("/")) {
                            if (serverMessage.startsWith("/exitok")) {
                                break;
                            }
                        } else {
                            System.out.println(serverMessage);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка ввода-вывода: " + e.getMessage());
                } finally {
                    close(scanner);
                    close(out);
                    close(in);
                    close(socket);
                    System.out.println("<Отключение>");
                }
            }).start();

            while (true) {
                String clientMessage = scanner.nextLine();
                out.writeUTF(clientMessage);
                if (clientMessage.startsWith("/exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            System.out.println("<Отключение>");
        }
    }

    private void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
