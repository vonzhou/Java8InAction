package lambdasinaction.chap14;

import java.util.function.Function;

public class Combinators {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x + 2;
        System.out.println(compose(g, f).apply(3));
        System.out.println("--------------");
        System.out.println(repeat(3, (Integer x) -> 2 * x).apply(10));
    }

    static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return x -> g.apply(f.apply(x));
    }

    static <A> Function<A, A> repeat(int n, Function<A, A> f) {
        return n == 0 ? x -> x : compose(f, repeat(n - 1, f));
    }
}
