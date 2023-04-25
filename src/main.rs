struct Solution;
fn main() {}

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

use std::cell::RefCell;
use std::rc::Rc;
pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
    let mut arr: Vec<i32> = Vec::new();
    let node_unwrap = root.unwrap();
    let mut node = node_unwrap.borrow_mut();
    is_sym(node.left.take(), node.right.take())
}


/* 
pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
    let mut arr: Vec<i32> = Vec::new();
    let node_unwrap = root.unwrap();
    let mut node = node_unwrap.borrow_mut();
    is_sym(node.left.take(), node.right.take())
}

pub fn is_sym(left: Option<Rc<RefCell<TreeNode>>>, right: Option<Rc<RefCell<TreeNode>>>) -> bool {
    let (left, right) = (left.unwrap(), right.unwrap());
    let (mut left, mut right) = (left.borrow_mut(), right.borrow_mut());
    if left.val != right.val {
        return false;
    }
    is_sym(left.left.take(), right.right.take())
        && is_sym(left.right.take(), right.left.take())
    
}
 */