package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.CreditCard;
import com.mycompany.myapp.domain.Customer;
import com.mycompany.myapp.service.dto.CreditCardDTO;
import com.mycompany.myapp.service.dto.CustomerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CreditCard} and its DTO {@link CreditCardDTO}.
 */
@Mapper(componentModel = "spring")
public interface CreditCardMapper extends EntityMapper<CreditCardDTO, CreditCard> {
    @Mapping(target = "cardHolder", source = "cardHolder", qualifiedByName = "customerName")
    CreditCardDTO toDto(CreditCard s);

    @Named("customerName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CustomerDTO toDtoCustomerName(Customer customer);
}
