// Working with streams in java (declarative approch)
// filter, map, reduce, parallelism
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        // Arrays
        int[] arr = {1,3,5,7,9,11};
        int sum = Arrays.stream(arr).sum(); // average(), 
        System.out.println(sum);
        
        List<Integer> li = Arrays.asList(1,2,3,4,5);
        Stream<Integer> st = li.stream(); 
        // System.out.println(st);
        
        // Stream
        Stream<Integer> str = Stream.of(1,2,3);
        
        Stream<Integer> st1 = Stream.iterate(0, n-> n+1).limit(100);// seed==start, unary opr
        
        Stream<Integer> st2 = Stream.generate(() -> (int) Math.random()).limit(20);
        
        // Operations
        
        // filter
        Stream<Integer> stwe = li.stream().filter(x-> x%2==0);
        // filter even
        List<Integer> l1 = li.stream().filter(x-> x%2==0).collect(Collectors.toList());
        System.out.println(l1);
        
        // map
        List<Integer> l2 = li.stream().map(x-> 2*x).collect(Collectors.toList());
        System.out.println(l2);
        
        // sorted()
        List<Integer> l3 = li.stream().map(x-> 2*x)
            .sorted((a,b) -> b-a)
            .collect(Collectors.toList());
        System.out.println(l3);
        
        // limit()
        List<Integer> l4 = li.stream().map(x-> 2*x)
            .sorted((a,b) -> b-a)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(l4);
        
        // skip()
        List<Integer> l5 = li.stream().map(x-> 2*x)
            .sorted((a,b) -> b-a)
            .limit(3)
            .skip(1)
            .collect(Collectors.toList());
        System.out.println(l5);
        
        // peek()
        List<Integer> l50 = li.stream().map(x-> 2*x)
            .sorted((a,b) -> b-a)
            .limit(3)
            .peek(x-> System.out.println(x))
            .collect(Collectors.toList());
        System.out.println(l50);
        
        ///  terminal operations
        // collect()
        // distinct() 
        // max(lambda).get() , adjust lambda for min
        // count(), eg. distinct().count
        
        //parallelStream()
        // to be used for very large inputs for efficient results
    }
}