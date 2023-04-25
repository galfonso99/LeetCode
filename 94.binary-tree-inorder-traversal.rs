/*
 * @lc app=leetcode id=94 lang=rust
 *
 * [94] Binary Tree Inorder Traversal
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
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut arr: Vec<i32> = Vec::new();
        let mut node = root;
        Solution::traverse(node, &mut arr);
        arr
    }
    
    pub fn traverse(node: Option<Rc<RefCell<TreeNode>>>, arr: &mut Vec<i32>) {
        if node.is_none() {
            return;
        }
        let mut node = node.unwrap();
        Solution::traverse(node.borrow_mut().left.take(), arr);
        arr.push(node.borrow_mut().val);
        Solution::traverse(node.borrow_mut().right.take(), arr);
    }
}
// @lc code=end

