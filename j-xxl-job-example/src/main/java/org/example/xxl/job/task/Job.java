package org.example.xxl.job.task;

import com.xxl.job.core.handler.annotation.XxlJob;

/**
 * ClassName: Job
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/12/14 6:47
 */
public class Job {
    @XxlJob("demoJobHandler")
    public void demoJobHandler(String param) throws Exception {
        System.out.println("start job...................");
    }
}
