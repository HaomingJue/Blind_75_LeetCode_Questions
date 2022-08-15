package dynamic_programming;

public class CoinChange_DPTopDown {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount] != 0) return count[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0) {
                minCount = Math.min(minCount, res + 1);
            }
        }
        count[amount] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return count[amount];
    }
}
