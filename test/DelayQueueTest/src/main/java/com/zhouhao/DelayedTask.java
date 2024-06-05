package com.zhouhao;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
    private long executeTime;

    @Override
    public String toString() {
        return super.toString();
    }

    private DelayedTask(long executeTime) {
        this.executeTime = executeTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
//        assert unit == TimeUnit.MILLISECONDS : "入参不对";
        long result = executeTime - System.currentTimeMillis();
        if(unit == TimeUnit.NANOSECONDS)
            System.out.println(result);
        return result;
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) throws InterruptedException {
        Calendar instance = Calendar.getInstance();
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
        instance.add(Calendar.SECOND, 0);
        DelayedTask delayedTask = new DelayedTask(instance.getTimeInMillis());
        System.out.println(delayedTask.getDelay(TimeUnit.MILLISECONDS));
        delayeds.add(delayedTask);
        instance.add(Calendar.SECOND, 5);
        DelayedTask delayedTask2 = new DelayedTask(instance.getTimeInMillis());
        System.out.println(delayedTask2.getDelay(TimeUnit.MILLISECONDS));
        delayeds.add(delayedTask2);
        instance.add(Calendar.SECOND, 5);
        DelayedTask delayedTask3 = new DelayedTask(instance.getTimeInMillis());
        System.out.println(delayedTask3.getDelay(TimeUnit.MILLISECONDS));
        delayeds.add(delayedTask3);

        while (!delayeds.isEmpty()){
            Delayed poll = delayeds.poll();
            if(poll != null){
                System.out.println(poll);
            }
            Thread.sleep(1000);
        }

    }
}

interface Test{
    int a = 10;
}
