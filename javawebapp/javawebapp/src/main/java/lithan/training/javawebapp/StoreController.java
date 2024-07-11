package lithan.training.javawebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

    @Autowired
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", storeService.getStores());
        return "Index";
    }

    @GetMapping("/stores")
    public String showStorePage() {
        return "AddStores";
    }
    
    @PostMapping("/stores")
    public String addStore(Store store) {
        storeService.addStore(store);
        return "redirect:/";
    }

    @PostMapping("/deleteStore")
    public String deleteStore(@RequestParam("storeName") String storeName) {
        storeService.deleteStore(storeName);
        return "redirect:/";
    }
}
