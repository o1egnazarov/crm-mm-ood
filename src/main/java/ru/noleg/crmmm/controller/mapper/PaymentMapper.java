package ru.noleg.crmmm.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.noleg.crmmm.config.MapStructConfig;
import ru.noleg.crmmm.controller.model.PaymentDTO;
import ru.noleg.crmmm.entity.Payment;
import ru.noleg.crmmm.utils.BaseMapper;
@Mapper(config = MapStructConfig.class)
public interface PaymentMapper extends BaseMapper<Payment, PaymentDTO> {
    @Override
    Payment toEntity(PaymentDTO paymentDTO);

    @Override
    PaymentDTO toDto(Payment payment);

    @Override
    Payment updateEntity(PaymentDTO paymentDTO, @MappingTarget Payment payment);
}
