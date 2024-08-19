
const std = @import("std");
const io = std.io;
const ascii = std.ascii;
// var file = try std.fs.cwd().openFile("foo.txt", .{});
// defer file.close();
// var buf_reader = io.bufferedReader(file.reader());
// var in_stream = buf_reader.reader();
// var buf: [1024]u8 = undefined;
// while (try in_stream.readUntilDelimiterOrEof(&buf, '\n')) |line| {
//     // do something with line...
// }

// @embedFile returns a compile time constant pointer to null-terminated, fixed-size array with length equal to the byte count of the file given by path. The contents of the array are the contents of the file. This is equivalent to a string literal with the file contents.
//
// const std = @import("std");
// const data = @embedFile("calories.txt");
// const split = std.mem.split;
//
// pub fn main() !void {
//     var splits = split(u8, data, "\n");
//     while (splits.next()) |line| {
//         std.debug.print("{s}\n", .{line});
//     }
// }


pub fn main() !void {
    // var file = try std.fs.cwd().openFile("sample.txt", .{});
    var file = try std.fs.cwd().openFile("puzzle.txt", .{});
    defer file.close();

    var buf: [1024]u8 = undefined;
    _ = try file.readAll(&buf);
    // std.debug.print("{s}\n\n", .{buf});
    var total: u32 = 0;
    var iter = std.mem.splitSequence(u8, &buf, "\n\n");
    while (iter.next()) |elf| {
        // std.debug.print("{s}\n\n", .{elf});
        var each_elf = std.mem.splitSequence(u8, elf, "\n");
        var temp_total: u32 = 0;
        while (each_elf.next()) |food| {
            // std.debug.print("{s} < This \n", .{food});
            if (food.len >= 500) {
                continue;
            }
            // std.debug.print("{} < Length \n", .{food.len});
            const val = try std.fmt.parseInt(u32, food, 10);
            temp_total += val;
        }
        if (temp_total > total) {
            total = temp_total;
        }
    }
    std.debug.print("{}", .{total});

}
