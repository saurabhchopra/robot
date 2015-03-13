package com.saurabh.test.utility;

import com.saurabh.test.beans.RobotStatus;

public class CommonProcess {
	public static final double TOTAL_METER = 5000;
	public static final double BATTERY_LOW_MARK = 15;
	public static final double MAX_WEIGHT = 10;
	public static final double KM_TO_METER = 1000;

	/**
	 * @param km
	 * @return
	 */
	public static double kmConvertToMeter(double km) {
		return km * KM_TO_METER;
	}

	/**
	 * @param meter
	 * @return
	 */
	public static double meterConvertToKm(double meter) {
		return meter / KM_TO_METER;
	}

	/**
	 * @param distanceToCover
	 * @param distanceWalked
	 * @return
	 */
	public static double getdistanceNotCovered(double distanceToCover,
			double distanceWalked) {
		return distanceToCover - meterConvertToKm(distanceWalked);
	}

	/**
	 * @param message
	 */
	public static void displayMessage(String message) {
		System.out.println(message);
	}

	/**
	 * @return
	 */
	public static RobotStatus displayOverWeightMessages() {
		displayMessage("Chest LED on");
		displayMessage("Overweight");
		return new RobotStatus(0, 0, 0);
	}

	/**
	 * @param status
	 */
	public static void displayStatusMessage(RobotStatus status) {
		displayMessage("Total distance covered: " + status.getDistanceWalked()
				+ "Km");
		displayMessage("Battery left: " + status.getPercentageLeft() + "%");
		if (status.getDistanceNotCovered() > 0) {
			displayMessage("Distance uncovered due to no battery: "
					+ status.getDistanceNotCovered() + "km");
		}
	}
}
