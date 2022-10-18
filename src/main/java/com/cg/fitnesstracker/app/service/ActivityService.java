package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.WorkoutRepository;
import com.cg.fitnesstracker.app.service.ActivityService;
import com.cg.fitnesstracker.app.service.CardioService;
import com.cg.fitnesstracker.app.service.WorkoutService;
@Component

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private CardioRepository cardioRepo;
	@Autowired
	private WorkoutRepository workoutRepo;
	@Autowired
	private WorkoutService workoutService;
	@Autowired
	private CardioService cardioService;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Cardio addCardioActivityService(String userName, Cardio cardioActivity) {

		Customer customer = customerRepository.findByUserName(userName);

		if(customer!=null)
		{
			List<Cardio> cardioList=customer.getCardio();
			cardioList.add(cardioActivity);
			cardioRepo.saveAll(cardioList);
		}
		return  cardioActivity;
	}

	@Override
	public Workout addWorkoutActivityService(String userName, Workout workoutActivity) {
		Customer customer = customerRepository.findByUserName(userName);

		if(customer!=null)
		{
			List<Workout> workoutList=customer.getWorkout();
			workoutList.add(workoutActivity);
			workoutRepo.saveAll(workoutList);
		}
		return  workoutActivity;
	}

	@Override
	public Cardio deleteCardioActivityService(String userName, int cardioId) {
		Customer customer=customerRepository.findByUserName(userName);

		Cardio cardio=cardioRepo.findById(cardioId).get();
		if(cardio!=null)
		{
			List<Cardio> cardioList=customer.getCardio();
			cardioList.remove(cardio);
			cardioRepo.saveAll(cardioList);
		}
		return cardio;
	}

	@Override
	public Workout deleteWorkoutActivityService(String userName, int workoutId) {
		Customer customer=customerRepository.findByUserName(userName);

		Workout workout=workoutRepo.findById(workoutId).get();
		if(workout!=null && customer!=null)
		{
			List<Workout> workoutList=customer.getWorkout();
			workoutList.remove(workout);
			workoutRepo.saveAll(workoutList);
		}
		return workout;
	}

	@Override
	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity) {
		cardioService.updateExistingCardio(userId, cardioActivity);
		return cardioActivity;
	}

	@Override
	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity) {
		workoutService.updateExistingWorkout(userId, workoutActivity);
		return workoutActivity;
	}

}
