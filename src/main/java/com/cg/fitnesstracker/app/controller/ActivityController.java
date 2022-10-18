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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.model.enums.CardioType;
import com.cg.fitnesstracker.app.service.ActivityService;
import com.cg.fitnesstracker.app.service.CardioService;
import com.cg.fitnesstracker.app.service.WorkoutService;

@Controller
@RequestMapping("/fitness/activity")
public class ActivityController {
/*
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
	

	@PostMapping(value="/add_cardio")
	public ResponseEntity<Cardio> addCardio(@RequestBody final Cardio cardio) {
		final Cardio c=this.cardioService.addCardio(cardio);

		return (ResponseEntity<Cardio>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	@PostMapping(value="/add_workout")
	public ResponseEntity<Workout> addWorkout(@RequestBody final Workout workout) {
		final Workout c=this.workoutService.addUserWorkout(workout);

		return (ResponseEntity<Workout>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	@DeleteMapping(value= {"delete_cardio/{cCode}"})
	public ResponseEntity<Cardio> deleteCardio(@PathVariable("cCode") final int cardioId) {
		Cardio c=cardioService.removeCardio(cardioId);
		return new ResponseEntity<Cardio>(c, HttpStatus.OK);
	}
	
	@DeleteMapping(value= {"delete_workout/{wCode}"})
	public ResponseEntity<Workout> deleteWorkout(@PathVariable("wCode") final int workoutId) {
		Workout w=workoutService.removeUserWorkout(workoutId);
		return new ResponseEntity<Workout>(w, HttpStatus.OK);
	}

	@GetMapping(value="/cardio_type")
	public ResponseEntity<List<Cardio>> getCardioByType(@RequestParam("cardiotype") CardioType cardioType) {
		@SuppressWarnings("unchecked")
		List<Cardio> cardioList=(List<Cardio>) cardioService.getCardioByType(cardioType);
		
		return new ResponseEntity<List<Cardio>>(cardioList, HttpStatus.OK);
	}

	@PutMapping(value="/{userId}/update_cardio")
	public ResponseEntity<Cardio> updateCardio(@PathVariable int cardioId, @RequestBody Cardio c) {
//		Cardio c=this.cardioService.updateExistingCardio(cardioId, c);
		
		return null;
	}

*/









}
