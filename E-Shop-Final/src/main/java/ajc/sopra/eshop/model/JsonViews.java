	
package ajc.sopra.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonViews {

	public static class Common {
	}

	public static class OrderWithOrderDetailAndUser extends Common {
	}

	public static class OrderWithUser extends Common {
	}

	public static class Order extends Common {
	}

	public static class OrderDetailWithProductAndReview extends Common {
	}

	public static class OrderDetailWithReview extends Common {
	}

	public class MerchantWithProduit extends Common{
	}

	public static class SupplierWithProduit extends Common {
	}
	
   public static class 	ProductWithSupplierAndCatAndOD extends Common{  
   }
   
	public static class SupplierWithProduct extends Common {
	}
	

	public static class UserWithOrderAndAdress extends Common {
	}
	
	/*public static class UserWithOrder extends Common {

	}*/
	
	public class ArtisanWithProduit extends Common{
	}
	public class CategoryWithProduct extends Common{
	}
	public class searchProduct extends Common{
	}
	public class searchnom extends Common{}
		public class ProductWithcat extends Common{}
			public class ProducAsc extends Common{
	}
			public class ProducDesc extends Common{
			}
			  public class ProducNom extends Common{
				}
			  public class Productkey extends Common{
				}
			  public class  Productbetween extends Common{
				}
}
