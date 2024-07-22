package kafka.consumer.database.com;

import kafka.consumer.database.com.entity.WikimediaDataEntity;
import kafka.consumer.database.com.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerWikimedia {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumerWikimedia.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaConsumerWikimedia(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_topic",groupId = "myConsumerGrp")
    public void consumeMessage(String eventData){


        LOGGER.info(String.format("Event Data Received from Producer - > %s",eventData));


        WikimediaDataEntity entity= new WikimediaDataEntity();
        entity.setEventData(eventData);
        wikimediaDataRepository.save(entity);
    }
}
