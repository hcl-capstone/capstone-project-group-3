import { ProductCategory } from "./product-category";
import { Rating } from "./rating/rating";

export class Product{
    productId?: number;
    productName?: string;
    stockCount?: number;
    dateCreated?: Date;
    dateLastUpdated?: Date;
    unitPrice?: number;
    image_url?: string;
    category?: ProductCategory;
    ratings?: Rating[];
}
