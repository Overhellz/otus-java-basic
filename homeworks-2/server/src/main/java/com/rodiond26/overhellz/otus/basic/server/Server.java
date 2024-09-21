package com.rodiond26.overhellz.otus.basic.server;

import com.rodiond26.overhellz.otus.basic.service.CalculateService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.rodiond26.overhellz.otus.basic.service.ServerMessage.START_MESSAGE;

@RequiredArgsConstructor
@Getter
public class Server {

    private final int port;
    private final CalculateService calculateService;

    private DataInputStream in;
    private DataOutputStream out;

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Порт: " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Подключился клиент. Порт: " + clientSocket.getPort());

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                out.writeUTF(START_MESSAGE);

                String clientExpression = in.readUTF();

                double serverResult = calculateService.calculateExpressionOrThrow(clientExpression);
                out.writeUTF(String.valueOf(serverResult));
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            close(in);
            close(out);
        }
    }

    private <T extends Closeable> void close(T t) {
        try {
            if (t != null) {
                t.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
