const testing = @import("std").testing;
const std = @import("std");
const print = @import("std").debug.print;

// Allocator Example

pub fn main() !void {
    solve(.{1,2,3,1});
}

fn solve(nums: []i32) !bool {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    const alloc = gpa.allocator();
    var map = std.AutoHashMap(i32, void).init(alloc);
    const duplicate: bool = for (nums) |num| {
        if (map.contains(num)) {
            break true; 
        }
        try map.put(num, {});
    } else false;

    return duplicate;
}


test "1" {
    var x = [_]i32{1,2,3,1}; 
    const has_duplicate = solve(&x);
    try testing.expectEqual(true, has_duplicate);

}

test "2" {
    var x = [_]i32{1,2,3,4}; 
    const has_duplicate = solve(&x);
    try testing.expectEqual(false, has_duplicate);
}

test "3" {
    var x = [_]i32{1,1,1,3,3,4,3,2,4,2}; 
    const has_duplicate = solve(&x);
    try testing.expectEqual(true, has_duplicate);
}
