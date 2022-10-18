package com.cg.fitnesstracker.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.model.enums.WorkoutType;
import com.cg.fitnesstracker.app.service.ActivityService;
import com.cg.fitnesstracker.app.service.CardioService;
import com.cg.fitnesstracker.app.service.WorkoutService;

@Controller
@RequestMapping("/fitness/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;
	@Autowired
	CardioService cardioService;
	@Autowired
	WorkoutService workoutService;

	public void setActivityService (ActivityService activityService) {
		this.activityService=activityService;
	}
	public void setCardioService (CardioService cardioService) {
		this.cardioService=cardioService;
	}
	public void setWorkoutService (WorkoutService workoutService) {
		this.workoutService=workoutService;
	}

	/*@PostMapping(value="/add")
	public ResponseEntity<Activity> addActivity(@RequestBody final Activity activity) {
		final Activity a=this.activityService.addCardioActivityService(null, null)
	}*/

	@PostMapping(value="/cardio/{userName}", consumes={"application/json"}, produces= {"application/json"})
	public ResponseEntity<Cardio> addCardio(@PathVariable("userName") String userName, @RequestBody Cardio cardio) {
		final Activity c=this.activityService.addCardioActivityService(userName, cardio);

		return (ResponseEntity<Cardio>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	@PostMapping(value="/workout/{userName}")
	public ResponseEntity<Workout> addWorkout(@PathVariable("userName") String userName, @RequestBody Workout workout) {
		final Activity c=this.activityService.addWorkoutActivityService(userName, workout);

		return (ResponseEntity<Workout>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	@DeleteMapping(value= {"/delete/{userName}/{activityId}"}, consumes={"application/json"}, produces= {"application/json"})
	public ResponseEntity<Activity> deleteUserActivity(@PathVariable("userName") String userName, @PathVariable("activityId") int activityId, @RequestBody Activity a) {
		a = activityService.deleteActivity(userName, activityId);

		return new ResponseEntity<Activity>(a, HttpStatus.OK);
	}

	@GetMapping(value="/cardio_type")
	public ResponseEntity<List<Cardio>> getCardioByType(@RequestParam("cardiotype") CardioType cardioType) {
		@SuppressWarnings("unchecked")
		List<Cardio> cardioList=(List<Cardio>) cardioService.getCardioByType(cardioType);

		return new ResponseEntity<List<Cardio>>(cardioList, HttpStatus.OK);
	}

	@GetMapping(value="/workout_type")
	public ResponseEntity<List<Workout>> getWorkoutByType(@RequestParam("workouttype") WorkoutType workoutType) {
		@SuppressWarnings("unchecked")
		List<Workout> workoutList=(List<Workout>) workoutService.getWorkoutByType(workoutType);

		return new ResponseEntity<List<Workout>>(workoutList, HttpStatus.OK);
	}




}
