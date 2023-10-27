package dev.wsalquinga.clients_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author wsalquinga on 26/10/2023
 */
@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_password", nullable = false, length = 512)
    private String password;

    @Column(name = "client_status")
    private Boolean status;

    @Column(name = "client_created_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "client_created_by", nullable = false, length = 128)
    private String createdBy;

    @Column(name = "client_updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "client_updated_by", nullable = false, length = 128)
    private String updatedBy;

    @Column(name = "client_deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "person_id",
            nullable = false
    )
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
