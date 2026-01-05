package com.jewelrycatalog.catalog;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelryService {
    private List<JewelryItem> allItems;

    public JewelryService() {
        this.allItems = new ArrayList<>();
        loadSampleData();
    }
    //get all jewelry items
    public List<JewelryItem> getAllItems() {
        return allItems;
    }

    //get items by category(e.g, "Rings", "Earrings")
    public List<JewelryItem> getItemsByCategory(String category) {
        return allItems.stream().filter(item -> item.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public void loadSampleData() {
        //RINGS
        JewelryItem ring1 = new JewelryItem("Round Eternity Ring", "Rings", "Eternity", "/images/rings/round-eternity-ring.png");
        ring1.addVariation("2.00ctw", 999.99, "https://youtu.be/L4l4jMv2BpQ");
        ring1.addVariation("4.00ctw", 1099.99, "https://youtu.be/vXAehOR1CBA");
        ring1.addVariation("6.00ctw", 1599.99, "https://youtu.be/-aGfQ6CP2iA");

        JewelryItem ring2 = new JewelryItem("Round 5 Stone Ring", "Rings", "5 Stone", "/images/rings/5 Stone-1.jpg");
        ring2.addVariation("1.00ctw", 999.99, "https://youtube.com/watch?v=example4");
        ring2.addVariation("3.00ctw", 1099.99, "https://youtube.com/watch?v=example5");
        ring2.addVariation("5.00ctw", 1599.99, "https://youtube.com/watch?v=example6");

        JewelryItem ring3 = new JewelryItem("Round 7 Stone Ring", "Rings", "7 Stone", "/images/rings/7 Stone-1.jpg");
        ring3.addVariation("2.00ctw", 999.99, "https://youtube.com/watch?v=example7");
        ring3.addVariation("3.00ctw", 1099.99, "https://youtube.com/watch?v=example8");
        ring3.addVariation("4.00ctw", 1599.99, "https://youtube.com/watch?v=example9");

        //EARRINGS
        JewelryItem earring1 = new JewelryItem("Round Stud", "Earrings", "Studs", "/images/rings/Studs-1.jpg");
        earring1.addVariation("0.50ctw", 999.99, "https://youtu.be/BajOIp41E04");
        earring1.addVariation("1.00ctw", 1099.99, "https://youtu.be/rT-o00qX9LE");
        earring1.addVariation("2.00ctw", 1599.99, "https://youtu.be/Fbr1-m5WX48");
        earring1.addVariation("3.00ctw", 999.99, "https://youtu.be/CLBOiRdWQF4");
        earring1.addVariation("4.00ctw", 1099.99, "https://youtu.be/lgGq8tiyXMA");
        earring1.addVariation("5.00ctw", 1599.99, "https://youtu.be/jkevY0SFVrM");

        JewelryItem earring2 = new JewelryItem("Round In/Out Hoops", "Earrings", "In/Out Hoops", "/images/rings/In-Out Hoops-1.jpg");
        earring2.addVariation("1.00ctw", 999.99, "https://youtu.be/TaL9LrvtZdI");
        earring2.addVariation("2.00ctw", 1099.99, "https://youtube.com/watch?v=example17");
        earring2.addVariation("3.00ctw", 1599.99, "https://youtube.com/watch?v=example18");
        earring2.addVariation("4.00ctw", 999.99, "https://youtube.com/watch?v=example19");

        JewelryItem earring3 = new JewelryItem("Round Huggies", "Earrings", "Huggies", "/images/rings/Huggies-1.jpg");
        earring3.addVariation("2.00ctw", 1099.99, "https://youtube.com/watch?v=example20");
        earring3.addVariation("3.00ctw", 1599.99, "https://youtube.com/watch?v=example21");
        earring3.addVariation("4.00ctw", 999.99, "https://youtube.com/watch?v=example22");

        //BRACELETS
        JewelryItem bracelet1 = new JewelryItem("Round Tennis Bracelet", "Bracelets", "Tennis Bracelet", "/images/rings/Tennis Bracelet-1.jpg");
        bracelet1.addVariation("2.00ctw", 1099.99, "https://youtube.com/watch?v=example23");
        bracelet1.addVariation("3.00ctw", 1599.99, "https://youtube.com/watch?v=example24");
        bracelet1.addVariation("5.00ctw", 999.99, "https://youtube.com/watch?v=example125");
        bracelet1.addVariation("7.00ctw", 1099.99, "https://youtube.com/watch?v=example26");
        bracelet1.addVariation("10.00ctw", 1599.99, "https://youtube.com/watch?v=example27");

        JewelryItem bracelet2 = new JewelryItem("Round Link Bracelet", "Bracelets", "Link Bracelet", "/images/rings/Link Bracelet-1.jpg");
        bracelet2.addVariation("2.00ctw", 1099.99, "https://youtube.com/watch?v=example28");
        bracelet2.addVariation("5.00ctw", 1099.99, "https://youtube.com/watch?v=example29");
        bracelet2.addVariation("7.00ctw", 1099.99, "https://youtube.com/watch?v=example30");

        JewelryItem bracelet3 = new JewelryItem("Round Bezel Bracelet", "Bracelets", "Bezel Bracelet", "/images/rings/Bezel Bracelet-1.jpg");
        bracelet3.addVariation("5.00ctw", 1099.99, "https://youtube.com/watch?v=example31");
        bracelet3.addVariation("7.00ctw", 1099.99, "https://youtube.com/watch?v=example32");

        JewelryItem bracelet4 = new JewelryItem("Multishape Tennis Bracelet", "Bracelets", "Multishape Tennis Bracelet", "/images/rings/Multishape Tennis Bracelet-1.jpg");
        bracelet4.addVariation("10.00ctw", 1099.99, "https://youtube.com/watch?v=example33");
        bracelet4.addVariation("12.00ctw", 1099.99, "https://youtube.com/watch?v=example34");
        bracelet4.addVariation("20.00ctw", 1099.99, "https://youtube.com/watch?v=example35");

        //NECKLACES
        JewelryItem necklace1 = new JewelryItem("Round Tennis Necklace", "Necklaces", "Tennis Necklace", "/images/rings/Tennis Necklace-1.jpg");
        necklace1.addVariation("5.00ctw", 1099.99, "https://youtube.com/watch?v=example36");
        necklace1.addVariation("7.00ctw", 1599.99, "https://youtube.com/watch?v=example37");
        necklace1.addVariation("10.00ctw", 999.99, "https://youtube.com/watch?v=example138");
        necklace1.addVariation("15.00ctw", 1099.99, "https://youtube.com/watch?v=example39");
        necklace1.addVariation("20.00ctw", 1599.99, "https://youtube.com/watch?v=example40");

        JewelryItem necklace2 = new JewelryItem("Round Bezel Set necklace", "Necklaces", "Bezel Necklace", "/images/rings/Bezel Necklace-1.jpg");
        necklace2.addVariation("5.00ctw", 1099.99, "https://youtube.com/watch?v=example41");
        necklace2.addVariation("7.00ctw", 1599.99, "https://youtube.com/watch?v=example42");
        necklace2.addVariation("10.00ctw", 999.99, "https://youtube.com/watch?v=example143");

        JewelryItem necklace3 = new JewelryItem("Round Riviera Necklace", "Necklaces", "Riviera Necklace", "/images/rings/Riviera Necklace-1.jpg");
        necklace3.addVariation("7.00ctw", 1099.99, "https://youtube.com/watch?v=example44");
        necklace3.addVariation("10.00ctw", 1599.99, "https://youtube.com/watch?v=example45");
        necklace3.addVariation("15.00ctw", 999.99, "https://youtube.com/watch?v=example146");
        necklace3.addVariation("20.00ctw", 1099.99, "https://youtube.com/watch?v=example47");

        JewelryItem necklace4 = new JewelryItem("Round Solitaire Pendant", "Necklaces", "Solitaire Pendant", "/images/rings/Solitaire Pendant-1.jpg");
        necklace4.addVariation("0.50ctw", 1099.99, "https://youtube.com/watch?v=example48");
        necklace4.addVariation("1.00ctw", 1599.99, "https://youtube.com/watch?v=example49");
        necklace4.addVariation("2.00ctw", 999.99, "https://youtube.com/watch?v=example150");
        necklace4.addVariation("3.00ctw", 1099.99, "https://youtube.com/watch?v=example51");

        allItems.add(ring1);
        allItems.add(ring2);
        allItems.add(ring3);
        allItems.add(earring1);
        allItems.add(earring2);
        allItems.add(earring3);
        allItems.add(bracelet1);
        allItems.add(bracelet2);
        allItems.add(bracelet3);
        allItems.add(bracelet4);
        allItems.add(necklace1);
        allItems.add(necklace2);
        allItems.add(necklace3);
        allItems.add(necklace4);

    }


}


