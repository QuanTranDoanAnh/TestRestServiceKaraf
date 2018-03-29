package RestFull_Webservice_Karaf.TestRestServiceKaraf;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement(name = "Order")
public class OrderBean {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	private long id;
	private String description;
	// private Map<Long, Product> products = new HashMap<Long, Product>();
	private Products products = new Products();

	public OrderBean() {
		init();
	}

	final void init() {
		products.setProducts(new ArrayList<Product>());
		Product p1 = new Product();
		p1.setId(323);
		p1.setDescription("product 323");

		Product p2 = new Product();
		p2.setId(324);
		p2.setDescription("product 324");

		products.getProducts().add(p1);
		products.getProducts().add(p2);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public Product getProduct(int productId) {
		Product prod = null;
		for (Product p : products.getProducts()) {
			if (p.getId() == productId) {
				prod = p;
			}
		}
		return prod;
	}

	public Products getProducts() {
		return products;
	}
}
