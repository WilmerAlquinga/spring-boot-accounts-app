package dev.wsalquinga.accounts_service.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wsalquinga on 28/10/2023
 */
@Getter
@Setter
@Builder
public class MovementReqDTO {
    private Long id;

    @NotNull(message = "Fecha es requerida")
    private LocalDateTime date;

    private String movementType;

    @NotNull(message = "Valor es requerido")
    private BigDecimal amount;

    private BigDecimal balance;

    @NotNull(message = "Número de cuenta es requerido")
    private String accountNumber;
}
