package com.slokam.rest.controller.test;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.slokam.rest.controller.StateController;
import com.slokam.rest.dao.StateDAO;
import com.slokam.rest.pojo.Country_M;
import com.slokam.rest.pojo.State_M;
import com.slokam.rest.service.StateService;

public class StateControllerTest {

	MockMvc mockMvc  = null;
	
	@InjectMocks
	private StateController stateController;
	
	@InjectMocks
	private StateService stateService ;
	
	@Mock
	private StateDAO stateDao;
	
	 @Before
	public void init(){
		    MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                 .standaloneSetup(stateController)
	                 .addFilters(new CorsFilter())
	                 .build();
	}
	
	@Test
	public void test1() throws Exception{
	   	
		Country_M country = new Country_M();
		country.setId(1);
		State_M state = new State_M();
		state.setName("Test");
		state.setCountry(country);
		
		stateService.saveState(state);
		
		/* ProfileSummary summary = new ProfileSummary();
		 summary.setId(2);
		 summary.setResmsePath("ResumePath");
		 summary.setResumeHeadline("HEAD LINE");
		 when(profileSummaryService.getProfileSummaryById(2)).thenReturn(summary);
		 mockMvc.perform(get("/profileSummary/{id}",2))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.resumeHeadline", Is.is("HEAD LINE--DATA")));
		 */
	}
	 
	 
/*	 @Test
    public void test2() throws Exception{
    	ProfileSummary summary = new ProfileSummary();
		 summary.setId(2);
		 summary.setResmsePath("ResumePath");
		 summary.setResumeHeadline("HEAD LINE");
		 
		 ProfileSummary summary3 = new ProfileSummary();
		 summary3.setId(3);
		 summary3.setResmsePath("ResumePath3");
		 summary3.setResumeHeadline("HEAD LINE3");
    	
    	List<ProfileSummary> profileList = new ArrayList<ProfileSummary>();
    	profileList.add(summary);
    	profileList.add(summary3);
    	
    	
    	when(profileSummaryService.getAllProfileSummaries()).thenReturn(profileList);
		mockMvc.perform(get("/profileSummary/all"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", is(2)))
		.andExpect(jsonPath("$[1].id", is(3)));
		
		
	}*/
}
