package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CreditCard;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CreditCard entity.
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    default Optional<CreditCard> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<CreditCard> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<CreditCard> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct creditCard from CreditCard creditCard left join fetch creditCard.cardHolder",
        countQuery = "select count(distinct creditCard) from CreditCard creditCard"
    )
    Page<CreditCard> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct creditCard from CreditCard creditCard left join fetch creditCard.cardHolder")
    List<CreditCard> findAllWithToOneRelationships();

    @Query("select creditCard from CreditCard creditCard left join fetch creditCard.cardHolder where creditCard.id =:id")
    Optional<CreditCard> findOneWithToOneRelationships(@Param("id") Long id);
}
