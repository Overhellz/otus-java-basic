package com.rodiond26.overhellz.otus.basic.lesson19.lection;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Lection19 {

    public static void main(String[] args) {
//        readByByte();
//        readByByteArray();
//        readByBufferInputStream();
//        readByInputStreamReader();
        decoratorExample();
    }

    public static void readByByte() {
        try (FileInputStream in = new FileInputStream("lection19.demo.txt")) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read(); // нельзя так делать, потому что читаем по 1 байту при каждом обращении к ОС
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByByteArray() {
        try (FileInputStream in = new FileInputStream("lection19.demo.txt")) {
            byte[] buf = new byte[64];

            int n = in.read(buf); // n - количество байт, которое прочитано

            while (n > 0) {
                System.out.print(new String(buf, 0, n));
                n = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByBufferInputStream() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("lection19.demo.txt"))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read(); // сначала файл читается по 8кб из ОС в буфер, а потом отдает из буфера по 1 байту без учета кодировки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByInputStreamReader() {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("lection19.demo.txt"))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read(); // читаем файл по 1 символу с учетом кодировки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decoratorExample() {
        try (InputStreamReader in =
                     new InputStreamReader(
                             new BufferedInputStream(
                                     new FileInputStream("lection19.demo.txt")
                             )
                     )
        ) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read(); // читаем файл по 1 символу с учетом кодировки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    File file = new File("1/a.txt");
//        System.out.println(file.exists());
//        System.out.println(file.length());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getParentFile().getAbsolutePath());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.isAbsolute());
//        System.out.println(file.isHidden());

//        if (file.isDirectory()) {
////            System.out.println(Arrays.toString(file.list()));
////            System.out.println(Arrays.toString(file.listFiles()));
//            for (File f : file.listFiles()) {
//                System.out.println(f.getName());
//            }
//        } else {
//            System.out.println("Не папка");
//        }

//        file.renameTo(new File("1/a.txt"));

//        File dir = new File("1/2/3/4");
////        System.out.println(dir.mkdir());
//        System.out.println(dir.mkdirs());

//        System.out.println(file.getFreeSpace());
//        System.out.println(file.getTotalSpace());
//        System.out.println(file.getUsableSpace());

    public void exampleBufferedOutputStream() {
        String data = "Hello World Привет мир!";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out1.txt"))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleWriteArrayBytes() {
        String data = "Hello World Привет мир!";
        try (FileOutputStream out = new FileOutputStream("out1.txt", false)) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleWriteBytes() {
        String data = "Hello World Привет мир!";
        try (FileOutputStream out = new FileOutputStream("out1.txt", false)) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleInputStreamReader() {
        try (InputStreamReader in = new InputStreamReader(
                new BufferedInputStream(
                        new FileInputStream("demo.txt")))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleReadBuffer() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("demo.txt"))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleReadArrayBytes() {
        try (FileInputStream in = new FileInputStream("demo.txt")) {
            byte[] buf = new byte[64];
            int n = in.read(buf);
            while (n > 0) {
                System.out.print(new String(buf, 0, n));
                n = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exampleReadBytes() {
        try (FileInputStream in = new FileInputStream("demo.txt")) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
