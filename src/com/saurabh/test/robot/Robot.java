package com.saurabh.test.robot;

import com.saurabh.test.beans.RobotStatus;

public interface Robot {
	/**
	 * @return
	 */
	public RobotStatus startRobot();

	/**
	 * @param warkingDistance
	 * @return
	 */
	public RobotStatus startRobot(double warkingDistance);

	/**
	 * @param weight
	 * @return
	 */
	public RobotStatus startRobot(int weight);

	/**
	 * @param warkingDistance
	 * @param weight
	 * @return
	 */
	public RobotStatus startRobot(double warkingDistance, int weight);
}
