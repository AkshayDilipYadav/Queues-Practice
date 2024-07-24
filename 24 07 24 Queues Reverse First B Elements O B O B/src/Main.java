import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class ReverseFirstBElements{
    public static int[] reverseFirstBElements(int[] A, int B){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< B; i++){
            queue.offer(A[i]);
        }
        for(int i = B - 1; i >= 0; i--){
            A[i] = queue.poll();
        }
        return A;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i< n; i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();

        int[] result = reverseFirstBElements(A, B);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

}