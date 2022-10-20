package com.cg.fitnesstracker.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.fitnesstracker.app.exception.ActivityException;
import com.cg.fitnesstracker.app.model.Activity;
import com.cg.fitnesstracker.app.model.Cardio;
import com.cg.fitnesstracker.app.model.Workout;
import com.cg.fitnesstracker.app.repository.ActivityRepository;
import com.cg.fitnesstracker.app.repository.CustomerRepository;
import com.cg.fitnesstracker.app.service.ActivityService;

@Controller
@RequestMapping("/fitness/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityRepository activityRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping()
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<List<Activity>> getUserActivity(Principal p) {

		if(this.customerRepo.findByUsername(p.getName())==null)
		{
			//change exception to UserException
			throw new ActivityException("User Does Not Exist", 400);
		}
		List<Activity> activityList = this.activityService.getActivity(p.getName());
		if(activityList.isEmpty())
		{
			throw new ActivityException("User Has No Activities", 404);
		}
		//		List<Activity> activityList = activityService.getActivity(userName);
		return new ResponseEntity<>(activityList, HttpStatus.OK);
	}



	@PostMapping(value="/cardio", consumes = {"application/json","application/xml" }, produces = {"application/json","application/xml" })
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Cardio> addCardio(Principal p,@RequestBody Cardio cardio) {
		final Activity c=this.activityService.addCardioActivityService(p.getName(), cardio);
		return (ResponseEntity<Cardio>) new ResponseEntity((Object)c, HttpStatus.OK);
	}

	@PostMapping(value="/workout")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Workout> addWorkout(Principal p, @RequestBody Workout workout) {
		final Activity c=this.activityService.addWorkoutActivityService(p.getName(), workout);
		return (ResponseEntity<Workout>) new ResponseEntity((Object)c, HttpStatus.OK);
	}


	@DeleteMapping(value ="/{activityId}" , consumes = {"application/json","application/xml" }, produces = {"application/json","application/xml" })
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<Activity> deleteUserActivity(Principal p,
			@PathVariable("activityId") int activityId, @RequestBody Activity a) {
		Optional<Activity> check;
		check=this.activityRepo.findById(activityId);
//				List<Activity> activityList = activityService.getActivity(userName);
				if(!check.isPresent())
				{
					throw new ActivityException("No such activity found", 404);
				}
				a = activityService.deleteActivity(p.getName(), activityId);		
		return new ResponseEntity<Activity>(a, HttpStatus.OK);
	}

}
