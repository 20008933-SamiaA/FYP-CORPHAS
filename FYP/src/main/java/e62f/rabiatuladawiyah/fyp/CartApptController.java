/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-14 2:47:59 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * @author 20021900
 *
 */
@Controller
public class CartApptController {


  @Autowired
  private CartApptRepository cartApptRepo;

  @Autowired
  private AppointmentRepository apptRepo;

  @Autowired
  private CorpUserRepository corpuserRepo;
  
  @Autowired
  private PackageRepository packageRepo;
  
  @GetMapping("/cart")
  public String showCart(Model model, Principal principal) {

    // Get currently logged in user
    CorpUserDetails loggedInUser = (CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    int loggedInCorpUserId = loggedInUser.getUser().getId();

    // Get shopping cart items added by this user
    // *Hint: You will need to use the method we added in the CartItemRepository
    List<CartAppt> cartApptList = cartApptRepo.findByCorpuserId(loggedInCorpUserId);
    //List<Appointment> apptList = apptRepo.findByCorpuserId();
    // Add the shopping cart items to the model
    model.addAttribute("cartApptList",cartApptList);
    
    // Calculate the total cost of all items in the shopping cart
    double cartTotal=0.0;
    for(int i=0;i<cartApptList.size();i++) {
      CartAppt currentCartAppt=cartApptList.get(i);
      cartTotal +=currentCartAppt.getSubtotal();
    }
    

    // Add the shopping cart total to the model
    model.addAttribute("cartTotal",cartTotal);
    model.addAttribute("memberId",loggedInCorpUserId);

    
    return "cart";
  }

	@GetMapping("/selectPackage")
	public String selectPackage(Model model, Principal principle) {
	    // Get currently logged in user
	    CorpUserDetails loggedInUser = (CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
	        .getPrincipal();
	    int loggedInCorpUserId = loggedInUser.getUser().getId();

	    // Get shopping cart items added by this user
	    // *Hint: You will need to use the method we added in the CartItemRepository
	    List<CartAppt> cartApptList = cartApptRepo.findByCorpuserId(loggedInCorpUserId);
	    
	    // Add the shopping cart items to the model
	    model.addAttribute("cartApptList",cartApptList);

	    // Calculate the total cost of all items in the shopping cart
		
		  double cartTotal=0.0; for(int i=0;i<cartApptList.size();i++) { CartAppt
		 currentCartAppt=cartApptList.get(i); cartTotal
		 +=currentCartAppt.getSubtotal(); }
		 
		
		 // Retrieve all categories from database 
	    List<Package> listPackages = packageRepo.findAll();
		  
		  // Add the categories to the model 
		  model.addAttribute("listPackages",listPackages);
		 
		
		// return the response as a view
		return "package_selection";
		}
	
		/*
		 * @GetMapping("/selectPackage") public String showPackageSelection(Model model,
		 * Principal principal) { // Retrieve all categories from db List<Package>
		 * packageList = packageRepo.findAll();
		 * 
		 * // Add the categories to the model
		 * model.addAttribute("listPackage",packageList);
		 * 
		 * // return the responses as a view return "package_selection";
		 * 
		 * }
		 */
  
	
	 @PostMapping("/cart/add/{apptId}")
	  public String addToCart(@PathVariable("apptId") String apptId,
	      Principal principal) {

	    // Get currently logged in user
		    CorpUserDetails loggedInMember = ( CorpUserDetails) SecurityContextHolder.getContext().getAuthentication()
		            .getPrincipal();
		        int loggedInMemberId = loggedInMember.getUser().getId();
	    
	    
	    // Check in the cartItemRepo if item was previously added by user.
	    // *Hint: we will need to write a new method in the CartItemRepository
		        CartAppt cartItem= cartApptRepo.findByCorpuserIdAndAppt_Apptid(loggedInMemberId, apptId);
	    
	   
	    // if the item was NOT previously added,
	    // then prepare the item and member objects
		Appointment appt = apptRepo.getById(apptId);
		CorpUser user = corpuserRepo.getById(loggedInMemberId);
	    
	    
	    // Create a new CartItem object

	    CartAppt newCartItem=new CartAppt();
	    
	    // Set the item and member as well as the new quantity in the new CartItem
	    // object

	    newCartItem.setAppt(appt);
	    newCartItem.setCorpuser(user);

	    
	    // Save the new CartItem object to the repository

	    cartApptRepo.save(newCartItem);

	    return "redirect:/cart";
	  }

	@PostMapping("/cart/update/{id}")
	public String updateCart(@PathVariable("id") int cartItemId, @RequestParam("qty") int qty) {

		// Get cartItem object by cartItem's id
		

		// Set the quantity of the carItem object retrieved
		
		
		// Save the cartItem back to the cartItemRepo
		

		return "redirect:/cart";
	}

	@GetMapping("/cart/remove/{id}")
	public String removeFromCart(@PathVariable("id") int cartItemId) {

		//Remove item from cartItemRepo 

	     cartApptRepo.deleteById(cartItemId); 

		return "redirect:/cart";
	}

/*@PostMapping("/cart/process_order")
public String processOrder(Model model, @RequestParam("formcartTotal") double cartTotal,
  @RequestParam("corpuserId") int memberId, @RequestParam("orderId") String orderId,
  @RequestParam("transactionId") String transactionId) {
  */
/*     // Retrieve cart items purchased  
  List<CartAppt> cartItemList = cartApptRepo.findByCorpuserId(memberId);
  
     // Get member object
  CorpUser user = corpuserRepo.getById(memberId);
  
     // Loop to iterate through all cart items
  for (int i = 0; i < cartItemList.size(); i++) {
    
    // Retrieve details about current cart item  
    //-Get current cart item object
    //-Get quantity of current cart item object
    //-Get actual item ID
    
    CartAppt currentCartItem = cartItemList.get(i);
    int quantityPurchased = currentCartItem.getQuantity();
    Appointment itemToUpdate = currentCartItem.getAppt();
    String itemToUpdateId = itemToUpdate.getApptid();
    
    // Update item table
    // Get item from item table (Existing inventory)
    //Get existing item quantity
    //Update item quantity
    //Save updated item to itemRepo

    
    // Add item to order table  
    // create a new OrderItem obj
    //set order id, member id, item, member, quantity purchased
    //save OrderItem obj to orderRepo
    OrderItem orderItem = new OrderItem();
    orderItem.setOrderId(orderId);
    orderItem.setItem(itemToUpdate);
    orderItem.setMember(member);
    orderItem.setQuantity(quantityPurchased);
    orderItem.setTransactionId(transactionId);
    orderRepo.save(orderItem);
    
    // clear cart items belonging to member
    cartItemRepo.deleteById(currentCartItem.getId());
    
  }
  
  // Pass info to view to display success page
  model.addAttribute("cartTotal", cartTotal);
  model.addAttribute("cartItemList", cartItemList);
  model.addAttribute("member", member);
  model.addAttribute("orderId", orderId);
  model.addAttribute("transactionId", transactionId);*/

}
