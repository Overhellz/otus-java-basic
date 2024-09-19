package com.rodiond26.overhellz.otus.basic.server;

import com.rodiond26.overhellz.otus.basic.service.CalculateService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.rodiond26.overhellz.otus.basic.service.ServerMessage.START_MESSAGE;

public class Server {

    private int port;
    private DataInputStream in;
    private DataOutputStream out;
    private CalculateService calculateService;

    public Server(int port, CalculateService calculateService) {
        this.port = port;
        this.calculateService = calculateService;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Порт: " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Подключился клиент c порта: " + clientSocket.getPort());

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                out.writeUTF(START_MESSAGE);
                String clientMessage = in.readUTF();
                System.out.println(">>>>> " + clientMessage);

                double result = calculateService.calculateExpressionOrThrow(clientMessage);
                System.out.println(">>>>> result: " + result);
                out.writeUTF(String.valueOf(result));
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
