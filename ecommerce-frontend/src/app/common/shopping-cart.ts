import { ProductService } from "../services/product.service";
import { Invoice } from "./invoice";
import { Product } from "./product";

export class ShoppingCart{
    cartId?: number;
    productId?: number; 
    productQuantity?: number; 
    invoiceId?: number; 
    productCost?: number; 
    product?: Product; 
    cartPrice? :number;
}
