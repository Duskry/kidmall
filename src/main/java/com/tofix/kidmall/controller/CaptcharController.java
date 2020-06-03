package com.tofix.kidmall.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.map.MapUtil;
import com.tofix.kidmall.common.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duskry ren
 * @description 验证码
 * @date 2020/6/2
 **/
@RestController
@RequestMapping("/captchar")
@Api(tags = "验证码获取")
public class CaptcharController {
    Logger logger = LoggerFactory.getLogger(CaptcharController.class);

    /**
     * 直线干扰的验证码
     *
     * @return
     */
    @GetMapping("/line")
    @ApiOperation("直线干扰的验证码")
    CommonResult getLineCaptchar(@RequestParam(defaultValue = "200") Integer width,
                                 @RequestParam(defaultValue = "100") Integer height) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(width, height, 4, 15);
        String img = lineCaptcha.getImageBase64();
        String code = lineCaptcha.getCode();
        Map<Object, Object> map = MapUtil.of(new String[][]{
                {"captcha", "data:image/png;base64," + img},
                {"code", code},
        });
        /*
            验证码 校验交给本地 code 一起传给客户端
         */
        return CommonResult.success(map);
    }
}
