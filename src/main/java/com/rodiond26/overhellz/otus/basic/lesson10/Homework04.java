package com.rodiond26.overhellz.otus.basic.lesson10;

import java.time.LocalDate;

public class Homework04 {

    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();
        UserService userService = new UserServiceImpl();

        User[] users = new User[10];
        for (int i = 0; i < users.length; i++) {
            users[i] = userService.createRandomUser();
        }

        for (User user : users) {
            if (currentYear - user.getBirthYear() > 40) {
                System.out.println(user);
            }
        }

        System.out.println("-------");

        String apple = "apple";
        String orange = "orange";

        SimpleBox box = new SimpleBox(100, 200, 300);
        System.out.println(box);

        box.setColor("black");
        box.info();

        box.put(orange);
        box.open();
        box.put(orange);

        box.put(apple);
        box.close();

        box.put(apple);
        box.open();
        box.info();
        box.getThing(apple);
        box.getThing(orange);
        box.put(orange);
        box.close();

        box.open();
        box.getThing(apple);
        box.getThing(orange);
        box.close();
        box.info();
    }
}
