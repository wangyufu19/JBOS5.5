package com.jbos.common.utils;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 工作调度器
 * @author youfu.wang
 * @date 2020-05-28
 */
public class JobScheduler {
    private Timer timer =new Timer();

    public void startJob(){
        timer.schedule(new JobTask(),5000);
    }

    public class JobTask extends TimerTask{
        public void run(){
            System.out.println("******call JobTask");
        }
    }

    public static void main(String[] args){
        JobScheduler jobScheduler=new JobScheduler();
        jobScheduler.startJob();
    }
}
