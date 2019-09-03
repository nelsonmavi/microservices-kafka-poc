package com.mavi.microserviceskafkapoc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith( SpringRunner.class )
@SpringBootTest
@DirtiesContext
@WebAppConfiguration
@EmbeddedKafka
public class ProducerControllerTest {
  
  @Autowired
  private WebApplicationContext webApplicationContext;
  
  private MockMvc mockMvc;
  
  @Before
  public void setUp () {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
  
  @Test
  public void givenWac_whenServletContext_thenProvidesProducerController () {
    ServletContext servletContext = webApplicationContext.getServletContext();
    Assert.assertNotNull(servletContext);
    Assert.assertTrue(servletContext instanceof MockServletContext);
    Assert.assertNotNull(webApplicationContext.getBean("producerController"));
  }
  
  @Test
  public void givenGreetURI_whenMockMVC_thenVerifyResponse () throws Exception {
    MvcResult mvcResult = mockMvc.perform(get("/producer")).andDo(print()).andExpect(status().isOk()).andReturn();
    Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
  }
  
  @Test
  public void givenPublishURI_whenMockMVC_thenVerifyResponse () throws Exception {
    MvcResult mvcResult = mockMvc.perform(post("/producer/publish").param("message", "any")).andDo(print()).andExpect(status().isOk()).andReturn();
    Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
  }
  
  
  
  
}