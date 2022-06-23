
package com.pavan.MicroService.Rating;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingDataServiceController {

	
	@RequestMapping("user/{userId}")
	public RatingUserResourceList getRatingUserList(@PathVariable("userId") String userId)
	{
		List<RatingResources> ratingsList = Arrays.asList(
				new RatingResources("5678", 4),
				new RatingResources("1234", 5)
				);
		
		return new RatingUserResourceList(ratingsList);
	}
	
	@RequestMapping("{movieId}")
	public RatingResources getRating(@PathVariable("movieId") String movieId)
	{
		return new RatingResources(movieId, 4);
		/*
		 * return Collections.singletonList( new RatingResources(id, 4) );
		 */
		
	}
	
	
}
