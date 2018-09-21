/**
 * 
 */
package com.example.dabuff.objectdetectionadvanced.voicedetect.iseresult;

import com.example.dabuff.objectdetectionadvanced.voicedetect.iseresult.entity.ScoreLevel;
import com.example.dabuff.objectdetectionadvanced.voicedetect.iseresult.util.ResultFormatUtil;

/**
 * <p>Title: ReadSyllableResult</p>
 * <p>Description: 中文单字评测结果</p>
 * <p>Company: www.iflytek.com</p>
 * @author iflytek
 * @date 2015年1月12日 下午5:03:14
 */
public class ReadSyllableResult extends Result {
	
	public ReadSyllableResult() {
		language = "cn";
		category = "read_syllable";
	}

	ScoreLevel scoreLevel = new ScoreLevel();
	String level = scoreLevel.getScoreLevel(total_score);
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[总体结果]\n")
				.append("评测内容：" + content + "\n")
				.append("朗读时长：" + time_len + "\n")
				.append("总分：" + total_score + "\n")
				.append("朗读水平：" + level + "\n\n")
				.append("[朗读详情]").append(ResultFormatUtil.formatDetails_CN(sentences));
		
		return buffer.toString();
	}
}
