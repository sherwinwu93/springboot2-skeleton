package com.wusd.skeleton.designpattern.prototype;

import lombok.Data;

/**
 * @author wusd
 * @date 2020/1/10 17:07
 */
@Data
public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;
    public WeeklyLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static class Client {
        public static void main(String[] args) {
            WeeklyLog logPrevious = new WeeklyLog();
            logPrevious.setName("张无忌");
            logPrevious.setDate("第12周");
            logPrevious.setContent("这周工作很忙,每天加班!");
            print(logPrevious);

            WeeklyLog logNew;
            logNew = logPrevious.clone();
            logNew.setDate("第13周");
            print(logNew);
        }
        private static void print(WeeklyLog log) {
            System.out.println("***周报***");
            System.out.println("周次:" + log.getDate());
            System.out.println("姓名:" + log.getName());
            System.out.println("内容:" + log.getContent());

        }
    }
}
