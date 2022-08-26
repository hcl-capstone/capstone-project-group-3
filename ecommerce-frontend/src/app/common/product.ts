import { ProductCategory } from "./product-category";

export class Product{
    productName?: string;
    stockCount?: number;
    dateCreated?: Date;
    dateLastUpdated?: Date;
    unitPrice?: number;
    image_url?: string;
    category?: ProductCategory;
}
