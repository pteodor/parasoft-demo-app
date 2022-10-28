package com.parasoft.demoapp.service;

import com.parasoft.demoapp.config.activemq.ActiveMQConfig;
import com.parasoft.demoapp.dto.*;
import com.parasoft.demoapp.model.industry.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.List;

@Component
public class OrderMQService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendToApprover(OrderMQMessageDTO messageDto) {
        jmsMessagingTemplate.convertAndSend(ActiveMQConfig.TOPIC_ORDER_APPROVER, messageDto);
    }

    public void sendToPurchaser(OrderMQMessageDTO messageDto) {
        jmsMessagingTemplate.convertAndSend(ActiveMQConfig.TOPIC_ORDER_PURCHASER, messageDto);
    }

    public void sendToInventoryRequestQueue(InventoryOperation operation, String orderNumber, List<OrderItemEntity> orderItems) {
        sendToInventoryRequestQueue(operation, orderNumber, orderItems, null);
    }

    public void sendToInventoryRequestQueue(InventoryOperation operation, String orderNumber, List<OrderItemEntity> orderItems, String info) {
        sendToInventoryRequestQueue(new InventoryOperationRequestMessageDTO(operation, orderNumber, InventoryInfoDTO.convertFrom(orderItems), info));
    }

    public void sendToInventoryRequestQueue(InventoryOperationRequestMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(ActiveMQConfig.inventoryRequestActiveMqQueue, message);
    }

    public void send(Destination destination, InventoryOperationRequestMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
