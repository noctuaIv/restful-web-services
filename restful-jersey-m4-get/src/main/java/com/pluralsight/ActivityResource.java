package com.pluralsight;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities") //http:localhost:8080/exercise-services/webapi/activites
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}") //http:localhost:8080/exercise-services/webapi/activites/1234
	public Activity getActivity(@PathParam ("activityId") String activityId) {
		return activityRepository.findActivity(activityId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user") //http:localhost:8080/exercise-services/webapi/activites/1234/user
	public User getActivityUser(@PathParam ("activityId") String activityId) {
		
		Activity activity = activityRepository.findActivity(activityId);
		User user = activity.getUser();
		return user;
		//return activityRepository.findActivity(activityId).getUser();
	}
	
}
