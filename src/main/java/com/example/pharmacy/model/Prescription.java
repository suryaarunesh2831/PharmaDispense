package com.example.pharmacy.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "Prescription")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private Long patientId;
    private LocalDateTime createdDate;
    private String status;
    @ManyToOne
    @JoinColumn(name="physician_id")
    private User user;
}