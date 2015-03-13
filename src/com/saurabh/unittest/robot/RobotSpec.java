package com.saurabh.unittest.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.saurabh.test.beans.RobotStatus;
import com.saurabh.test.robot.Robot;
import com.saurabh.test.robot.RobotImpl;

public class RobotSpec {

	Robot robot = new RobotImpl();

	/**
	 * 
	 */
	@Test
	public void testStartRobot() {
		RobotStatus status = robot.startRobot();
		System.out.println();
		assertEquals(0, Double.compare(5, status.getDistanceWalked()));
	}
	
	/**
	 * 
	 */
	@Test
	public void testStartRobotWithDistance() {
		RobotStatus status = robot.startRobot(3.5d);
		System.out.println();
		assertEquals(0, Double.compare(30, status.getPercentageLeft()));
	}
	
	/**
	 * 
	 */
	@Test
	public void testStartRobotWithWeight() {
		RobotStatus status = robot.startRobot(12);
		System.out.println();
		assertEquals(0, Double.compare(0, status.getDistanceWalked()));
	}
	
	/**
	 * 
	 */
	@Test
	public void testStartRobotWithDistanceWithWeight() {
		RobotStatus status = robot.startRobot(2, 3);
		System.out.println();
		assertEquals(0, Double.compare(48, status.getPercentageLeft()));
	}
}
