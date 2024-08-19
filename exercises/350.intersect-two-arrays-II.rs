pub fn intersect(mut nums1: Vec<i32>, mut nums2: Vec<i32>) -> Vec<i32> {
    if nums1 > nums2 {
        std::mem::swap(&mut nums1, &mut nums2);
    }
    let mut count = [0; 1001];
    let mut vec = vec![];
    for ele in nums2 {
        count[ele as usize] += 1;
    }
    for ele in nums1 {
        if count[ele as usize] > 0 {
            vec.push(ele);
            count[ele as usize] -= 1;
        }
    }
    vec
}

