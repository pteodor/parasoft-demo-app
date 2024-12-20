package com.parasoft.demoapp.service;

import com.parasoft.demoapp.config.MQConfig;
import com.parasoft.demoapp.config.activemq.ActiveMQConfig;
import com.parasoft.demoapp.config.kafka.KafkaConfig;
import com.parasoft.demoapp.config.rabbitmq.RabbitMQConfig;
import com.parasoft.demoapp.dto.InventoryOperationResultMessageDTO;
import com.parasoft.demoapp.model.global.preferences.MqType;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

import static com.parasoft.demoapp.model.global.preferences.MqType.ACTIVE_MQ;
import static com.parasoft.demoapp.model.global.preferences.MqType.KAFKA;
import static org.springframework.amqp.core.Address.AMQ_RABBITMQ_REPLY_TO;

@Slf4j
@Service
public class ItemInventoryMQService {
}
