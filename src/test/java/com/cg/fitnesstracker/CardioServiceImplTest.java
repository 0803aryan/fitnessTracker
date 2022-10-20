package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.service.implementation.CardioServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CardioServiceImplTest {
	@Mock
	private CardioRepository cardiorepo;
	@InjectMocks
	private CardioServiceImpl cardioservice;
	
	@Test
	void testaddCardio() {
		Cardio c= new Cardio (CardioType.JOGGING, 200,60, DayOfWeek.MONDAY, true);
		when(cardiorepo.save(any())).thenReturn(c);
		assertEquals(c, cardioservice.addCardio(c));
	}
	@Test
	void testremoveCardio() {
		Cardio c= new Cardio (CardioType.JOGGING, 200,60, DayOfWeek.MONDAY, true);
		c.setActivityId(1);
		when(cardiorepo.findById(anyInt())).thenReturn(Optional.of(c));
		
		assertEquals(c,cardioservice.removeCardio(1));
		verify(cardiorepo).deleteById(anyInt());
	}
	@Test
	void testgetCardioByType() {
		Cardio c= new Cardio (CardioType.JOGGING, 200,60, DayOfWeek.MONDAY, true);
		c.setActivityId(1);
		when(cardiorepo.findByCardioType(any())).thenReturn(c);
		assertEquals(c,cardioservice.getCardioByType(CardioType.JOGGING));
	}
}
