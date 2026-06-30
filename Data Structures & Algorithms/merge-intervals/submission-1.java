class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                res.add(currentInterval);
                currentInterval = interval;
            }
        }
        res.add(currentInterval);

        int[][] array = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }

        return array;
    }
}
