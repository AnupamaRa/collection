import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class ProductCatSetGet {

    private int id;
    private String name;
    private ArrayList<CategoryPdt> category;
    private double price;
    private boolean available;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<CategoryPdt> getCategory() {
        return this.category;
    }

    public void setCategory(ArrayList<CategoryPdt> cat) {
        this.category = cat;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Methods to create category list
     * ARRAY LIST KOE V FUNCTION KA DEFINITION HOTA H FUNCTION KA NAME HOTA ,RETURN TYPE,FUNCTION PUBLICALLY H YA STATIC H .
     * STATIC= WE CAN DIRECTLY USE THIS FUNCTION WITHOUT CREATING AN OBJECT
     * ARRAY LIST IS A RETURN TYPE OF THIS FUNCN.
     * ARRAY LIST KE ANDER JO HOGA VHI RETURN DEGA.EG= CATEGORY PDT
     * createpdtCategories() function ka name h
     */
    static ArrayList<CategoryPdt> createPdtCategories() {
/*yha pe cat object create kie h or catArr av blank h  
 * CategoryPdt category ka pdt return karega
 * 
 */
        // Creating an empty ArrayList of category pdt type
    	
    	//ArrayList<String> catArr = new ArrayList<String>(); ["Sandeep", "Anu", "Rajan"]
    	
    	
        ArrayList<CategoryPdt> catArr = new ArrayList<CategoryPdt>(); //  [ ]
        // ArrayList<CategoryPdt> catArr = new ArrayList<CategoryPdt>(); [ {id-int -1,2,3 name-"anu"}] 
        //[ {123, "Transport"}, {23, "Sandeep"}, {45, "Sports"} ]

        int len = 6;
        for (int i =0; i<len; i++) {
            CategoryPdt cat = new CategoryPdt(); // new object created cat; { } empthy object structure are created

            cat.setId(i+1); //  {"id":1} {"id":2}
            cat.setName(cat.getCatByIndex(i)); //getCatByIndex function ko call kie h jo string type ka h or isme integer argument pass ho rha h.
            //{1,"transport"} {2,"electonics"}

            catArr.add(cat);//catArr blank h isme cat object ko add kr rhe h. [{1,"transport"} {2,"electonics"}]

        }

        return catArr; // function ko call kar lie h to ye function return type jo de rha h vo catArr;
    }

    /**
     * pick random list values from a given list
     */
    static ArrayList<CategoryPdt> pickRandomCategories(ArrayList<CategoryPdt> lst, int n) {
        ArrayList<CategoryPdt> copy = new ArrayList<CategoryPdt>(lst);
        Collections.shuffle(copy);
        List<CategoryPdt> nList =  n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n); //nlist variable create kie this is the shortcut of conditional operator/ternary operator
        ArrayList<CategoryPdt> nListArr = new ArrayList<>(nList.size());
        nListArr.addAll(nList);
        return nListArr;
    } 

    static ArrayList<ProductCatSetGet> createProducts(int pdtNum,ArrayList<CategoryPdt> cats){
    	
    	/*createProducts function h jo ArrayList type ka h jo ProductCatSetGet type ka object dega.
    	 * createProducts function ke ander do argument pass ho rha h 1st one pdtNum jo integers type ka h 2nd cats jo ArrayList type ka or CategoryPdt uska object h
    	 * 
    	 */
    	ArrayList<ProductCatSetGet> pdtsArr = new ArrayList<ProductCatSetGet>(); //pdtsArr kar ke variable declare kie h []
        Random rand = new Random(); // rand kar ke  variable declare kie.
        

    	for(int i=0;i<pdtNum;i++) {
    		
            double price = rand.nextInt(10000)+1; //+1 se ye 0 value nhio dega uske alwa kuch v random price dega yha pe eg. 9789.9
            boolean avail = rand.nextBoolean(); //yha availabilty random btaega true ya false me
            
    		ProductCatSetGet pdt = new ProductCatSetGet();  //ProductCatSetGet class ka object as a  pdt  variable kar ke  blank object create kie h  { }
    		int randomCatSize = rand.nextInt(cats.size()); // 

            // get random list of categories
    		
            ArrayList<CategoryPdt> randomCats = pickRandomCategories(cats, randomCatSize); //[]

    		pdt.setId(i+1); //{1}
    		pdt.setName("anu"+i); //{anu0}
    		pdt.setCategory(randomCats); //[ "transport","sports"] 
    		pdt.setPrice(price); // { 34.6}
    		pdt.setAvailable(avail); //{ true}
    		pdtsArr.add(pdt);  //[ {1,"anu0",["transport","sports"],34.6,true }]
    		
    	}
    	
    	System.out.println(pdtNum);//koe v kam nhi h
    	System.out.println(pdtsArr);// koe kam ni h yha pe iska
    	return pdtsArr;// ye phr se loop ko chalane jaege
    	
    	
    	
    }
    
    static void printProducts(ArrayList<ProductCatSetGet> pdts) {
        int count = 1;
        
        // Print all 100 created products with values
        for (ProductCatSetGet pdt1: pdts) {
            System.out.println("Product " + count + " details: ");
            System.out.println("ID: " + pdt1.id);
            System.out.println("Name: " + pdt1.name);
           // System.out.println("Category: "+ pdt1.category);
           int catc = 1;
            for ( CategoryPdt cat : pdt1.category) {

                System.out.println("Category " + catc + " : "+ cat.getName());
                catc++;
            }
            System.out.println("Price: " + pdt1.price);
            System.out.println("Is Available? : " + pdt1.available);
            count++;
            System.out.println("\n==========================\n\n");
        }
    }

    public static void main(String[] args) {
        // create list of pdt category
        ArrayList<CategoryPdt> cats = createPdtCategories();//function call
        System.out.println(cats);

        // Print all 100 created products with values
        for (CategoryPdt cat: cats) {
            System.out.println(cat.getId());
            System.out.println(cat.getName());
        }
        
        ArrayList<ProductCatSetGet> pdts = createProducts(100,cats);
        System.out.println(pdts);
        printProducts(pdts);
        
        
        
    }

}
