package com.krishnan.balaji.practice.util;

import java.util.Comparator;

import com.krishnan.balaji.practice.model.a.BusStop;

public class BusStopTimeSort implements Comparator<BusStop> {

	@Override
	public int compare(BusStop o1, BusStop o2) {
		if (o1.getDay() < o2.getDay())
			return -1;
		else if (o1.getDay() == o2.getDay()) {
			if (o1.getTime().isBefore(o2.getTime()))
				return -1;
			else
				return 1;
		} else
			return 1;
	}

}
