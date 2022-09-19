import { Invoice } from "./invoice";
import { Product } from "./product";
import { Address } from "./address";
import { ShoppingCart } from "./shopping-cart";

export class CartDetails{
    productQuantity?: number;
    product?: Product;
    productCost?: number;
    cartId?: number;
}