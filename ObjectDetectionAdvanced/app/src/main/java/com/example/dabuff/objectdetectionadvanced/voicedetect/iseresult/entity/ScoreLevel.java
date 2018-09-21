package com.example.dabuff.objectdetectionadvanced.voicedetect.iseresult.entity;

public class ScoreLevel{
    private final String score_level_first = "优";
    private final String score_level_second = "良";
    private final String score_level_third = "中";
    private final String score_level_forth = "差";
    private final String score_level_fifth = "很差";

    public String resultlevel;

    public String getScoreLevel(float score){
        if(score >= 4.3){
            resultlevel = score_level_first;
        }else if(score >= 3.5){
            resultlevel = score_level_second;
        }else if(score >= 2.5){
            resultlevel = score_level_third;
        }else if(score >= 1.5){
            resultlevel = score_level_forth;
        }else if(score >= 0){
            resultlevel = score_level_fifth;
        }

        return resultlevel;
    }


}
