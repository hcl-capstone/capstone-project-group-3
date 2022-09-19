import { Invoice } from "./invoice";
import { Product } from "./product";

export class ShoppingCart{
    id?: number;
    productId?: number; 
    productQuantity?: number; 
    invoiceId?: number; 
    productCost?: number; 
    product?: Product; 
}
