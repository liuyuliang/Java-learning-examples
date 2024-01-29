package org.example.xxl.job.task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ClassName: Job
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/12/14 6:47
 */
@Component
public class Job {
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        System.out.println("start job...................");
    }
    @XxlJob("demoDateJobHandler")
    public void genMonth(String start,String end ){
        // 获取参数
        String param = XxlJobHelper.getJobParam();
        String[] methodParams = param.split(",");
        Arrays.stream(methodParams).forEach(System.out::println);

    }
}
