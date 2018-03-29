package RestFull_Webservice_Karaf.TestRestServiceKaraf;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Products")
@XmlAccessorType (XmlAccessType.FIELD)
public class Products {

	@XmlElement(name = "Product")
    private List<Product> productsList = null;
 
    public List<Product> getProducts() 
    {
        return productsList;
    }

    public void setProducts(List<Product> productsList)
    {
       this.productsList = productsList;
    }
}
