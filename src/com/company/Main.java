package com.company;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DependencyManager dependencyManager = new DependencyManager();
        Menu.menu(dependencyManager);
    }
}
