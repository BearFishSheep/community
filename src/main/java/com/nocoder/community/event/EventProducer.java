package com.nocoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nocoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {
    @Autowired
    @SuppressWarnings("all")
    private KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Event event) {
        // 将事件发布到指定的主题，这里卡我半天！！！写成了toJSON
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }
}
