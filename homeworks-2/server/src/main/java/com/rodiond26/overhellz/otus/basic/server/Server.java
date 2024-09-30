package com.rodiond26.overhellz.otus.basic.server;

import com.rodiond26.overhellz.otus.basic.handler.ClientHandler;
import com.rodiond26.overhellz.otus.basic.provider.AuthenticationProvider;
import lombok.Getter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Server {

    private final int port;
    private final List<ClientHandler> clientHandlerList;
    private final AuthenticationProvider authenticationProvider;

    public Server(int port, AuthenticationProvider authenticationProvider) {
        this.port = port;
        this.clientHandlerList = new ArrayList<>();
        this.authenticationProvider = authenticationProvider;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Порт: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(this, clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clientHandlerList.add(clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clientHandlerList.remove(clientHandler);
    }

    public synchronized void broadcast(String serverMessage) {
        clientHandlerList.forEach(clientHandler -> clientHandler.sendMessage(serverMessage));
    }

    public synchronized boolean isConnected(String userName) {
        return clientHandlerList.stream().anyMatch(clientHandler -> clientHandler.getUsername().equals(userName));
    }

    public synchronized String getAuthenticateUserNames() {
        return clientHandlerList.stream()
                .map(ClientHandler::getUsername)
                .filter(Objects::nonNull)
                .filter(str -> !str.isBlank())
                .toList()
                .toString();
    }
}
