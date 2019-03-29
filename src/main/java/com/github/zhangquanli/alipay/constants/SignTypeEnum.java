package com.github.zhangquanli.alipay.constants;

/**
 * SignType
 *
 * @author zhangquanli
 */
public enum SignTypeEnum {
    /**
     * RSA1
     */
    RSA1("RSA1"),
    /**
     * RSA2
     */
    RSA2("RSA2");

    private String string;

    SignTypeEnum(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
