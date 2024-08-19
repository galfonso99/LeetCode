const testing = @import("std").testing;
const std = @import("std");

pub fn main() !void {
    solve();
}

const String =  [] const u8;


fn solve(nums: []i32, target: i32) ![2]usize {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const alloc = gpa.allocator();
    var map = std.AutoHashMap(i32, usize).init(alloc);
    defer map.deinit();
    var result: [2]usize = undefined;
    for (nums, 0..) |num, i| {
        try map.put(target - num, i); 
    }
    for (nums, 0..) |num, i| {
        if ( map.contains(num) and map.get(num) != i ) {
            result = .{i, map.get(num).?};
            break;
        }
    }
    return result;

}

test "1" {
    var nums = [_]i32{3,4,5,6};
    const target = 7;
    const result = solve(&nums, target);
    try testing.expectEqual([2]usize{0,1}, result);
}

test "2" {
    var nums = [_]i32{4,5,6};
    const target = 10;
    const result = solve(&nums, target);
    try testing.expectEqual([2]usize{0,2}, result);

}

