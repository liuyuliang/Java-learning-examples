package org.example.util.ssh;

/**
 * ClassName: SshConfiguration
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/5 15:41
 */
public class SshConfiguration {
    private String host;

    private String username;

    private String password;

    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
