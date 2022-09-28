package com.hcl.commerce.InventoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class InventoryDTO {
    private Long productId;
    private int stock_count;
    private String message;
}
