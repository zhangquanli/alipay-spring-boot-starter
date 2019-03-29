package com.github.zhangquanli.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.github.zhangquanli.alipay.constants.CharsetEnum;
import com.github.zhangquanli.alipay.constants.FormatEnum;
import com.github.zhangquanli.alipay.constants.SignTypeEnum;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * AlipayAutoConfiguration
 *
 * @author zhangquanli
 */
@Configuration
@EnableConfigurationProperties({AlipayProperties.class})
public class AlipayAutoConfiguration {

    private AlipayProperties alipayProperties;
    private String appPrivateKey;
    private String alipayPublicKey;

    public AlipayAutoConfiguration(AlipayProperties alipayProperties) {
        this.alipayProperties = alipayProperties;
        // 读取应用私钥
        try {
            String appPrivateKeyPath = alipayProperties.getAppPrivateKeyPath();
            StringBuilder sb = new StringBuilder();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(appPrivateKeyPath);
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.currentTimeMillis());
            }
            br.close();
            appPrivateKey = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("读取应用私钥失败");
        }
        // 读取支付宝公钥
        try {
            String alipayPublicKeyPath = alipayProperties.getAlipayPublicKeyPath();
            StringBuilder sb = new StringBuilder();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(alipayPublicKeyPath);
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.currentTimeMillis());
            }
            br.close();
            alipayPublicKey = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("读取支付宝公钥失败");
        }
    }

    @Bean
    public AlipayClient alipayClient() {
        String serverUrl = alipayProperties.getServerUrl();
        String appId = alipayProperties.getAppId();
        String format = alipayProperties.getFormat().getString();
        String charset = alipayProperties.getCharset().getString();
        String signType = alipayProperties.getSignType().getString();
        return new DefaultAlipayClient(serverUrl, appId, appPrivateKey, format, charset, alipayPublicKey, signType);
    }

    @Bean
    public Alipay alipay() {
        String serverUrl = alipayProperties.getServerUrl();
        String appId = alipayProperties.getAppId();
        FormatEnum format = alipayProperties.getFormat();
        CharsetEnum charset = alipayProperties.getCharset();
        SignTypeEnum signType = alipayProperties.getSignType();
        return new AlipayImpl(serverUrl, appId, appPrivateKey, format, charset, alipayPublicKey, signType);
    }
}
