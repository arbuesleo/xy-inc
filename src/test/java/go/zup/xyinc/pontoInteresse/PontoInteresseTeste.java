package go.zup.xyinc.pontoInteresse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import go.zup.xyinc.XyIncApplicationTests;
import go.zup.xyinc.PontoInteresse.PontoInteresseService;
import go.zup.xyinc.utils.PathMap;
import go.zup.xyinc.utils.TestUtils;

public class PontoInteresseTeste extends XyIncApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private PontoInteresseService poiService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(poiService).build();
	}
	
	@Test
	public void getAllPois() throws Exception {
		MvcResult result = this.mockMvc.
					perform(MockMvcRequestBuilders.get(PathMap.PONTO_INTERESSE))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		assertEquals(content, TestUtils.getFile("allPois.json"));
	}
	
	@Test
	public void getPoisPorLocalizacao() throws Exception {
		MvcResult result = this.mockMvc.
					perform(MockMvcRequestBuilders.get(PathMap.PONTO_INTERESSE + "/pesquisaPorProximidade?cooX=20&cooY=10&DMax=10"))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		assertEquals(content, TestUtils.getFile("PoisPorLocalizacao.json"));
	}

}
