package com.pavan.MicroService.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogServices {


	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Builder builder;

	@RequestMapping("/{userId}")
	public List<Catalog> getMovieDetails(@PathVariable("userId") String userId) {

		/* Overall calling structure */

		// 1. Get Ratings Data from RatingsDataService List<RatingResources>

		/*
		 * 2. Get MovieInfo from MovieInfoService // Here we are for looping the ratings
		 * Data and calling picking specific movie Id and calling the MovieInfoService
		 * using RestTemplate
		 */

		// 3. Accumulate all of them together return new Catalog()

		// Here we are Hardcoding the Rest Template
		// Lets singletonize the RestTemplate Instance
		/*
		 * 
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 */

		RatingUserResourceList ratingsData = restTemplate.getForObject("http://RATING-DATA-SERVICE/rating/user/"+userId,
				RatingUserResourceList.class);

		List<RatingResources> ratingsData1 = ratingsData.getRur();

		return ratingsData1.stream().map(rd -> {
			MovieInfo movieInfo = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movieinfo/" + rd.getMovieId() + "/",
					MovieInfo.class);

			return new Catalog(movieInfo.getMovieName(), "super movie", rd.getRating());
		}).collect(Collectors.toList());
		
		
		
		

		// Instread of creating RestTemplate we gone try WebClient (Reactive way of
		// calling the server)
		// This is actually Asynchronous way to call the client
		// Have an option not to way for the Response

		// Programmatically we user WebClient and user Builder method to build WebClient
		// for use
		// Lets Make it Singleton
		/*
		 * 
		 * Builder builder = WebClient.builder();
		 * 
		 */

		/*
		 * RatingResources ratingsData = restTemplate
		 * .getForObject("http://localhost:8083/rating/foo", RatingResources.class);
		 */

		// WebCLient Implementation Demo
		/*
		 * RatingResources ratingsData =
		 * builder.build().get().uri("http://localhost:8083/rating/foo").retrieve()
		 * .bodyToMono(RatingResources.class).block();
		 * 
		 * List<RatingResources> ratingsData1 = Arrays.asList(ratingsData);
		 * 
		 * return ratingsData1.stream().map(rd -> {
		 * 
		 * 
		 * MovieInfo movieInfo =
		 * restTemplate.getForObject("http://localhost:8082/movieinfo/" +
		 * rd.getMovieId() + "/", MovieInfo.class);
		 * 
		 * 
		 * MovieInfo movieInfo =
		 * builder.build().get().uri("http://localhost:8082/movieinfo/" +
		 * rd.getMovieId()) .retrieve().bodyToMono(MovieInfo.class).block();
		 * 
		 * return new Catalog(movieInfo.getMovieName(), "Directed by Michael Bay",
		 * rd.getRating()); }).collect(Collectors.toList());
		 * 
		 */

	}

}
