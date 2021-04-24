package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 84.在柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {

    // 解法一  先找出柱子的每根柱子的左右边界，再求最大面积
    public int largestRectangleAreaA(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] lessFromLeft = new int[n];  // 左边界下标数组
        int[] lessFromRight = new int[n];  // 右边界的下标数组
        lessFromLeft[0] = -1;
        lessFromRight[n - 1] = n;

        // 找出每个柱子的最小左边界
        for (int i = 1; i < n; i++) {
            int k = i - 1;
            while (k >= 0 && heights[k] >= heights[i]) {
                k = lessFromLeft[k];  // heights[k]左边界可能是heights[i]左边界，所以这里直接赋值给k
            }
            lessFromLeft[i] = k;
        }

        // 找出每个柱子的最小右边界
        for (int i = n - 2; i >= 0; i--) {
            int k = i + 1;
            while (k < n && heights[k] >= heights[i]) {
                k = lessFromRight[k];
            }
            lessFromRight[i] = k;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return maxArea;

    }


    // 解法二，维护一个递增的栈，当有小于栈顶元素出现的时候，说明出现了右边界
    public int largestRectangleAreaB(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();

        int[] newHeight = new int[heights.length + 2];  // 数组前后各增加一个0, 可以使栈弹到最后为空
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        stack.push(0);
        int area = 0;
        for (int i = 1; i < newHeight.length; i++) {  // 因为前面加了0，直接从1开始
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int 上 = newHeight[stack.pop()];  // 栈顶的元素为矩形的高
                area = Math.max(area, newHeight[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return area;
    }


}
