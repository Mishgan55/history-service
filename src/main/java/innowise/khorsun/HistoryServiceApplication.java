package innowise.khorsun;

import innowise.khorsun.entity.Payment;
import innowise.khorsun.entity.User;
import innowise.khorsun.repository.PaymentRepository;
import innowise.khorsun.util.Status;
import innowise.khorsun.util.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;

@SpringBootApplication
public class HistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PaymentRepository repository){
        return args -> {
            User user = new User();
            user.setFirstName("Mikhail");
            user.setLastName("Khorsun");
            user.setEmail("test@mail.ru");
            user.setPhoneNumber("11111111");

            Payment payment = new Payment();
            payment.setUser(user);
            payment.setSessionId("test-session-id");
            payment.setStatus(Status.PENDING);
            payment.setUrl(new URL("http://localhost:8084/create-scheduled-notification"));
            payment.setPaymentAmount(new BigDecimal(123));
            payment.setType(Type.PAYMENT);
            payment.setPaymentDate(LocalDateTime.now());

            repository.insert(payment);
        };
    }
}
