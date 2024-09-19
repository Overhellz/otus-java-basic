package com.rodiond26.overhellz.otus.basic;

import com.rodiond26.overhellz.otus.basic.server.Server;
import com.rodiond26.overhellz.otus.basic.service.CalculateService;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8888, new CalculateService()).start();
    }
}
