package innowise.khorsun.entity;

import innowise.khorsun.util.Status;
import innowise.khorsun.util.Type;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
@Data
@Document
public class Payment {
    @Id
    private String paymentId;
    private User user;
    private String sessionId;
    private Status status;
    private URL url;
    private BigDecimal paymentAmount;
    private Type type;
    private LocalDateTime paymentDate;
}
