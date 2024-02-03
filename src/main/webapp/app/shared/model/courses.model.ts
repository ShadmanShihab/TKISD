import { ICategory } from 'app/shared/model/category.model';
import { IOrders } from 'app/shared/model/orders.model';

export interface ICourses {
  id?: number;
  courseName?: string;
  description?: string;
  price?: number;
  numberOfClasses?: number;
  totalDuration?: number;
  categoryId?: ICategory | null;
  orders?: IOrders | null;
}

export const defaultValue: Readonly<ICourses> = {};
