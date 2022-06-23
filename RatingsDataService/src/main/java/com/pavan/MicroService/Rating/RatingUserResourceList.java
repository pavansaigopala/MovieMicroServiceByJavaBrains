package com.pavan.MicroService.Rating;

import java.util.List;

public class RatingUserResourceList {

	private List<RatingResources> rur;

	public RatingUserResourceList() {
	}

	public RatingUserResourceList(List<RatingResources> rur) {
		this.rur = rur;
	}

	public List<RatingResources> getRur() {
		return rur;
	}

	public void setRur(List<RatingResources> rur) {
		this.rur = rur;
	}

}
