package lithan.training.javawebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final BillingService billingService;

    @Autowired
    public PaymentController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/payment")
    public String showPaymentPage() {
        return "Payment";
    }

    @PostMapping("/payment/complete")
    public String completePayment(@RequestParam String mode, Model model) {
        try {
            boolean result = billingService.completePayment(mode);
            model.addAttribute("message", result ? "Payment successful" : "Payment failed");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "payment";
    }
}
