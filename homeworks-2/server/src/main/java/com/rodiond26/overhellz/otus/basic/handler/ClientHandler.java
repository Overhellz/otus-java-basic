package com.rodiond26.overhellz.otus.basic.handler;

import com.rodiond26.overhellz.otus.basic.server.Server;
import lombok.Getter;
import lombok.Setter;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

@Getter
public class ClientHandler {

    private final Server server;
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    @Setter
    private String username;

    public ClientHandler(Server server, Socket clientSocket) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                int clientPort = clientSocket.getPort();
                System.out.println("Подключился клиент. Порт: " + clientPort);

                // цикл аутентификации
                while (true) {
                    String clientMessage = in.readUTF();

                    if (clientMessage.startsWith("/")) {
                        if (clientMessage.startsWith("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }

                        // /auth login password
                        if (clientMessage.startsWith("/auth ")) {
                            String[] cmd = clientMessage.split("\\s+");
                            if (cmd.length != 3) {
                                sendMessage("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticationProvider().authenticate(this, cmd[1], cmd[2])) {
                                break;
                            }
                            continue;
                        }

                        // /reg login password username
                        if (clientMessage.startsWith("/reg ")) {
                            String[] cmd = clientMessage.split(" ");
                            if (cmd.length != 4) {
                                sendMessage("Неверный формат команды /reg");
                                continue;
                            }
                            if (server.getAuthenticationProvider().register(this, cmd[1], cmd[2], cmd[3])) {
                                break;
                            }
                            continue;
                        }
                    }
                    sendMessage("Перед работой необходимо пройти аутентификацию командой " +
                            "/auth login password или регистрацию командой /reg login password username");
                }

                //цикл работы
                while (true) {
                    String clientMessage = in.readUTF();
                    // /w username message
                    if (clientMessage.startsWith("/w ")) {
                        String userName = clientMessage.split(" ")[1];
                        String userMessage = clientMessage.split(" ")[2];

                        Optional<ClientHandler> clientHandlerOptional = server.getClientHandlerList().stream()
                                .filter(handler -> handler.getUsername().equalsIgnoreCase(userName))
                                .findFirst();

                        if (clientHandlerOptional.isPresent()) {
                            DataOutputStream userOut = clientHandlerOptional.get().getOut();
                            userOut.writeUTF(this.getUsername() + " : " + userMessage);
                        } else {
                            sendMessage("В чате нет пользователя " + userName);
                        }
                        continue;
                    }

                    if (clientMessage.startsWith("/")) {
                        if (clientMessage.startsWith("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }

                        // пользователи онлайн
                        if (clientMessage.startsWith("/online")) {
                            sendMessage("Пользователи онлайн: " + server.getAuthenticateUserNames());
                        }
                    } else {
                        server.broadcast(username + " : " + clientMessage);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String serverMessage) {
        try {
            out.writeUTF(serverMessage);
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
