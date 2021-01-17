package Udemy.Section3;

public class PrimitiveTypesChallenge {

    public static void main(String[] args) {
        byte byteValue = 123;
        short shortValue = 12345;
        int intValue = 12345678;
        long longValue = 50_000L + 10 * (byteValue + shortValue + intValue);
        System.out.println(longValue);

        short shortTotal = (short) (5000L + 10 * (byteValue + shortValue + intValue));
    }
}
