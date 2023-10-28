package dev.wsalquinga.clients_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wsalquinga on 26/10/2023
 */
@Getter
@Setter
public class ClientDTO {

    private Long id;

    private String password;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean status;

    @NotBlank(message = "Nombre no válido")
    private String name;

    @NotBlank(message = "Género no válido")
    private String gender;

    private Integer age;

    @NotBlank(message = "Número de identificación no válido")
    private String documentNumber;

    private String address;

    @NotNull(message = "El número de teléfono es requerido")
    @Min(value = 9, message = "El número de teléfono debe contener al menos 9 dígitos")
    private String phone_number;
}
