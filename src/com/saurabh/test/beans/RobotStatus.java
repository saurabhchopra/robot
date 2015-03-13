package com.saurabh.test.beans;

/**
 * @author saurabh
 *
 */
public class RobotStatus {
	private double distanceWalked;
	private double percentageLeft;
	private double distanceNotCovered;

	/**
	 * @param distanceWalked
	 * @param percentageLeft
	 * @param distanceNotCovered
	 */
	public RobotStatus(double distanceWalked, double percentageLeft,
			double distanceNotCovered) {
		super();
		this.distanceWalked = distanceWalked;
		this.percentageLeft = percentageLeft;
		this.distanceNotCovered = distanceNotCovered;
	}

	/**
	 * @return the distanceWalked
	 */
	public double getDistanceWalked() {
		return distanceWalked;
	}

	/**
	 * @param distanceWalked
	 *            the distanceWalked to set
	 */
	public void setDistanceWalked(double distanceWalked) {
		this.distanceWalked = distanceWalked;
	}

	/**
	 * @return the percentageLeft
	 */
	public double getPercentageLeft() {
		return percentageLeft;
	}

	/**
	 * @param percentageLeft
	 *            the percentageLeft to set
	 */
	public void setPercentageLeft(double percentageLeft) {
		this.percentageLeft = percentageLeft;
	}

	/**
	 * @return the distanceNotCovered
	 */
	public double getDistanceNotCovered() {
		return distanceNotCovered;
	}

	/**
	 * @param distanceNotCovered
	 *            the distanceNotCovered to set
	 */
	public void setDistanceNotCovered(double distanceNotCovered) {
		this.distanceNotCovered = distanceNotCovered;
	}
}
