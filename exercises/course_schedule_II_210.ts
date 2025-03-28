// Kinda performant solution but it uses unshift instead of a real queue
// Beats 76% of solutions when it runs at best (9ms)
function findOrder(numCourses: number, prerequisites: number[][]): number[] {
    const adjList: number[][] = Array.from({ length: numCourses }, () => []);
    const inDegree: number[] = new Array(numCourses).fill(0);
    
    for (const [course, pre] of prerequisites) {
        adjList[pre].push(course);
        inDegree[course]++;
    }
    
    const queue: number[] = [];
    for (let i = 0; i < numCourses; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
        }
    }
    
    const path: number[] = [];
    while (queue.length > 0) {
        const course = queue.shift()!;
        path.push(course);
        
        for (const nextCourse of adjList[course]) {
            inDegree[nextCourse]--;
            if (inDegree[nextCourse] === 0) {
                queue.push(nextCourse);
            }
        }
    }
    
    return path.length === numCourses ? path : [];
}
