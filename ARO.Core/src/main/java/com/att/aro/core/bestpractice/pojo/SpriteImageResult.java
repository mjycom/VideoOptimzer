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
package com.att.aro.core.bestpractice.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SpriteImageResult extends AbstractBestPracticeResult {
	private List<SpriteImageEntry> analysisResults = null;
	@JsonIgnore
	private String exportAllNumberOfSpriteFiles;
	
	@Override
	public BestPracticeType getBestPracticeType() {
		return BestPracticeType.SPRITEIMAGE;
	}
	public List<SpriteImageEntry> getAnalysisResults() {
		return analysisResults;
	}
	public void setAnalysisResults(List<SpriteImageEntry> analysisResults) {
		this.analysisResults = analysisResults;
	}
	public String getExportAllNumberOfSpriteFiles() {
		return exportAllNumberOfSpriteFiles;
	}
	public void setExportAllNumberOfSpriteFiles(String exportAllNumberOfSpriteFiles) {
		this.exportAllNumberOfSpriteFiles = exportAllNumberOfSpriteFiles;
	}
	
	public int getErrorCount() {
		return analysisResults != null ? analysisResults.size() : 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		SpriteImageResult other = (SpriteImageResult) obj;
		if (!other.getAnalysisResults().containsAll(analysisResults)) {
			return false;
		}
		if ((!other.getBestPracticeDescription().trim().equals(getBestPracticeDescription().trim()))
				|| getResultType() != other.getResultType()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (SpriteImageEntry entry : analysisResults) {
			result = prime * result + entry.hashCode();
		}
		result = prime * result + getBestPracticeDescription().hashCode();
		result = prime * result + getBestPracticeType().hashCode();
		return result;
	}
}
