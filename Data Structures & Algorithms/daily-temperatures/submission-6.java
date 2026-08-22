class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int size = temperatures.length;

        int[] results = new int[size];

        for (int i = size - 1; i > 0; i--) {
            if (temperatures[i-1] < temperatures[i]) {
                results[i-1] = 1;
            } else {
                int val = results[i];

                if (val == 0) continue;

                while (val + i <= size - 1){

                    if (temperatures[i-1] < temperatures[val + i]) {
                        results[i-1] = val + 1;
                        break;
                    }

                     if (results[i+val] == 0) break;

                    val += results[i+val];
                    
                }
            }
        }

        return results;

    }
}
