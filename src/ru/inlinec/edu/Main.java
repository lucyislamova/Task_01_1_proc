package ru.inlinec.edu;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static float sideA;
    static float sideB;
    static float sideC;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            sideA = readSideLen("a");
            sideB = readSideLen("b");
            sideC = readSideLen("c");

            checkTriangle();

            printHeights();
        } catch (IllegalAccessException exc) {
            System.out.println(exc.getMessage());
        }
    }
    private static float readSideLen( String sideName ){
        System.out.printf("Сторона %s: ", sideName);
        return  scanner.nextFloat();
    }

    public static void checkTriangle() throws IllegalAccessException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalAccessException("Введите корректные данные: стороны треугольника должны быть больше 0");
        }
        if (sideA > (sideB + sideC) || sideB > (sideB + sideC) || sideC > (sideA + sideB)){

            throw new IllegalAccessException("Введите корректные данные: сторона треугольника не может быть больше суммы 2х других сторон");
        }
    }
    private static float getHeight(float side){
        float semiP = (sideA + sideB + sideC)/2; //полупериметр
        return 2/side * (float)Math.sqrt((semiP - sideA) * (semiP - sideB) * (semiP - sideC));
    }

    public static void printHeights(){
        System.out.printf("Высота стороны A = %.3f\n", getHeight(sideA));
        System.out.printf("Высота стороны B = %.3f\n", getHeight(sideB));
        System.out.printf("Высота стороны C = %.3f\n", getHeight(sideC));
    }

}