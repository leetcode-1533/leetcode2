public class Solution {
    public String minWindow(String s, String t) {
        int bestl = s.length() + 1;
        String re = "";

        while (t == null || t.length() == 0 || s == null || s.length() == 0) {
            return re;
        }

        int[] occ = new int[256];
        for (int i = 0; i < t.length(); i++) {
            occ[t.charAt(i)]++;
        }

        for (int i = 0, j = 0; j < s.length(); j++) {
            occ[s.charAt(j)]--;

            while (below0(occ)) {
                if (j - i + 1 < bestl) {
                    bestl = j - i + 1;
                    re = s.substring(i, j + 1);
                }

                occ[s.charAt(i)]++;
                i++;
            }
        }
        return re;
    }

    private boolean below0(int[] keyset) {
        for (int item : keyset) {
            if (item > 0)
                return false;
        }
        return true;
    }
}