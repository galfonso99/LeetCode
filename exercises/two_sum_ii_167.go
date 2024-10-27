package main

// import "fmt"

func twoSum(n []int, t int) []int {
    l, r := 0, len(n) - 1
    for {
        if n[l] + n[r] > t {
            r--
        } else if n[l] + n[r] < t {
            l++
        } else {
            return []int{l+1, r+1}
        }
    }
}

/* Nahhh What was bro cooking, bro burned down the kitchen */

// func twoSum(nums []int, target int) []int {
//     fmt.Printf("Length: %d\n", len(nums))
//     leftMiddle := (len(nums) - 1) / 2
//     rightMiddle := (len(nums)) / 2
//     fmt.Printf("Left M: %d\n", leftMiddle)
//     fmt.Printf("Right M: %d\n", rightMiddle)
//     initialRange := [2]int{0, len(nums) - 1}
//     result := binarySearch(nums, leftMiddle, initialRange, rightMiddle, initialRange, target)
//     return result[:]
//
// }

// func binarySearch(nums []int, left int, leftRange [2]int, right int, rightRange [2]int, target int) [2]int {
//     if left != right && nums[left] + nums[right] == target {
//         return [2]int{left+1, right+1}
//     }
//     if left == right  {
//         right += 1
//     }
//     var result [2]int
//     fmt.Printf("Left: %d\n", left)
//     fmt.Printf("Right: %d\n", right)
//     if tooHigh(nums, left, right, target) {
//         leftRange[1] = left
//         // fmt.Printf("Left range changed %d - %d\n", leftRange[0], leftRange[1])
//         leftMiddle := leftRange[0] + ((leftRange[1] - leftRange[0]) / 2)
//         if left != leftRange[0] {
//             result = binarySearch(nums, leftMiddle, leftRange, right, rightRange, target);
//         } else {
//             rightRange[1] = right
//             // fmt.Printf("Right range changed %d - %d\n", rightRange[0], rightRange[1])
//             rightMiddle := rightRange[0] + ((rightRange[1] - rightRange[0] + 1) / 2)
//             result = binarySearch(nums, left, leftRange, rightMiddle, rightRange, target);
//         }
//     } else if tooLow(nums, left, right, target) {
//         rightRange[0] = right
//         // fmt.Printf("Right range changed %d - %d\n", rightRange[0], rightRange[1])
//         rightMiddle := rightRange[0] + ((rightRange[1] - rightRange[0] + 1) / 2)
//         if right != rightRange[1] {
//             result = binarySearch(nums, left, leftRange, rightMiddle, rightRange, target);
//         } else {
//             leftRange[0] = left
//             // fmt.Printf("Left range changed %d - %d\n", leftRange[0], leftRange[1])
//             leftMiddle := leftRange[0] + ((leftRange[1] - leftRange[0]) / 2)
//             result = binarySearch(nums, leftMiddle, leftRange, right, rightRange, target);
//         }
//     }
//
//     return result
// }
//
//
// func tooLow(nums []int, i int, j int, target int) bool {
//     return (nums[i] + nums[j]) < target
// }
//
// func tooHigh(nums []int, i int, j int, target int) bool {
//     return (nums[i] + nums[j]) > target
// }
