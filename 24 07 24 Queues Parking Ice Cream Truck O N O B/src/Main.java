import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
class IceCreamTruck{
    public static int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
        int[] result = new int[n - B + 1];
        if(B > n){
            int maxElement = Integer.MIN_VALUE;
            for(int num : A){
                if(num > maxElement){maxElement = num;}
            }
            return new int[]{maxElement};
        }
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < B; i++){
            while(!deque.isEmpty() && A[deque.peekLast()] <= A[i]){deque.removeLast();}
            deque.addLast(i);
        }
        result[0] = A[deque.peekFirst()];

        for(int i = B; i< n; i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i -B){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && A[deque.peekLast()] <= A[i]){deque.removeLast();}
            deque.addLast(i);
            result[i - B + 1] = A[deque.peekFirst()];
        }
        return result;


    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of sections: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.print("Enter the number of potential customers in each section : ");
        for(int i = 0; i< n; i++){
            A[i] = sc.nextInt();
        }
        System.out.println("Enter the number of consecutive sections: ");
        int B = sc.nextInt();

        int[] result = slidingMaximum(A, B);
        System.out.print("The busiest stretch of section is: ");
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}