package org.example.mockito.entity;

/**
 * ClassName: User
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:39
 */
public class User {
    private Long id;
    private String name;
    private String desc;

    public User() {
    }

    public User(Long id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
