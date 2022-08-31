package test.com.bit;

public class HashTest {
    public static void main(String[] args) {
        int hash = 19;
        int i = 15 & hash;
        System.out.println(hash%15);
        System.out.println(i);
    }
}
