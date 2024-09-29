public class max_water_container_11 {
    
}
 
// Original Solution
class Solution_11 {
    public int maxArea(int[] h) {
        int max = 0;
        int l = 0, r = h.length - 1;
        while (l < r) {
            if (h[l] < h[r]) {
                max = Math.max(max, h[l] * (r - l));
                l += 1;
            } else if (h[l] > h[r]) {
                max = Math.max(max, h[r] * (r - l));
                r -= 1;
            } else {
                max = Math.max(max, h[l] * (r - l));
                l += 1;
                r -= 1;
            }
        }
        return max;
    }
}
// More efficent solution using similar logic but skips iterations that are proven to be lesser than max
// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length -1;
//         int max = 0;

//         while(left < right){
//             int minH = Math.min(height[left], height[right]);
//             int area = (right - left) * minH;
//             max = Math.max(max, area);
            
//             while(left < right && height[left] <= minH){
//                 left++;
//             }
//             while(left < right && height[right] <= minH){
//                 right--;
//             }
//         }
//         return max;
//     }
// }