



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Diet;
import com.cg.fitnesstracker.app.model.enums.ConsumeTime;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.repository.DietRepository;
import com.cg.fitnesstracker.app.service.implementation.DietServiceImpl;

@RunWith(SpringRunner.class)

@SpringBootTest
public class DietServiceImplTest {
	@MockBean
	private DietRepository dietrepository;
	@Autowired
	private DietServiceImpl dietservice;
	private static List<Diet> dietlisT = new ArrayList<>();
	@BeforeAll
	static void setup() {
		Diet d1= new Diet(ConsumeTime.fromInteger(0),DayOfWeek.fromInteger(0));
		Diet d2= new Diet(ConsumeTime.fromInteger(1),DayOfWeek.fromInteger(1));
		Customer c1= new Customer();
		Customer c2= new Customer();
		c1.setUserName("Rakesh");
		d1.setCustomer(c1);
		c1.setUserName("Rakeshs");
		d1.setCustomer(c2);
		dietlisT.add(d1);
		dietlisT.add(d2);
	}
	@Test
	void testGetAllDietServices () {
		
		System.out.println(dietlisT.size());
		assertNotNull(dietrepository);
//		when(dietrepository.findAll()).thenReturn(dietlisT);
//		List<Diet> dlist= dietservice.getAllDietService("Rakesh");
//		assertEquals(dlist.size(),dietlisT.size());
//		
		
	}
}
