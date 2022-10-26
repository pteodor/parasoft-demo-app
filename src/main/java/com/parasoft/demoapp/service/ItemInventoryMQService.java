package com.parasoft.demoapp.service;

import com.parasoft.demoapp.config.activemq.ActiveMQConfig;
import com.parasoft.demoapp.dto.InventoryOperationRequestMessageDTO;
import com.parasoft.demoapp.dto.InventoryOperationResultMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class ItemInventoryMQService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendToRequestQueue(InventoryOperationRequestMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(ActiveMQConfig.inventoryRequestActiveMqQueue, message);
    }

    public void sendToResponseQueue(InventoryOperationResultMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(ActiveMQConfig.inventoryResponseActiveMqQueue, message);
    }

    public void send(Destination destination, InventoryOperationResultMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void send(Destination destination, InventoryOperationRequestMessageDTO message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
