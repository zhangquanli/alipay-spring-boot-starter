package com.github.zhangquanli.alipay;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 添加此注解，开启支付宝支付
 * 官方文档地址 https://docs.open.alipay.com/api_1/alipay.trade.app.pay/
 *
 * @author zhangquanli
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({AlipayAutoConfiguration.class})
public @interface EnableAlipay {
}
