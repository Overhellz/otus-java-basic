package com.rodiond26.overhellz.otus.basic.lesson20.lection.client;

import java.io.*;
import java.net.Socket;

public class PingClient implements AutoCloseable {

    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public PingClient(Socket socketm) throws IOException {
        this.inputStream = new DataInputStream(new BufferedInputStream(socketm.getInputStream()));
        this.outputStream = new DataOutputStream(new BufferedOutputStream(socketm.getOutputStream()));
    }

    public void send(byte[] bytes) throws IOException {
        outputStream.write(bytes);
        outputStream.flush();
    }

    public String read() throws IOException {
        String result = inputStream.readUTF();
        return result;
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
