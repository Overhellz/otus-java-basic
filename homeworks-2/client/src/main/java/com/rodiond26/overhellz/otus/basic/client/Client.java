package com.rodiond26.overhellz.otus.basic.client;

import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

@RequiredArgsConstructor
public class Client {

    private final String host;
    private final int port;

    public void start() throws IOException {
        Socket socket = new Socket(host, port);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            System.out.println("Успешное подключение к серверу. Порт: " + port);
            try {
                while (true) {
                    String serverMessage = in.readUTF();
                    if (serverMessage.startsWith("/")) {
                        if (serverMessage.startsWith("/exitok")) {
                            break;
                        }
                        if (serverMessage.startsWith("/authok ")) {
                            System.out.println("Аутентификация прошла успешно с именем пользователя: " + serverMessage.split("\\s+")[1]);
                        }
                        if (serverMessage.startsWith("/regok ")) {
                            System.out.println("регистрация прошла успешно с именем пользователя: " + serverMessage.split("\\s+")[1]);
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
                System.out.println("Подключение к серверу завершено");
            }
        }).start();

        while (true) {
            String clientMessage = scanner.nextLine();
            out.writeUTF(clientMessage);
            if (clientMessage.startsWith("/exit")) {
                break;
            }
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
