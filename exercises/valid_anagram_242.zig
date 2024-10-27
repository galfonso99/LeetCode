
const testing = @import("std").testing;
const std = @import("std");

pub fn main() !void {
    solve();
}

const String =  [] const u8;

fn solve(a: String, b: String) !bool {
    var gpa = std.heap.GeneralPurposeAllocator(.{}){};
    defer _ = gpa.deinit();
    const alloc = gpa.allocator();
    var map = std.AutoHashMap(u8, i32).init(alloc);
    defer map.deinit();
    for (0..a.len) |i| {
       const val1 = map.get(a[i]) orelse 0; 
       try map.put(a[i], val1+1);
       const val2 = map.get(b[i]) orelse 0; 
       try map.put(b[i], val2-1);
    }
    var isAnagram = true;
    var it = map.valueIterator();
    // var asdf = try it.next();
    while (it.next()) |val| {
        if (val.* != 0) {
            isAnagram = false;
            break;
        }
    }
    return isAnagram;

}

test "1" {
    const a = "racecar";
    const b = "carrace";
    const isAnagram = solve(a, b);
    try testing.expectEqual(true, isAnagram);

}

test "2" {
    const a = "jar";
    const b = "jam";
    const isAnagram = solve(a, b);
    try testing.expectEqual(false, isAnagram);
    
}
