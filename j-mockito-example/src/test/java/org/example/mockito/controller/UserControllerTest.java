package org.example.mockito.controller;

import org.example.mockito.MockitoApplication;
import org.example.mockito.dao.UserDao;
import org.example.mockito.entity.User;
import org.example.mockito.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * ClassName: UserControllerTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/10 16:56
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MockitoApplication.class)
class UserControllerTest {
    @Autowired
    UserController controller;

    @Autowired
    UserService userService;

    @MockBean   //需要mock的bean，会自动注入到调用的对象中
    private UserDao userDao; //没有实现类

    MockMvc mockMvc;

    /**
     * .perform() : 执行一个MockMvcRequestBuilders的请求；MockMvcRequestBuilders有.get()、.post()、.put()、.delete()等请求。
     * .andDo() : 添加一个MockMvcResultHandlers结果处理器,可以用于打印结果输出(MockMvcResultHandlers.print())。
     * .andExpect : 添加MockMvcResultMatchers验证规则，验证执行结果是否正确。
     */
    @Test
    void say() throws Exception {
        // 定义未实现的 service 返回
        Mockito.when(userDao.getUser(ArgumentMatchers.anyLong())).thenReturn(new User(12L, "张三", "路人"));

        //模拟接口调用
        ResultActions perform = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/12"));

        //对接口响应进行验证
        perform.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":12,\"name\":\"张三\",\"desc\":\"路人\"}"));  // 可以不用写成转义后的json格式

        System.out.println(perform.andReturn().getResponse().getContentAsString());
    }

    @Test
    void edit() throws Exception {
        // 定义未实现的 service 返回
        Mockito.when(userDao.edit( ArgumentMatchers.any(User.class))).thenReturn(new User(12L, "张三", "路人"));

        //模拟接口调用
        ResultActions perform = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":12,\"name\":\"张三\",\"desc\":\"路人\"}"));   // 必须写成转义后的json格式，否则没法转换

        //对接口响应进行验证
        perform.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":12,\"name\":\"张三\",\"desc\":\"路人\"}"));  // 可以不用写成转义后的json格式

        System.out.println(perform.andReturn().getResponse().getContentAsString());
    }

    /**
     * 测试 service 层
     */
    @Test
    public void test() {
        // 定义未实现的 service 返回
        Mockito.when(userDao.getUser(ArgumentMatchers.anyLong())).thenReturn(new User(ArgumentMatchers.anyLong(), "张三", "路人"));
        System.out.println(userService.getUser(12L).toString());
        Mockito.verify(userDao, Mockito.times(1)).getUser(ArgumentMatchers.anyLong());
    }

    /**
     * 测试 controller 时，需要构建 mvc 环境
     */
    @BeforeEach
    public void setup() {
        //构建mvc环境
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


}