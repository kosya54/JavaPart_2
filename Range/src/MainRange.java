import java.util.Scanner;

public class MainRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало первого интервала: ");
        double fromA;
        if (scanner.hasNextDouble()) {
            fromA = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        System.out.println("Введите конец первого интервала: ");
        double toA;
        if (scanner.hasNextDouble()) {
            toA = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        Range rangeA = new Range(fromA, toA);

        System.out.println("Введите начало второго интервала: ");
        double fromB;
        if (scanner.hasNextDouble()) {
            fromB = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        System.out.println("Введите конец второго интервала: ");
        double toB;
        if (scanner.hasNextDouble()) {
            toB = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        Range rangeB = new Range(fromB, toB);

        System.out.printf("Интревал 1: {%.1f : %.1f}, длина интервала = %.0f.%n", rangeA.getFrom(), rangeA.getTo(), rangeA.getLength());
        System.out.printf("Интервал 2: {%.1f : %.1f}, длина интервала = %.0f.%n", rangeB.getFrom(), rangeB.getTo(), rangeB.getLength());

        Range rangeC = rangeA.getIntersection(rangeB);

        if (rangeC == null) {
            System.out.println("Интервалы не пересекаются.");
        } else {
            System.out.printf("Интервал пересечения: {%.1f : %.1f}, длина интервала = %.0f.%n", rangeC.getFrom(), rangeC.getTo(), rangeC.getLength());
        }

        Range[] rangeArray = rangeA.getUnion(rangeB);

        if (rangeArray.length > 1) {
            System.out.printf("Объединение интервалов равно: {%.1f : %.1f}, {%.1f : %.1f}", rangeArray[0].getFrom(), rangeArray[0].getTo(), rangeArray[1].getFrom(), rangeArray[1].getTo());
        } else {
            System.out.printf("Объединение интервалов равно: {%.1f : %.1f}", rangeArray[0].getFrom(), rangeArray[0].getTo());
        }
    }
}