package com.rodiond26.overhellz.otus.basic;

import com.rodiond26.overhellz.otus.basic.server.Server;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8888).start();
    }
}
