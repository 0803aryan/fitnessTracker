package com.cg.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.DayOfWeek;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;
import com.cg.fitnesstracker.app.repository.WorkoutRepository;

import com.cg.fitnesstracker.app.service.implementation.WorkoutServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class WorkoutServiceImplTest {
	@Mock
	private WorkoutRepository workoutRepository;
	@InjectMocks
	private WorkoutServiceImpl workoutService;
	@BeforeAll
	static void setup() {
		
	}
	@Test
	void testremoveUserWorkout() {
		Workout w1= new Workout(WorkoutType.CHESTWORKOUT, 200, DayOfWeek.SATURDAY, true);
		w1.setActivityId(12);
		when(workoutRepository.findById(anyInt())).thenReturn(Optional.of(w1));
		
		assertEquals(w1,workoutService.removeUserWorkout(12));
		verify(workoutRepository).deleteById(anyInt());
		
	}
	@Test
	void testgetWorkoutByType() {
		 
		Workout w1= new Workout(WorkoutType.CHESTWORKOUT, 200, DayOfWeek.SATURDAY, true);
		w1.setActivityId(12);
		when(workoutRepository.findByWorkoutType(any())).thenReturn(w1);
		assertEquals(w1,workoutService.getWorkoutByType(WorkoutType.CHESTWORKOUT));
		
	}
	@Test
	void testaddUserWorkout() {
		Workout w1= new Workout(WorkoutType.CHESTWORKOUT, 200, DayOfWeek.SATURDAY, true);
		w1.setActivityId(12);
		when(workoutRepository.save(any())).thenReturn(w1);
		assertEquals(w1,workoutService.addUserWorkout(w1));
	}

	
}
