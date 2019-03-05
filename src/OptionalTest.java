import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println("a是不空的：" + a.isPresent());
        System.out.println("b是不空的：" + b.isPresent());

        System.out.println(b.orElse(getDefaultValue()));
        System.out.println(a.orElse(getDefaultValue()));
        System.out.println(b.orElseGet(() -> getDefaultValue()));
        System.out.println(a.orElseGet(() -> getDefaultValue()));

        Optional.ofNullable(value2).orElseThrow(IllegalArgumentException::new);

        String lowerString = "hello";
        String upperString = Optional.of(lowerString).map(String::toUpperCase).get();
        System.out.println(upperString);
    }

    public static Integer getDefaultValue() {
        return new Integer(0);
    }
}
