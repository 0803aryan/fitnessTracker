package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.fitnesstracker.app.dto.CaloriesBurnedDto;
import com.cg.fitnesstracker.app.exceptions.ApplicationException;
import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.service.ActivityService;

@CrossOrigin("http://localhost:3000/")
@Controller
@RequestMapping("/fitness/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@GetMapping()
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<List<Activity>> getUserActivity(Principal p) {

		List<Activity> activityList = this.activityService.getActivity(p.getName());
		if(activityList.isEmpty())
		{
			throw new ApplicationException("User Has No Activities", 404);
		}
		//		List<Activity> activityList = activityService.getActivity(userName);
		return new ResponseEntity<>(activityList, HttpStatus.OK);
	}


	//To add a cardio activity
	@PostMapping(value="/cardio", consumes = {"application/json","application/xml" }, produces = {"application/json","application/xml" })
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Cardio> addCardio(Principal p,@RequestBody Cardio cardio) {
		final Activity c=this.activityService.addCardioActivityService(p.getName(), cardio);
		return (ResponseEntity<Cardio>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	//To add workout activity
	@PostMapping(value="/workout")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Workout> addWorkout(Principal p, @RequestBody Workout workout) {
		final Activity c=this.activityService.addWorkoutActivityService(p.getName(), workout);
		return (ResponseEntity<Workout>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	//Delete an activity by activity Id
	@DeleteMapping(value ="/{activityId}" , consumes = {"application/json","application/xml" }, produces = {"application/json","application/xml" })
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Activity> deleteUserActivity(Principal p,
			@PathVariable("activityId") int activityId, @RequestBody Activity a) {


		a=activityService.getActivityById(activityId);
		a = activityService.deleteActivity(p.getName(), activityId);		
		return new ResponseEntity<Activity>(a, HttpStatus.OK);
	}
	
	//Get calories of the cardio activity
	@GetMapping(value="cardio/calories/{activityId}" , consumes = {"application/json","application/xml" }, produces = {"application/json","application/xml" })
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<CaloriesBurnedDto> getCaloriesBurned(Principal p,
			@PathVariable int activityId) {

		int calories=activityService.getCaloriesBurned(p.getName(), activityId);
		Activity activity=activityService.getActivityById(activityId);

		CaloriesBurnedDto calDto=new CaloriesBurnedDto();
		calDto.setCaloriesBurned(calories);
		calDto.setActivityId(activityId);
		calDto.setActivityName(activity.getActivityName());

		return new ResponseEntity<>(calDto, HttpStatus.OK);
	}

}
