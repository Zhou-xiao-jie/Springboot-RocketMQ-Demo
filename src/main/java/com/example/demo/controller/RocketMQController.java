package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.MQProducerService;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RocketMQController
 * @Description: TODO
 * @author: zhouxiaojie
 * @date: 2021/11/26 20:14
 * @Version: V1.0.0
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketMQController {

    @Autowired
    private MQProducerService mqProducerService;

    @GetMapping("/send")
    public void send() {
        mqProducerService.send("哈哈哈，你好啊");
    }

    @GetMapping("/sendTag")
    public String sendTag() {
        SendResult sendResult = mqProducerService.sendTagMsg("带有tag的字符消息");
        return JSONObject.toJSONString(sendResult);
    }

}

