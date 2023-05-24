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
    let mut stack = {
        let root = root.as_ref().unwrap().borrow();
        vec![(root.left.take(), root.right.take())] 
    };
    while let Some(opts) = stack.pop() {
        match opts {
            (Some(p), Some(q)) => {
                let (p, q) = (p.borrow(), q.borrow());
                if p.val == q.val {
                    stack.push((p.right.take(), q.left.take()));
                    stack.push((p.left.take(), q.right.take()));
                } else {
                    return false;
                }
            },
            (None, None) => (),
            _ => return false,
        }
    }
    true
}
// @lc code=end

