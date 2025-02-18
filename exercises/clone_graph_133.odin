package main

import "core:fmt"

Node :: struct {
    val: int,
    neighbors: [dynamic]^Node,
}
main :: proc() {
    // Create test graph: 1 <-> 2 <-> 3 <-> 1
    n1 := new(Node)
    n2 := new(Node)
    n3 := new(Node)
    
    n1.val = 1
    n2.val = 2
    n3.val = 3
    
    n1.neighbors = make([dynamic]^Node)
    n2.neighbors = make([dynamic]^Node)
    n3.neighbors = make([dynamic]^Node)
    
    append(&n1.neighbors, n2)
    append(&n2.neighbors, n1, n3)
    append(&n3.neighbors, n2)
    
    cloned := clone_graph(n1)
    
    // Verify structure
    fmt.println("Original:", n1.val, "->", n1.neighbors[0].val)
    fmt.println("Cloned:", cloned.val, "->", cloned.neighbors[0].val)
    
    // Clean up
    delete_graph(cloned)
    delete_graph(n1)
}

clone_graph :: proc(node: ^Node) -> ^Node {
    if node == nil do return nil
    
    // Map to store created nodes, using pointer as key
    cloned := make(map[^Node]^Node)
    defer delete(cloned)
    
    return dfs(node, &cloned)
}

dfs :: proc(node: ^Node, cloned: ^map[^Node]^Node) -> ^Node {
    if node == nil do return nil
    
    // If we already cloned this node, return the clone
    if existing, ok := cloned[node]; ok {
        return existing
    }
    
    // Create new node
    new_node := new(Node)
    new_node.val = node.val
    new_node.neighbors = make([dynamic]^Node)
    
    // Store in our map before processing neighbors
    cloned[node] = new_node
    
    // Clone all neighbors
    for neighbor in node.neighbors {
        cloned_neighbor := dfs(neighbor, cloned)
        append(&new_node.neighbors, cloned_neighbor)
    }
    
    return new_node
}

// Helper to clean up a cloned graph
delete_graph :: proc(node: ^Node) {
    if node == nil do return
    
    visited := make(map[^Node]bool)
    defer delete(visited)
    
    delete_graph_recursive(node, &visited)
}

delete_graph_recursive :: proc(node: ^Node, visited: ^map[^Node]bool) {
    if node == nil do return
    if visited[node] do return
    
    visited[node] = true
    
    for neighbor in node.neighbors {
        delete_graph_recursive(neighbor, visited)
    }
    
    delete(node.neighbors)
    free(node)
}
