// Slight improvement over the original
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] canAchieve = new boolean[3]; 
        
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    canAchieve[i] = true;
                }
            }
            if (canAchieve[0] && canAchieve[1] && canAchieve[2]) {
                return true;
            }
        }
        return canAchieve[0] && canAchieve[1] && canAchieve[2];
    }
}

// Original working solution
// class Solution {
//     public boolean mergeTriplets(int[][] triplets, int[] target) {
// 		int[] prev_triplet = new int[3];
//         int[] curr_triplet = new int[3];
//
// 		for (int i = 0; i < triplets.length; i++) {
// 			curr_triplet = triplets[i];
// 			if (curr_triplet[0] > target[0] || curr_triplet[1] > target[1] ||
// 				curr_triplet[2] > target[2]) {
// 				continue;
// 			}
// 			if (curr_triplet[0] == target[0] || curr_triplet[1] == target[1] ||
// 				curr_triplet[2] == target[2]) {
//
// 				curr_triplet[0] = Math.max(prev_triplet[0], curr_triplet[0]);
// 				curr_triplet[1] = Math.max(prev_triplet[1], curr_triplet[1]);
// 				curr_triplet[2] = Math.max(prev_triplet[2], curr_triplet[2]);
// 				prev_triplet = curr_triplet;
// 			}
// 			if (prev_triplet[0] == target[0] && prev_triplet[1] == target[1] &&
// 				prev_triplet[2] == target[2]) {
// 				return true;
// 			}
// 		}
// 		return false;
//     }
// }

// Keep track of the prev triplet
// set prev to 0, 0, 0
// if curr triplet has one of them bigger than target in the 0 1 or 2 position ignore it
// if curr triplet has at least one of the triplet equaling the target then merge with prev
// then set the curr triplet to prev triplet
