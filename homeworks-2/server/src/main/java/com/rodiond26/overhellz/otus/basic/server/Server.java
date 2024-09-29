package com.rodiond26.overhellz.otus.basic.server;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;
import com.rodiond26.overhellz.otus.basic.provider.AuthenticationProvider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final int port;
    private final List<ClientHandler> clients;
    private final AuthenticationProvider authenticationProvider;

    public Server(int port, AuthenticationProvider authenticationProvider) {
        this.port = port;
        this.clients = new ArrayList<>();
        this.authenticationProvider = authenticationProvider;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Порт: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключился клиент. Порт: " + clientSocket.getPort());
                new ClientHandler(this, clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void broadcast(String serverMessage) {
        clients.forEach(clientHandler -> clientHandler.sendMessage(serverMessage));
    }
}
