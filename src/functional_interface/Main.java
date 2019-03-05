package functional_interface;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        System.out.println(addition.operation(2, 3));

        Function<Integer, Integer> square = i -> i * i;
        Function<Integer, Integer> multiple = i -> i * 3;
        System.out.println(square.compose(multiple).apply(1));
        System.out.println(square.andThen(multiple).apply(1));
    }
}
