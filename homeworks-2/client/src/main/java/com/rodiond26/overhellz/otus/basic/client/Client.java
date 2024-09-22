package com.rodiond26.overhellz.otus.basic.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
            System.out.println("<Подключение к серверу>");
            while (true) {
                String serverStartMessage = in.readUTF();
                System.out.print(serverStartMessage);

                System.out.print("> ");
                String userExpression = scanner.nextLine();
                if (userExpression.trim().equalsIgnoreCase("<exit>")) {
                    break;
                }
                out.writeUTF(userExpression);

                String serverResultMessage = in.readUTF();
                System.out.println("> Результат: " + serverResultMessage);
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            System.out.println("<Отключение>");
        }
    }
}
