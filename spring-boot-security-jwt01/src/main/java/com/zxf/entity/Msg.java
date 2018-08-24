package com.zxf.entity;

import lombok.Data;

/**
 * @author zxf
 * @date 2018/8/23 10:36
 */
@Data
public class Msg {

    private String title;

    private String content;

    private String extraInfo;

    public Msg() {
    }

    public Msg(String title, String content, String extraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }
}
