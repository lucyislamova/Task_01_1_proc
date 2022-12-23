package ru.inlinec.edu;

import java.util.Scanner;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        float sideA = readSideLen("a");
        float sideB = readSideLen("b");
        float sideC = readSideLen("c");

        checkTriangle(sideA, sideB, sideC);

        float heightA = getHeight(sideA, sideA, sideB, sideC);
        float heightB = getHeight(sideB, sideA, sideB, sideC);
        float heightC = getHeight(sideC, sideA, sideB, sideC);

        System.out.println("Высоты сторон треугольника:");
        printHeight("A", heightA);
        printHeight("B", heightB);
        printHeight("C", heightC);
    }

    private static float readSideLen(String sideName) {
        System.out.printf("Сторона %s: ", sideName);
        float side = scanner.nextFloat();
        if (side <= 0)
            throw new IllegalArgumentException("Введите корректные данные: сторона треугольника должна быть больше 0");
        return side;
    }

    private static void checkTriangle(float sideA, float sideB, float sideC) {
        if (sideA > (sideB + sideC) || sideB > (sideB + sideC) || sideC > (sideA + sideB)) {
            throw new IllegalArgumentException("Введите корректные данные: сторона треугольника не может быть больше суммы 2х других сторон");
        }
    }

    private static void printHeight(String side, float height) {
        System.out.printf("%s = %.3f\n", side, height);
    }

    private static float getHeight(float sideCurrent, float sideA, float sideB, float sideC) {
        float semiP = (sideA + sideB + sideC) / 2;
        return 2 / sideCurrent * (float) Math.sqrt((semiP - sideA) * (semiP - sideB) * (semiP - sideC));
    }

}