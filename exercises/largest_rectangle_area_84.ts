function largestRectangleArea(heights: number[]): number {
    const n = heights.length;
    let maxArea = 0;
    const stack: number[] = [];

    for (let i = 0; i <= n; i++) {
        const currHeight = i === n ? 0 : heights[i];
        while (stack.length > 0 &&
            (i === n || heights[stack[stack.length - 1]] >= currHeight)) {
            const height = heights[stack.pop()!];
            const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }

    return maxArea;
}
