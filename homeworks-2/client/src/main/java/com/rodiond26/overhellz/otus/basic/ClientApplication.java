package com.rodiond26.overhellz.otus.basic;

import com.rodiond26.overhellz.otus.basic.client.Client;

import java.io.IOException;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Запуск клиента");
        new Client("localhost", 8888).start();
    }
}
