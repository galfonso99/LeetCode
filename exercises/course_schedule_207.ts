// Performant solution
function canFinish(numCourses: number, prerequisites: number[][]): boolean {
    const adjList: number[][] = Array(numCourses).fill(null).map(() => []);
    const inDegree: number[] = Array(numCourses).fill(0);

    for (const prerequisite of prerequisites) {
        const course = prerequisite[0];
        const pre = prerequisite[1];
        adjList[pre].push(course);
        inDegree[course]++;
    }

    const queue: number[] = [];
    for (let i = 0; i < numCourses; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
        }
    }

    let count = 0;
    while (queue.length > 0) {
        const course = queue.shift()!;
        count++;

        for (const nextCourse of adjList[course]) {
            inDegree[nextCourse]--;
            if (inDegree[nextCourse] === 0) {
                queue.push(nextCourse);
            }
        }
    }

    return count === numCourses;
}
