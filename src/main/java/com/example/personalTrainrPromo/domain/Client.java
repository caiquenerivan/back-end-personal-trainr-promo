package com.example.personalTrainrPromo.domain;

import com.example.personalTrainrPromo.dto.ClientRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "clients")
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "clients_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private Boolean active;

    public Client(ClientRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.active = true;
    }
}
