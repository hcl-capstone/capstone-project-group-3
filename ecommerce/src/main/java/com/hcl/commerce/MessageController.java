package com.hcl.commerce;


import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.entity.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
public class MessageController {
    @Autowired
    private RabbitTemplate template;
    public MessageController(RabbitTemplate rabbitTemplate) {
        this.template = rabbitTemplate;
    }
    public void inventoryStatus(Product product, int count) {

        System.out.println("\nSending message...");
        InventoryDTO inventoryDTO=new InventoryDTO(product.getProductId(), count, "low inventory" );
        //System.out.println(inventoryDTO);
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUNDING_KEY, inventoryDTO);
   }
}
