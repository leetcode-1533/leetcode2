/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int li = 0;
      int hi = n;
      while (li <= hi) {
        int mid = li + (hi - li) / 2;
        if (isBadVersion(mid)) {
          hi = mid - 1;
        } else {
          li = mid + 1;
        }
      }
      return li;
    }
}
