package com.example.brothers.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String phone;

    private Double latitude;

    private Double longitude;

    private Boolean isOpen;

    private LocalDateTime createdAt;

    // Relationship with User (Owner)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}