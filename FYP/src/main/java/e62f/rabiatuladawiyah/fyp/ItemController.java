/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: FYP
 * Date created: 2022-May-03 01:58:44 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 20008933
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemRepository ItemRepo;

	@GetMapping("/items")
	public String viewItem(Model model) {

		List<Item> listItems = ItemRepo.findAll();

		model.addAttribute("listItems", listItems);
		return "view_items";

	}
	
	@GetMapping("/items/add")
	
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		return "add_item";
	}
	
	@PostMapping("/items/save")
	public String saveItem(Item items) {
		ItemRepo.save(items);
		
		return "redirect:/items";
		
	}
	@GetMapping("/items/edit/{id}")
	public String editItem(@PathVariable("id") Integer id, Model model) {

		Item item = ItemRepo.getById(id);
		model.addAttribute("item", item);

		return "edit_item";
	}

	@PostMapping("/items/edit/{id}")
	public String saveUpdatedEmployee(@PathVariable("id") String id, Item item) {

		ItemRepo.save(item);
		return "redirect:/items";
	}
	
	
	@GetMapping("/items/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		ItemRepo.deleteById(id);
		return "redirect:/items";
	}
}


