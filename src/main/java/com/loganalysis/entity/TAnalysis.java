package com.loganalysis.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: wangzhenze
 * @Description:
 * @Date: Created in 2020/3/14 10:03 下午
 */
@Component
public class TAnalysis {
    private Integer id;
    private String videoName;//视频名称
    private String city;//ip地址
    private String createTime;//日志时间
    private String videoDuration;//视频时长
    private String playPercentage;//视频百分比
    private String platform;//播放平台
    private Integer isComment;//是否评论
    private Integer isForward;//转发
    private Integer isLike;//点赞

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getPlayPercentage() {
        return playPercentage;
    }

    public void setPlayPercentage(String playPercentage) {
        this.playPercentage = playPercentage;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsForward() {
        return isForward;
    }

    public void setIsForward(Integer isForward) {
        this.isForward = isForward;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }
}
