import { Role } from "./role";
import { Address } from "./address";
import { Invoice } from "./invoice"; 

export class User{
    id?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    role?: Role;
    address?: Address[];
    invoices?: Invoice[]; 
}
