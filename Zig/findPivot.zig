const print = @import("std").debug.print;
const max = @import("std").math.max;
const std = @import("std");


pub fn main () !void {
    print("Result {}: {} ", .{8, findPivot(8)});
    print("Result {}: {} ", .{1, findPivot(1)});
    print("Result {}: {} ", .{4, findPivot(4)});
    print("Result {}: {} ", .{49, findPivot(49)});
    print("Result {}: {} ", .{288, findPivot(288)});
}

pub fn findPivot (comptime x: usize) i32 {
    if (x == 1) {return 1;}
    var arr = [_]i32{0} ** x;
    var n: usize = x;
    var i: usize = 0;
    while (i < n) : (i += 1) {
        var prev: usize = i;
        if (i!=0) {prev = i - 1;} 
        const j = n-1-i; 
        var front_val = arr[prev] + @truncate(i32, @as(i128, i))+1;
        var end_val = arr[n-1-prev] + @truncate(i32, @as(i128, j))+1;
        if (front_val == arr[i]) {
            return @truncate(i32, @as(i128, i)) + 1;
        }
        arr[i] = front_val;
        if (arr[j] == 0) {
            arr[j] = end_val;
        } 
    }
    return -1;
} 