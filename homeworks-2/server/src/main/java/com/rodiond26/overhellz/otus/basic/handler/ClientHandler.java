package com.rodiond26.overhellz.otus.basic.handler;

import com.rodiond26.overhellz.otus.basic.server.Server;
import lombok.Getter;
import lombok.Setter;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private final Server server;
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    @Getter
    @Setter
    private String username;

    public ClientHandler(Server server, Socket clientSocket) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        this.in = new DataInputStream(this.clientSocket.getInputStream());
        this.out = new DataOutputStream(this.clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("<Клиент подключился>");
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.startsWith("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                    }
                }

                //цикл работы
                while (true) {
                    String serverMessage = in.readUTF();
                    if (serverMessage.startsWith("/")) {
                        if (serverMessage.startsWith("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }

                    } else {
                        server.broadcast(username + " : " + serverMessage);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String clientMessage) {
        try {
            out.writeUTF(clientMessage);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        close(out);
        close(in);
        close(clientSocket);
        System.out.println("<Отключение>");
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
