package com.wusd.skeleton.designpattern.prototype;

import lombok.Data;

/**
 * @author wusd
 * @date 2020/1/10 17:48
 */
@Data
public class ShallowWeeklyLog implements Cloneable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    @Override
    protected ShallowWeeklyLog clone() {
        Object obj = null;
        try {
            //jdk自带实现潜克隆
            obj = super.clone();
            return (ShallowWeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 附件类
     */
    @Data
    public static class Attachment {
        private String name;
    }

    public static class Client {
        public static void main(String[] args) {
            ShallowWeeklyLog logPrevious, logNew;
            logPrevious = new ShallowWeeklyLog();
            Attachment attachment = new Attachment();
            logPrevious.setAttachment(attachment);
            logNew = logPrevious.clone();
            System.out.println("周报是否相同? " + (logPrevious == logNew));
            System.out.println("附件是否相同? " + (logPrevious.getAttachment() == logNew.getAttachment()));
        }
    }
}
