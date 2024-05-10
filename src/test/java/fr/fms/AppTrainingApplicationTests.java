package fr.fms;

import fr.fms.service.ImplTrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class AppTrainingApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ImplTrainingService implTrainingService;


	@Test
	public void testGetTrainings() throws Exception{
		mockMvc.perform(get("/trainings"))
				.andExpect(status().isOk());
	}
	/*
	@Test
	void testGetTrainingsAndTestName() throws Exception{
		mockMvc.perform(get("/trainings"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is("Java")));
	}
	*/
}
