/*
 * @lc app=leetcode id=101 lang=rust
 *
 * [101] Symmetric Tree
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
    pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        if root.is_none() {return false;}
        let node_unwrap = root.unwrap();
        let mut node = node_unwrap.borrow_mut();
        is_sym(node.left.take(), node.right.take())
    }
}

pub fn is_sym(left: Option<Rc<RefCell<TreeNode>>>, right: Option<Rc<RefCell<TreeNode>>>) -> bool {
    if left.is_none() && right.is_none() {
        return true;
    }
    if left.is_none() || right.is_none() {
        return false;
    }
    let (left, right) = (left.unwrap(), right.unwrap());
    let (mut left, mut right) = (left.borrow_mut(), right.borrow_mut());
    
    left.val == right.val 
        && is_sym(left.left.take(), right.right.take())
        && is_sym(left.right.take(), right.left.take())
}
// @lc code=end

