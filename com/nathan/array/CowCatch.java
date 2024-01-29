package com.nathan.array;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 农夫抓牛问题
 * 农夫和牛在一条直线上，农夫需要抓住牛，每一步，农夫可以选择向前走一步，向后走一步，或者跳跃到当前位置的两倍。我们需要找到农夫抓住牛的最少步数。
 *
 * */
public class CowCatch {

    /**
     * 1.使用一个队列来存储农夫的所有可能的位置，初始时，队列中只有农夫的起始位置。
     *
     * 2.使用一个数组来记录农夫到达每个位置所需要的步数，初始时，所有位置的步数都是无穷大，只有起始位置的步数是0。
     *
     * 3.使用一个布尔数组来记录农夫是否已经访问过每个位置，初始时，所有位置都没有被访问过，只有起始位置被访问过。
     *
     * 4.然后，我们开始进行广度优先搜索：每一步，我们取出队列中的一个位置，然后考虑农夫的三种可能的移动方式，对于每一种移动方式，如果新的位置没有被访问过，并且在合理的范围内，我们就将新的位置加入队列，并更新步数和访问状态。
     *
     * 5.当我们取出牛的位置时，搜索结束，此时牛的位置的步数就是答案。
     * */

    private Integer MAX = 100000;

    public Integer cowCatch(int start, int end) {
        Boolean[] visited = new Boolean[MAX];
        visited[start] = true;

        Integer[] steps = new Integer[MAX];
        steps[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == end) {
                return steps[cur];
            }
            if (cur - 1 > 0 && !visited[cur - 1]) {
                steps[cur - 1] = steps[cur] + 1;
                visited[cur - 1] = true;
                queue.add(cur - 1);
            }
            if (cur + 1 < MAX && !visited[cur - 1]) {
                steps[cur + 1] = steps[cur] + 1;
                visited[cur + 1] = true;
                queue.add(cur + 1);
            }

            if (cur * 2 < MAX && !visited[cur * 2]) {
                steps[cur * 2] = steps[cur] + 1;
                visited[cur * 2] = true;
                queue.add(cur * 2);
            }
        }
        return -1;
    }

}
