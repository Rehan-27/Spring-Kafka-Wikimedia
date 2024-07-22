package kafka.consumer.database.com.repository;

import kafka.consumer.database.com.entity.WikimediaDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaDataEntity,Long> {

}
