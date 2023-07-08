package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> lastname = new ArrayList<>();
        ArrayList<String> secondname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> sex = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию -> ");
            name.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            lastname.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            secondname.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            sex.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(sex.size() - 1);
            System.out.println("Продолжить ввод да/нет? -> ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }

        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " " + lastname.get(i).toUpperCase().charAt(0) + "." + secondname.get(i).toUpperCase().charAt(0) + ". " + age.get(i) + " " + (sex.get(i) ? "Ж" : "М"));
        }

        System.out.println("Сортировать по возрасту да/нет? -> ");
        String tmp = scanner.nextLine();
        if (tmp.toLowerCase().equals("да")) {
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return age.get(o1) - age.get(o2);
                }
            });
            for (int i = 0; i < name.size(); i++) {
                System.out.println(name.get(id.get(i)) + " " + lastname.get(id.get(i)).toUpperCase().charAt(0) + "." + secondname.get(id.get(i)).toUpperCase().charAt(0) + ". " + age.get(id.get(i)) + " " + (sex.get(id.get(i)) ? "Ж" : "М"));
            }
        }

        System.out.println("Сортировать по возрасту и полу да/нет? -> ");
        String temp = scanner.nextLine();
        if (temp.toLowerCase().equals("да")) {
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return sex.get(o1).compareTo(sex.get(o2));
                }
            }.thenComparing(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return age.get(o1) - age.get(o2);
                }
            }));
            for (int i = 0; i < name.size(); i++) {
                System.out.println(name.get(id.get(i)) + " " + lastname.get(id.get(i)).toUpperCase().charAt(0) + "." + secondname.get(id.get(i)).toUpperCase().charAt(0) + ". " + age.get(id.get(i)) + " " + (sex.get(id.get(i)) ? "Ж" : "М"));
            }
        }









    }
}