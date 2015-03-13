package com.saurabh.test.robot;

import com.saurabh.test.beans.RobotStatus;
import com.saurabh.test.utility.CommonProcess;

/**
 * @author saurabh
 *
 */
public class RobotImpl extends CommonProcess implements Robot {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saurabh.test.robot.Robot#startRobot()
	 */
	@Override
	public RobotStatus startRobot() {
		RobotStatus status = robotStartWork(0, 0);
		displayStatusMessage(status);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saurabh.test.robot.Robot#startRobot(double)
	 */
	@Override
	public RobotStatus startRobot(double warkingDistance) {
		displayMessage("Total distance to be covered: " + warkingDistance
				+ "Km");
		RobotStatus status = robotStartWork(warkingDistance, 0);
		displayStatusMessage(status);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saurabh.test.robot.Robot#startRobot(int)
	 */
	@Override
	public RobotStatus startRobot(int weight) {
		displayMessage("Total weight to be picked: " + weight + "Kg");
		if (weight > MAX_WEIGHT) {
			return displayOverWeightMessages();
		}
		RobotStatus status = robotStartWork(0, weight);
		displayStatusMessage(status);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saurabh.test.robot.Robot#startRobot(double, int)
	 */
	@Override
	public RobotStatus startRobot(double warkingDistance, int weight) {
		displayMessage("Total weight to be picked: " + weight + "Kg");
		if (weight > MAX_WEIGHT) {
			return displayOverWeightMessages();
		}
		displayMessage("Total distance to be covered: " + warkingDistance
				+ "Km");
		RobotStatus status = robotStartWork(warkingDistance, weight);
		displayStatusMessage(status);
		return status;
	}

	/**
	 * @param distanceToCover
	 * @param weight
	 * @return
	 */
	private RobotStatus robotStartWork(double distanceToCover, int weight) {
		double percentage = 0;
		double distanceToWalk = TOTAL_METER;
		if (distanceToCover > meterConvertToKm(TOTAL_METER)) {
			distanceToWalk = TOTAL_METER;
		} else if (distanceToCover > 0) {
			distanceToWalk = kmConvertToMeter(distanceToCover);
		}
		boolean isRedLightOn = false;

		double addonPercentageForWeight = (weight * 2);
		double distanceWalked = 1;
		return recursiveWalkRobot(distanceWalked, distanceToWalk, percentage,
				isRedLightOn, addonPercentageForWeight, distanceToCover);
	}

	/**
	 * @param distanceWalked
	 * @param distanceToWalk
	 * @param percentage
	 * @param isRedLightOn
	 * @param addonPercentageForWeight
	 * @param distanceToCover
	 * @return
	 */
	private RobotStatus walkRobot(double distanceWalked, double distanceToWalk,
			double percentage, boolean isRedLightOn,
			double addonPercentageForWeight, double distanceToCover) {
		for (distanceWalked = 1; distanceWalked <= distanceToWalk; distanceWalked++) {
			percentage = (((TOTAL_METER - distanceWalked) / TOTAL_METER) * 100);
			percentage = percentage
					- (meterConvertToKm(distanceWalked) * addonPercentageForWeight);
			if (distanceWalked % KM_TO_METER == 0) {
				displayMessage("Distance covered: " + distanceWalked
						/ KM_TO_METER + "Km");
			}

			if (percentage < BATTERY_LOW_MARK && !isRedLightOn) {
				displayMessage("Head red light on");
				isRedLightOn = true;
			}

			if (distanceToWalk == distanceWalked || percentage < .01) {
				break;
			}
		}
		return new RobotStatus(meterConvertToKm(distanceWalked),
				Math.round(percentage), getdistanceNotCovered(distanceToCover,
						distanceWalked));
	}

	/**
	 * @param distanceWalked
	 * @param distanceToWalk
	 * @param percentage
	 * @param isRedLightOn
	 * @param addonPercentageForWeight
	 * @param distanceToCover
	 * @return
	 */
	private RobotStatus recursiveWalkRobot(double distanceWalked,
			double distanceToWalk, double percentage, boolean isRedLightOn,
			double addonPercentageForWeight, double distanceToCover) {

		percentage = (((TOTAL_METER - distanceWalked) / TOTAL_METER) * 100);
		percentage = percentage
				- (meterConvertToKm(distanceWalked) * addonPercentageForWeight);
		if (distanceWalked % KM_TO_METER == 0) {
			displayMessage("Distance covered: " + distanceWalked / KM_TO_METER
					+ "Km");
		}

		if (percentage < BATTERY_LOW_MARK && !isRedLightOn) {
			displayMessage("Head red light on");
			isRedLightOn = true;
		}

		if (distanceToWalk == distanceWalked || percentage < .01) {
			return new RobotStatus(
					CommonProcess.meterConvertToKm(distanceWalked),
					Math.round(percentage),
					CommonProcess.getdistanceNotCovered(distanceToCover,
							distanceWalked));
		} else {
			return recursiveWalkRobot(distanceWalked + 1, distanceToWalk,
					percentage, isRedLightOn, addonPercentageForWeight,
					distanceToCover);
		}

	}

}
