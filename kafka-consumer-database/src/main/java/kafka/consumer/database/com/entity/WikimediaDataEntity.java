package kafka.consumer.database.com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_recentchanges")
@Getter
@Setter
public class WikimediaDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "event_data", columnDefinition = "TEXT")
    private String eventData;

}
