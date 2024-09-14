package com.rodiond26.overhellz.otus.basic.lesson20.lection.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket clientCccept = serverSocket.accept();
            System.out.println("Client connected!");
            readRequest(clientCccept);
        }
    }

    private static void readRequest(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String str = input.readUTF();
        System.out.println("User input:" + str);
        // todo
        System.out.println("Result:" + str);
        socket.getOutputStream().write(str.getBytes());
        socket.getOutputStream().flush();
    }
}
