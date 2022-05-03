package hello;

public class Product {
	
	private long productId;
	private String name;
	private float  price;
	
	public Product(){
		
	}
	
	public Product(long productId, String name, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	

}
