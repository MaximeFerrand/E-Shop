	
package ajc.sopra.eshop.model;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonViews {

	public static class Common {
	}

	public static class OrderWithOrderDetail extends Common {
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
	}


