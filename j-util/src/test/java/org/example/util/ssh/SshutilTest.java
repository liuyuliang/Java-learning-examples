package org.example.util.ssh;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: SshutilTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 15:43
 */
class SshutilTest {

    @org.junit.jupiter.api.Test
    void runCmd() {
        SshConfiguration conf = new SshConfiguration();
        conf.setHost("192.168.174.3");
        conf.setUsername("root");
        conf.setPassword("123456");
        conf.setPort(22);
        try {
            Sshutil sshUitl = new Sshutil(conf);
//            sshUitl.upload("testData/vvv.txt", "/home/vvv.txt");
//            sshUitl.download("/home/test.txt", "testData/test.txt");
            sshUitl.runCmd("free", "UTF-8");
            sshUitl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}