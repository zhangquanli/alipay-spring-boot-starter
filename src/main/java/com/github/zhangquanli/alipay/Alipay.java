package com.github.zhangquanli.alipay;

import com.alipay.api.AlipayApiException;

import java.util.Map;

/**
 * Alipay
 *
 * @author zhangquanli
 */
public interface Alipay {

    /**
     * 校验签名
     *
     * @param data 待校验的数据
     * @return 签名是否校验通过
     * @throws AlipayApiException 发生错误，抛出异常
     */
    boolean validateSignature(Map<String, String> data) throws AlipayApiException;
}
