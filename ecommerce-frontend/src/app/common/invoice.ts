import { Address } from "./address";
import { ShoppingCart} from "./shopping-cart";

export class Invoice{
    invoiceId?: number;
    totalPrice?: number;
    orderStatus?: string;
    dateOrdered?: Date;
    carts?: ShoppingCart;
    deliveryAddress?: Address;
}
