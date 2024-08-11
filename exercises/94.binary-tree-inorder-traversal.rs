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
        let mut stack = Vec::new();
        let mut arr = Vec::new();
        let mut node = root;
        while node.is_some() || !stack.is_empty() {
            if node.is_some() {
                while let Some(curr) = node.clone() {
                    stack.push(Some(curr.clone()));
                    let mut curr = curr.borrow_mut();
                    node = curr.left.take();
                }
            }
            if !stack.is_empty() {
                let curr = stack.pop().unwrap().unwrap();
                let mut curr = curr.borrow_mut();
                arr.push(curr.val);
                node = curr.right.take();
            }
       }
       arr
    }
}
// @lc code=end

