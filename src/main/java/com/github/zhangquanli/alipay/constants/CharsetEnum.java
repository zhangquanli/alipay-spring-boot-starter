package com.github.zhangquanli.alipay.constants;

/**
 * CharsetEnum
 *
 * @author zhangquanli
 */
public enum CharsetEnum {
    /**
     * UTF-8
     */
    UTF8("UTF-8"),
    /**
     * GBK
     */
    GBK("GBK");

    private String string;

    CharsetEnum(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
