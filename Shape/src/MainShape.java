import java.util.ArrayList;

class MainShape {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        Rectangle rectangle1 = new Rectangle(20, 30);
        shapes.add(rectangle1);

        Rectangle rectangle2 = new Rectangle(20, 30);
        shapes.add(rectangle2);

        Circle circle1 = new Circle(15);
        shapes.add(circle1);

        Circle circle2 = new Circle(30);
        shapes.add(circle2);

        Square square1 = new Square(10);
        shapes.add(square1);

        Square square2 = new Square(50);
        shapes.add(square2);

        Triangle triangle1 = new Triangle(5, 7, 9, 11, 2, 4);
        shapes.add(triangle1);

        Triangle triangle2 = new Triangle(1, 3, 5, 7, 9, 11);
        shapes.add(triangle2);

        System.out.printf("Фигура с максимальной площадью.%n%s%n%n", findMaxArea(shapes).toString());
        System.out.printf("Фигура с вторым по величине периметром.%n%s%n%n", findSecondMaxPerimeter(shapes).toString());

        System.out.printf("rectangle1 == rectangle2 ? %b%n", rectangle1.equals(rectangle2));
        System.out.printf("circle1 == circle2 ? %b%n", circle1.equals(circle2));
        System.out.printf("square1 == square2 ? %b%n", square1.equals(square2));
        System.out.printf("triangle1 == triangle2 ? %b", triangle1.equals(triangle2));
    }

    private static Shape findMaxArea(ArrayList<Shape> shapes) {
        AreaComparator areaComparator = new AreaComparator();
        shapes.sort(areaComparator);

        return shapes.get(shapes.size() - 1);
    }

    private static Shape findSecondMaxPerimeter(ArrayList<Shape> shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        shapes.sort(perimeterComparator);

        return shapes.get(shapes.size() - 2);
    }
}