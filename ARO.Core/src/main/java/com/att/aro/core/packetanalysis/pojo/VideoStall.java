/*
 *  Copyright 2017 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.att.aro.core.packetanalysis.pojo;

import com.att.aro.core.videoanalysis.pojo.VideoEvent;

public class VideoStall {
	private double duration;
	private double stallStartTimeStamp;
	private double stallEndTimeStamp;
	private VideoEvent segmentTryingToPlay;
	private String stallState;
	
	@Override
	public String toString() {
		return new String("start:"+stallStartTimeStamp+", end: "+stallEndTimeStamp);
	}
	
	public VideoStall(double stallStartTimeStamp){
		this.stallStartTimeStamp = stallStartTimeStamp;
	//	this.stallEndTimeStamp = duration + stallStartTimeStamp;
	}

	public String getStallState() {
		return stallState;
	}

	public void setStallState(String stallState) {
		this.stallState = stallState;
	}

	public double getDuration() {
		return duration;
	}

	public double getStallStartTimeStamp() {
		return stallStartTimeStamp;
	}

	public double getStallEndTimeStamp() {
		return stallEndTimeStamp;
	}
	
	public void setStallEndTimeStamp(double stallEndTimeStamp){
		this.stallEndTimeStamp = stallEndTimeStamp;
		duration = this.stallEndTimeStamp - this.stallStartTimeStamp;
	}

	public void setSegmentTryingToPlay(VideoEvent chunkPlaying) {
		this.segmentTryingToPlay = chunkPlaying;
	}

	public VideoEvent getSegmentTryingToPlay() {
		return segmentTryingToPlay;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		VideoStall other = (VideoStall) obj;
		if (Double.doubleToLongBits(other.getDuration()) != Double.doubleToLongBits(duration)) {
			return false;
		}
		if (Double.doubleToLongBits(other.getStallEndTimeStamp()) != Double.doubleToLongBits(stallEndTimeStamp)
				|| Double.doubleToLongBits(other.getStallStartTimeStamp()) != Double
						.doubleToLongBits(stallStartTimeStamp)) {
			return false;
		}
		if (!other.getStallState().equals(stallState)) {
			return false;
		}
		if (!other.getSegmentTryingToPlay().equals(segmentTryingToPlay)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stallEndTimeStamp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(stallStartTimeStamp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stallState.hashCode();
		result = prime * result + segmentTryingToPlay.hashCode();
		return result;
	}
}
