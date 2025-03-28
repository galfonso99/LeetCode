import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Pretty performant solution that follows upon the building blocks of 'course_schedule_1'
// Beats 80% if solutions (5ms)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course); // pre -> course
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

		// Viable course taking path
		int[] path = new int[numCourses];

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
			path[count] = course;
            count++;

            for (int nextCourse : adjList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

		if (count != numCourses) return new int[0];
        return path;
    }
}
