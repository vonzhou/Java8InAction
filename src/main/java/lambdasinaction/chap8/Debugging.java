package lambdasinaction.chap8;

import java.util.*;

public class Debugging {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }

    private static void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
    }

    private static int divideByZero(int integer) {
        return integer / 0;
    }

    private static class Point {
        private int x;
        private int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
