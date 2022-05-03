package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private ArrayList<Product> productList= null;
    private HashMap<Long, Product> productMap = null ;
    
    public GreetingController(){
    	productList= new ArrayList<Product>();
    	productMap  = new HashMap<Long, Product>();
    	
    	productMap.put(1L, new Product(1L, "에어서큘레이1", 68000f));
    	productMap.put(2L, new Product(2L, "에어서큘레이2", 78000f));
    	productMap.put(3L, new Product(3L, "에어서큘레이3", 88000f));
    	productMap.put(4L, new Product(4L, "에어서큘레이4", 98000f));
    	
    	
    	productList.add(new Product(1L, "에어서큘레이1", 68000f));
    	productList.add(new Product(2L, "에어서큘레이2", 78000f));
    	productList.add(new Product(3L, "에어서큘레이3", 88000f));
    	productList.add(new Product(4L, "에어서큘레이4", 98000f));
    }

    @RequestMapping("/greeting")
    public ResFormat greeting(@RequestParam(value="name", defaultValue="World") String name 
    		) {
    	
    	counter.incrementAndGet();
    	System.out.println("counter="+counter.get() + ",name="+name );
        return new ResFormat(counter.get(),
                            String.format(template, name));
    }
    
    private static final String loginTemplate = "Welcome you are logged with %s/%s!";
    @RequestMapping("/login")
    public ResFormat login(@RequestParam(value="id", defaultValue="id") String id,
    		@RequestParam(value="passwd", defaultValue="passwd") String passwd
    		) {
      	counter.incrementAndGet();
    	System.out.println("login : counter="+counter.get() + ",id="+id+",passwd="+passwd);
        return new ResFormat(counter.get(),
                            String.format(loginTemplate, id, passwd));
    }
    
    
    @RequestMapping("/getProductList")
    public ArrayList<Product> getProductList( ) {
      	counter.incrementAndGet();
    	System.out.println("getProductList : counter="+counter.get() );
    	return productList;
    }
    
    @RequestMapping("/getProduct")
    public Product getProduct(@RequestParam(value="productId", defaultValue="1") long productId 
    		) {
      	counter.incrementAndGet();
    	Product prd = productMap.get(productId);
    	System.out.println("getProduct : counter="+counter.get() + ",productId="+productId+ "\t:: "+prd);
        return prd;
    }
    
    @RequestMapping("/pickProduct")
    public Product pickProduct(@RequestParam(value="productId", defaultValue="1") long productId 
    		) {
      	counter.incrementAndGet();
    	Product prd = productMap.get(productId);
    	System.out.println("pickProduct : counter="+counter.get() + ",productId="+productId+ "\t:: "+prd);
        return prd;
    }
}
