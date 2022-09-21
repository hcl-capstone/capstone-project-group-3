package com.hcl.commerce;

import com.hcl.commerce.InventoryDTO.InventoryDTO;
import com.hcl.commerce.controller.ProductController;
import com.hcl.commerce.dto.product.ProductAddDTO;
import com.hcl.commerce.entity.Product;
import com.hcl.commerce.service.product.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Component
public class Receiver {
	@Autowired
	ProductService productService;
	@Autowired
	ProductController productController;

	@RabbitListener(queues = MQConfig.QUEUE)

	public void receiveMessage(InventoryDTO inventoryDTO) {
        System.out.println("[Received message from RabbitMQ]: Product ID-->" +inventoryDTO.getProductId()+ " has " + inventoryDTO.getMessage() +" where stock-count is "+inventoryDTO.getStock_count());
        ProductAddDTO dto=new ProductAddDTO();
        productController.updateProductInventory(dto,inventoryDTO);
        System.out.println("Updated Inventory for product ID: " + inventoryDTO.getProductId());
    }
}
