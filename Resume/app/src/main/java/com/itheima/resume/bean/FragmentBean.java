package com.itheima.resume.bean;

import java.util.List;

/*
 *  @项目名：  Resume 
 *  @包名：    com.itheima.resume.bean
 *  @文件名:   FragmentBean
 *  @创建者:   Administrator
 *  @创建时间:  2016/12/28 21:43
 *  @描述：    TODO
 */
public class FragmentBean {

    /**
     * picture : ["image/home01.jpg","image/home02.jpg","image/home03.jpg","image/home04.jpg"]
     * id : 1
     * name : 吉屋
     * time : 12周
     * environment : AS+Git
     * responsibility : ["1、我的模块UI的搭建与逻辑处理。","2、推荐部分的二维码扫描、版本更新等。","3、有关第三方接口的实现与消息推送。"]
     * describe : ["1、对项目的功能逻辑实现计算器、能力评估。","2、学习使用许多的开源框架如即时通讯、导航定位等，能够快速运用在手机上。","3、短信对验证信息处理。"]
     * project : 本应用提供了许多楼盘信息如地址、价格等。还可以快速与经纪人进行了解相应信息。该应用共分为四部分首页、管家、消息、我的模块。
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int id;
        private String name;
        private String time;
        private String environment;
        private String project;
        private List<String> picture;
        private List<String> responsibility;
        private List<String> describe;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public List<String> getPicture() {
            return picture;
        }

        public void setPicture(List<String> picture) {
            this.picture = picture;
        }

        public List<String> getResponsibility() {
            return responsibility;
        }

        public void setResponsibility(List<String> responsibility) {
            this.responsibility = responsibility;
        }

        public List<String> getDescribe() {
            return describe;
        }

        public void setDescribe(List<String> describe) {
            this.describe = describe;
        }
    }
}
