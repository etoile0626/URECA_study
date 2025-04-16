package kr.co.ureca.book1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//여긴 강사님 코드 보고 붙여넣기
@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Test
    public void test() throws Exception {
        final String url ="/test";
        Member member = new Member(4L, "홍길동");

        final ResultActions result = mockMvc.perform(
                get(url).accept(MediaType.APPLICATION_JSON)
        );

        //여긴 강사님 코드 보고 붙여넣기
        result.andExpect(status().isOk()).andExpect(jsonPath("${0}.id").value(member.getId())
                        .andExpect(jsonPath("${0}.name").value(member.getName()))
                );
    }

}