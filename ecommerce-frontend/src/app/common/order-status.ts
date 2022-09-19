import { Invoice } from "./invoice";
import { Product } from "./product";
import { Address } from "./address";
import { ShoppingCart } from "./shopping-cart";

export class OrderStatus{
    carts?: ShoppingCart;
    productQuantity?: number;
    totalPrice?: number;
    address?: Address;
    dateOrdered?: Date;
}