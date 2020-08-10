import com.kp.springweb.MyMvcConfig;
import com.kp.springweb.test.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)//spring测试环境
@ContextConfiguration(classes = {MyMvcConfig.class})//spring配置
@WebAppConfiguration("src/main/resources") //页面存放地址
public class TestController {
    private MockMvc mockMvc;
    @Autowired
    private DemoService demoService;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockHttpServletRequest request;
    @Autowired
    private MockHttpSession session;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();//创建mockMVC对象
    }

    //测试方法
    @Test
    public void testNomalController() throws Exception {
        //测试发送请求，正常返回，并且返回的视图的名称是page 测试返回的页面是地址  测试模型数据的值
        mockMvc.perform(MockMvcRequestBuilders.get("/normal"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                .andExpect(MockMvcResultMatchers.model().attribute("msg", demoService.sayHi()));
    }

    @Test
    public void testRestController() throws Exception {
        //测试请求 返回值类型，返回值
        mockMvc.perform(MockMvcRequestBuilders.get("/rest"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(demoService.sayHi()));
    }
}
