import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaAndStream {
    public static void main(String[] args) {

        int[] array = {5, 4, 6, 7, 8, 12, 5, 4, 6, 8, 3, 1, 2, 0, 5};
        List<Integer> bigToSmall = Arrays.stream(array).mapToObj(x -> x).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("从大到小排列：" + bigToSmall);

        List<Integer> smallToBig = Arrays.stream(array).sorted().boxed().collect(Collectors.toList());
        System.out.println("从小到大排列：" + smallToBig);

        List<Integer> noRepeatedList = smallToBig.stream().distinct().collect(Collectors.toList());
        System.out.println("去除集合内的重复元素：" + noRepeatedList);

        List<Integer> list = Stream.iterate(0, n -> n + 1).limit(10).collect(Collectors.toList());
        System.out.println("生成一个0到9的自然数集合list：" + list);

        System.out.println("list中所有元素都大于5：" + list.stream().allMatch(x -> x > 5));
        System.out.println("list中有元素大于5：" + list.stream().anyMatch(x -> x > 5));

        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("list中数字之和为：" + sum);

        Map<Boolean, List<Integer>> numbers = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("list中的偶数集合: " + numbers.get(true));
        System.out.println("list中的奇数集合: " + numbers.get(false));

        List<Integer> doubleList = list.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println("doubleList: " + doubleList);

        int max = doubleList.stream().mapToInt(x -> x).max().getAsInt();
        System.out.println("doubleList的最大值为：" + max);

        int[][] twoDimensionalArr = {{1, 2}, {3, 4}};
        List<Integer> oneDimensionalList = Arrays.stream(twoDimensionalArr)
                .flatMap(arr -> Arrays.stream(arr).boxed())
                .collect(Collectors.toList());
        System.out.println("二维数组转为以为集合：");
        oneDimensionalList.stream().forEach(System.out::println);
    }
}
