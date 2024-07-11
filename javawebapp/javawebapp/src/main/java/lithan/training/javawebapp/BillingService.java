package lithan.training.javawebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    private final PaymentProcessorFactory paymentProcessorFactory;

    @Autowired
    public BillingService(PaymentProcessorFactory paymentProcessorFactory) {
        this.paymentProcessorFactory = paymentProcessorFactory;
    }

    public boolean completePayment(String paymentMode) {
        PaymentProcessor paymentProcessor = paymentProcessorFactory.getPaymentProcessor(paymentMode);
        if (paymentProcessor != null) {
            return paymentProcessor.process();
        }
        throw new IllegalArgumentException("Invalid payment mode: " + paymentMode);
    }
}
   
   
