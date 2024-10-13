package com.rodiond26.overhellz.otus.basic.lesson27.lection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("lection27_1.txt")) {
            byte[] buffer = fileInputStream.readAllBytes();
            String data = new String(buffer, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("lection27_2.txt")) {
            for (char ch : "hello world".toCharArray()) {
                fileOutputStream.write(ch);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
