import java.util.Arrays;
import java.util.Random;

public class myADT {

    public int[] arrADT;

    private void init(int[] a) {
        //O(n)
        for (int i = 0; i < a.length; i++)
            if (a[i] <= 100 && a[i] >= -100)
                arrADT[a[i] + 100]++;
        //[-5,5]
        // a--> {-5,-4,0,1,2,2}
        //myADT--> [1,1,0,0,0,1,1,2,0,0,0]
        //myADT--> [6,5,4,4,4,4,3,2,0,0,0]
        //O(1)
        for (int j = arrADT.length - 2; j >= 0; j--)
            arrADT[j] += arrADT[j + 1];
    }

    public myADT(int[] a) {
        this.arrADT = new int[201];
        init(a);
    }

    public int howManyMore(int k) {
        if (k < -100 || k > 100)
            return Integer.MAX_VALUE;
        return arrADT[k + 100];
    }

    void merge(myADT other) {
        for (int i = 0; i < arrADT.length; i++) {
            arrADT[i] += other.arrADT[i];
        }
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] a = new int[15];
        for (int i = 0; i < 15; i++) {
            a[i] = rd.nextInt(201) - 100;
        }
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
        myADT myADT = new myADT(a);
        System.out.println(Arrays.toString(myADT.arrADT));
        System.out.println("Before");
        System.out.println("How many More -5 = " + myADT.howManyMore(-5));
        int[] b = {-5, -7, -4};
        myADT myADT2 = new myADT(b);
        myADT.merge(myADT2);
        System.out.println("After");
        System.out.println("How many More -5 = " + myADT.howManyMore(-5));
    }

}
