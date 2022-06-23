package com.pavan.MicroService.Demo;

import java.util.List;

public class MovieInfoList {

	private List<MovieInfo> mil;

	public List<MovieInfo> getMil() {
		return mil;
	}

	public void setMil(List<MovieInfo> mil) {
		this.mil = mil;
	}

	public MovieInfoList(List<MovieInfo> mil) {
		super();
		this.mil = mil;
	}

	public MovieInfoList() {
	}

}
