package lithan.training.javawebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javawebappConfig {
    
    @Bean
    public PaymentProcessorFactory paymentProcessorFactory() {
        return new PaymentProcessorFactory();
    }

    @Bean
    public BillingService billingService(PaymentProcessorFactory paymentProcessorFactory) {
        return new BillingService(paymentProcessorFactory);
    }
}