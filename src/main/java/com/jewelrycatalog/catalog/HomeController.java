package com.jewelrycatalog.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private JewelryService jewelryService;

    @GetMapping("/")
    public String home(Model model) {
//        //Test: count items by category
//        int totalItems = jewelryService.getAllItems().size();
//        int rings = jewelryService.getItemsByCategory("Rings").size();
//        int earrings = jewelryService.getItemsByCategory("Earrings").size();
//        int braces = jewelryService.getItemsByCategory("Bracelets").size();
//        int necks = jewelryService.getItemsByCategory("Necklaces").size();
//
//        System.out.println("=====JEWELRY CATALOG DATA=====");
//        System.out.println("Total items: " + totalItems);
//        System.out.println("Total rings: " + rings);
//        System.out.println("Total earrings: " + earrings);
//        System.out.println("Total bracelets: " + braces);
//        System.out.println("Total necklaces: " + necks);
//        System.out.println("============================");
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/rings")
    public String rings(Model model) {
        List<JewelryItem> rings = jewelryService.getItemsByCategory("Rings");
        model.addAttribute("items", rings);
        model.addAttribute("categoryName", "Rings");
        model.addAttribute("categoryDescription", "Explore our stunning collection of diamnond rings, featuring timeless designs crafted with precision");
        return "category";
    }

    @GetMapping("/earrings")
    public String earrings(Model model) {
        List<JewelryItem> earrings = jewelryService.getItemsByCategory("Earrings");
        model.addAttribute("items", earrings);
        model.addAttribute("categoryName", "Earrings");
        model.addAttribute("categoryDescription", "Discover our elegant earring collection, from classic studs to statement pieces");
        return "category";
    }
    @GetMapping("/necklaces")
    public String necklaces(Model model) {
        List<JewelryItem> necklaces = jewelryService.getItemsByCategory("Necklaces");
        model.addAttribute("items", necklaces);
        model.addAttribute("categoryName", "Necklaces");
        model.addAttribute("categoryDescription", "Browse our exquisite necklace collection, ranging from timeless tennis necklaces and elegant pendants to sophisticated fancy necklaces");
        return "category";
    }
    @GetMapping("/bracelets")
    public String bracelets(Model model) {
        List<JewelryItem> bracelets = jewelryService.getItemsByCategory("Bracelets");
        model.addAttribute("items", bracelets);
        model.addAttribute("categoryName", "Bracelets");
        model.addAttribute("categoryDescription", "Discover our graceful bracelet collection, featuring classic tennis bracelets and unique designs");
        return "category";
    }

}
