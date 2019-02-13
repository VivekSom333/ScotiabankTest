package com.scotia.test.testapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.scotia.test.testapp.service.ScotiaTestService;
import com.scotia.test.testapp.service.impl.ScotiaTestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class ScotiaTestControllerTest {

	@TestConfiguration
	public class ScotiaTestControllerTestConfig {

		@Bean
		public ScotiaTestService scotiaTestService() {
			return new ScotiaTestServiceImpl();
		}
	}

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ScotiaTestService scotiaTestService;

	// Method test webservice method which accept and print params given in example
	// only and one file
	@Test
	public void testhandleMultipart() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.multipart("/scotiatest/form")
				.file("thefile", "Some Scotia Test File Content".getBytes()).param("fileid", "TestId1")
				.param("description", "TestDescription for Scotia Test").accept(MediaType.MULTIPART_FORM_DATA)
				.contentType(MediaType.MULTIPART_FORM_DATA);
		mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content()
						.string("TestId1\nTestDescription for Scotia Test\nSome Scotia Test File Content"))
				.andReturn();

	}

	// Method to test webservice method which accept and print any number of params
	// and one file
	@Test
	public void handleMultipartver2() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.multipart("/scotiatest/formAll")
				.file("thefile", "Some Scotia Test File2 Content".getBytes()).param("fileid", "TestId1")
				.param("description", "TestDescription for Scotia Test").param("xyz", "random1")
				.param("xyz2", "random2").accept(MediaType.MULTIPART_FORM_DATA)
				.contentType(MediaType.MULTIPART_FORM_DATA);
		mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(
						"TestId1\nTestDescription for Scotia Test\nrandom1\nrandom2\nSome Scotia Test File2 Content"))
				.andReturn();

	}

}
