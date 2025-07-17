package com.wusd.skeleton.designpattern.prototype;

import lombok.Data;

import java.io.*;

/**
 * @author wusd
 * @date 2020/1/10 23:01
 */
@Data
public class DeepWeeklyLog implements Serializable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;
    /**
     * 附件类
     */
    @Data
    public static class Attachment implements Serializable {
        private String name;
        public void download() {
            System.out.println("下载附件,文件名为" + name);
        }
    }

    /**
     * 使用序列化技术实现深克隆
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public DeepWeeklyLog deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oss = new ObjectOutputStream(bao);
        oss.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (DeepWeeklyLog) ois.readObject();
    }
    public static class Client {
        public static void main(String[] args) {
            DeepWeeklyLog logPrevious, logNew = null;
            logPrevious = new DeepWeeklyLog();
            Attachment attachment = new Attachment();
            logPrevious.setAttachment(attachment);
            try {
                logNew = logPrevious.deepClone();
                System.out.println(logPrevious == logNew);
                System.out.println(logPrevious.getAttachment() == logNew.getAttachment());
            } catch (Exception ex) {

            }
        }
    }
}
