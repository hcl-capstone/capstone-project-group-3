import { Invoice } from "./invoice";
import { Product } from "./product";

export class ShoppingCart{
    productId?: number; 
    productQuantity?: number; 
    invoiceId?: number; 
    productCost?: number; 
    product?: Product; 
    cartPrice? :number;
}
