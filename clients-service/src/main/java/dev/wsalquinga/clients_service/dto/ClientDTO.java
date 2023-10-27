package dev.wsalquinga.clients_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author wsalquinga on 26/10/2023
 */
public class ClientDTO {

    private Long id;

    private String password;

    @NotNull
    private Boolean status;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    private Integer age;

    @NotBlank
    private String documentNumber;

    private String address;

    @Min(9)
    private String phone_number;
}
