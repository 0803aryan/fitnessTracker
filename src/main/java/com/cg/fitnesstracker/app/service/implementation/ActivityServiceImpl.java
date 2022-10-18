package com.cg.fitnesstracker.app.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Customer;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.CardioRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.repository.WorkoutRepository;
import com.cg.fitnesstracker.app.service.ActivityService;

@Component
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private CardioRepository cardioRepo;
	@Autowired
	private WorkoutRepository workoutRepo;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ActivityRepository activityRepo;

	@Override
	public Activity addCardioActivityService(String userName, Activity cardioActivity) {

		Customer customer = customerRepository.findByUserName(userName);
		
		if(customer!=null)
		{
			cardioActivity.setCustomer(customer);
			
			List<Activity> activityList=customer.getActivities();
			activityList.add(cardioActivity);
			activityRepo.saveAll(activityList);
			customer.setActivities(activityList);
		}
		return  cardioActivity;
	}

	@Override
	public Activity addWorkoutActivityService(String userName, Activity workoutActivity) {
		Customer customer = customerRepository.findByUserName(userName);

		if(customer!=null)
		{
			workoutActivity.setCustomer(customer);
			List<Activity> activityList=customer.getActivities();
			activityList.add(workoutActivity);
			activityRepo.saveAll(activityList);
		}
		return  workoutActivity;
	}

	@Override
	@Transactional
	@Modifying
	public Activity deleteCardioActivityService(String userName, int activityId) {
		Customer customer=customerRepository.findByUserName(userName);
		
		Activity cardioActivity=cardioRepo.findById(activityId).get();
		if(cardioActivity!=null)
		{
			List<Activity> activityList=customer.getActivities();
			activityList.remove(cardioActivity);
			activityRepo.saveAll(activityList);
		}
		return cardioActivity;
	}

	@Override
	public Workout deleteWorkoutActivityService(String userName, WorkoutType workoutType) {
		Customer customer=customerRepository.findByUserName(userName);

		Workout workout=workoutRepo.findByWorkoutType(workoutType);
		if(workout!=null && customer!=null)
		{
			List<Activity> activityList=customer.getActivities();
			activityList.remove(workout);
			activityRepo.saveAll(activityList);
		}
		return workout;
	}

//	@Override
//	public Cardio updateCardioActivityService(int userId, Cardio cardioActivity) {
//		cardioService.updateExistingCardio(userId, cardioActivity);
//		return cardioActivity;
//	}
//
//	@Override
//	public Workout updateWorkoutActivityService(int userId, Workout workoutActivity) {
//		workoutService.updateExistingWorkout(userId, workoutActivity);
//		return workoutActivity;
//	}

}
