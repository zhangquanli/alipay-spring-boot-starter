package com.github.zhangquanli.alipay.constants;

/**
 * Format
 *
 * @author zhangquanli
 */
public enum FormatEnum {
    /**
     * json
     */
    JSON("json");

    private String string;

    FormatEnum(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
