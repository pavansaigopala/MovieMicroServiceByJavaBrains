package com.pavan.MicroService.Demo;

public class RatingResources {

	String movieId;
	
	int rating;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public RatingResources(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public RatingResources() {
	}
	
	
	
}
