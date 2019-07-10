package com.bree.api.sendmessage;

import com.aliyuncs.exceptions.ClientException;
import com.bree.common.config.sendmessage.AliyunConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendMessageService {


    public Map<String, Object> SmsVerification(String phone) {
        Map<String, Object> map = new HashMap<>();
        try {
            AliyunConfig.sendSms(phone);
            map.put("code", 200);
            map.put("msg", "短信验证发送成功");
            return map;
        } catch (ClientException e) {
            map.put("code", 300);
            map.put("msg", e.getMessage());
            return map;
        }

    }
}
