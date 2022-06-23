package com.pavan.MicroService.Demo;

import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfoServiceResource {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieInfoServiceResource.class);

	@GetMapping(value="{movieId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MovieInfo getMovieInfo(@PathVariable("movieId") String id)
	{
		logger.error("hello");
		logger.info("movie id is :"+id);
		logger.info("movie name is : Transformer");
		System.out.println("movie name is : Transformer--- this is Sysout");
		return new MovieInfo(id,"Transformer");
	}
}
