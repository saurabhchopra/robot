package com.saurabh.test.robot;

import com.saurabh.test.beans.RobotStatus;

public interface Robot {
	/**
	 * This method is used to start the robot
	 * 
	 * @return
	 */
	public RobotStatus startRobot();

	/**
	 * This method is used to start the robot with the given distance
	 * 
	 * @param warkingDistance
	 * @return
	 */
	public RobotStatus startRobot(double warkingDistance);

	/**
	 * This method is used to start the robot with the given weight
	 * 
	 * @param weight
	 * @return
	 */
	public RobotStatus startRobot(int weight);

	/**
	 * This method is used to start the robot with the given distance and weight
	 * 
	 * @param warkingDistance
	 * @param weight
	 * @return
	 */
	public RobotStatus startRobot(double warkingDistance, int weight);
}
