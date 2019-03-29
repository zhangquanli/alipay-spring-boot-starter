package com.github.zhangquanli.alipay;

import com.github.zhangquanli.alipay.constants.CharsetEnum;
import com.github.zhangquanli.alipay.constants.FormatEnum;
import com.github.zhangquanli.alipay.constants.SignTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AlipayProperties
 *
 * @author zhangquanli
 */
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {

    /**
     * 服务地址
     */
    private String serverUrl;
    /**
     * 应用编号
     */
    private String appId;
    /**
     * 应用私钥路径
     */
    private String appPrivateKeyPath;
    /**
     * 传输类型
     */
    private FormatEnum format = FormatEnum.JSON;
    /**
     * 字符集编码
     */
    private CharsetEnum charset = CharsetEnum.UTF8;
    /**
     * 支付宝公钥路径
     */
    private String alipayPublicKeyPath;
    /**
     * 签名类型
     */
    private SignTypeEnum signType = SignTypeEnum.RSA2;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPrivateKeyPath() {
        return appPrivateKeyPath;
    }

    public void setAppPrivateKeyPath(String appPrivateKeyPath) {
        this.appPrivateKeyPath = appPrivateKeyPath;
    }

    public FormatEnum getFormat() {
        return format;
    }

    public void setFormat(FormatEnum format) {
        this.format = format;
    }

    public CharsetEnum getCharset() {
        return charset;
    }

    public void setCharset(CharsetEnum charset) {
        this.charset = charset;
    }

    public String getAlipayPublicKeyPath() {
        return alipayPublicKeyPath;
    }

    public void setAlipayPublicKeyPath(String alipayPublicKeyPath) {
        this.alipayPublicKeyPath = alipayPublicKeyPath;
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
        this.signType = signType;
    }
}
