/*
 * @lc app=leetcode id=108 lang=rust
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn sorted_array_to_bst(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        let len = nums.len();
        let root = Rc::new(RefCell::new(TreeNode::new(nums[(len-1)/2])));
        let mut stack = vec![(0, len-1, Rc::clone(&root))];
        
        while let Some((start, end, node)) = stack.pop() {
            let center = start + (end - start) / 2;
            if start < center {
                let mid = start + (center - 1 - start) / 2;
                let new_node = Rc::new(RefCell::new(TreeNode::new(nums[mid])));
                stack.push((start, center-1, Rc::clone(&new_node)));
                node.as_ref().borrow_mut().left = Some(new_node);
            }
            if end > center {
                let mid = center + 1 + (end - center - 1) / 2;
                let new_node = Rc::new(RefCell::new(TreeNode::new(nums[mid])));
                stack.push((center+1, end, Rc::clone(&new_node)));
                node.as_ref().borrow_mut().right = Some(new_node);
            }
        }
        Some(root)
    }
}
// @lc code=end

// pub fn build_bst (nums: &[i32]) -> Option<Rc<RefCell<TreeNode>>>{
//     match nums.len() {
//         0 => None,
//         1 => Some(Rc::new(RefCell::new(TreeNode::new(nums[0])))),
//         n => { let mid = n / 2; 
//             let left_side = &nums[..mid];
//             let right_side = &nums[mid+1..];
//             Some(Rc::new(RefCell::new(TreeNode {val: nums[mid], left: build_bst(left_side), right: build_bst(right_side)})))
//         }
//     }
// }

// At each iteration you take the middle value, put it in the right spot, then take the values before and the values after and pass both of the into their each recursion call