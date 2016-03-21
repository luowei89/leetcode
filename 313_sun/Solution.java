public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0) {
            return -1;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> inHeap = new HashSet<>();
        int[] indexes = new int[primes.length];
        Map<Integer, Integer> num2prime = new HashMap<>();
        for (int i = 0; i < primes.length; i++) {
            num2prime.put(primes[i], i);
            minHeap.add(primes[i]);
            inHeap.add(primes[i]);
        }
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = minHeap.poll();
            int primeI = num2prime.get(uglyNums[i]);
            indexes[primeI]++;
            int newNum = uglyNums[indexes[primeI]] * primes[primeI];
            while (inHeap.contains(newNum)) {
                indexes[primeI]++;
                newNum = uglyNums[indexes[primeI]] * primes[primeI];
            }
            inHeap.add(newNum);
            minHeap.add(newNum);
            num2prime.put(newNum, primeI);
        }
        return uglyNums[n-1];
    }
}
