import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class PerfectNumberGenerator{
    public static String findAthPerfectNumber(int A){
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");

        String current = "";
        for(int i =0; i < A; i++){
            current = queue.poll();
            queue.offer(current + "1");
            queue.offer(current + "2");

        }
        StringBuilder sb = new StringBuilder(current);
        return current + sb.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println(findAthPerfectNumber(A));
    }
}