package com.example.thread.forkJoin;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by lidongliang on 2017/7/20.
 * <p>
 * 求和操作
 * Fork/Join 框架
 * 分而治之
 * <p>
 * 1:RecursiveTask 返回V类型
 * 2:RecursiveAction 无返回值
 * <p>
 * 结果：
 * start = 0   end = 10
 * start = 0   end = 2
 * 0
 * 1
 * 3
 * start = 3   end = 5
 * 3
 * 7
 * 12
 * start = 6   end = 8
 * 6
 * 13
 * 21
 * start = 9   end = 10
 * 9
 * 19
 * start = 12   end = 10
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 5;
    private long start;
    private long end;

    private CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        // 门阀值
        boolean canCompute = (end - start) < THRESHOLD;  // 5
        System.out.println("start = " + start + "   end = " + end);

        if (canCompute) {
            // 求和核心步骤
            for (long i = start; i <= end; i++) {
                sum += i;
                System.out.println(sum);
            }
        } else {
            // 分成5个小任务（任意），必须等于循环次数  A = B
            // step 范围  0~2 3~5 6~8 ...
            long step = (start + end) / 5; // A=5   // 任务分的过多，canCompute等于true，由于start>end，所以循环不执行

            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 5; i++) {   // B=5
                long lastOne = pos + step;
                if (lastOne > end) lastOne = end;   // 保证最后一个值小于等于输入的end值

                CountTask subTask = new CountTask(pos, lastOne); // 重新传入start值、end值

                pos += step + 1; // 计算start值

                subTasks.add(subTask); // 放到集合

                subTask.fork(); // 提交子任务
            }
            for (CountTask t : subTasks) {
                sum += t.join();    // 依次执行集合中的子任务
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 10L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
