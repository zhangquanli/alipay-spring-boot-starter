package com.github.zhangquanli.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.github.zhangquanli.alipay.constants.CharsetEnum;
import com.github.zhangquanli.alipay.constants.FormatEnum;
import com.github.zhangquanli.alipay.constants.SignTypeEnum;

import java.util.Map;

/**
 * AlipayImpl
 *
 * @author zhangquanli
 */
public class AlipayImpl implements Alipay {

    private String serverUrl;
    private String appId;
    private String appPrivateKey;
    private FormatEnum format;
    private CharsetEnum charset;
    private String alipayPublicKey;
    private SignTypeEnum signType;

    public AlipayImpl(
            String serverUrl,
            String appId,
            String appPrivateKey,
            FormatEnum format,
            CharsetEnum charset,
            String alipayPublicKey,
            SignTypeEnum signType
    ) {
        this.serverUrl = serverUrl;
        this.appId = appId;
        this.appPrivateKey = appPrivateKey;
        this.format = format;
        this.charset = charset;
        this.alipayPublicKey = alipayPublicKey;
        this.signType = signType;
    }

    @Override
    public boolean validateSignature(Map<String, String> data) throws AlipayApiException {
        return AlipaySignature.rsaCheckV1(data, alipayPublicKey, charset.getString(), signType.getString());
    }
}
