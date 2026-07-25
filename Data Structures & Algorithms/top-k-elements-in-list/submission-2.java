class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countOccurance = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (countOccurance.containsKey(nums[i])) {
                countOccurance.put(nums[i] , countOccurance.get(nums[i]) + 1);

            } else {
                countOccurance.put(nums[i], 1);
            }

        }

        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(countOccurance.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = entries.get(i).getKey();

        return res;
    }
}
