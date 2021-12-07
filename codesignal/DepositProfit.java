package codesignal;

public class DepositProfit {
    public static void main(String[] args) {
        System.out.println(new DepositProfit().depositProfit(100, 20, 170));
    }
    int depositProfit(int deposit, int rate, int threshold) {
        return (int)Math.ceil(Math.log10(threshold / (double)deposit) / Math.log10(1 + (rate / 100.0)));
    }
}
