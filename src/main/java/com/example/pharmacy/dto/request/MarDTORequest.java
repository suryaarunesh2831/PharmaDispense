package com.example.pharmacy.dto.request;

import com.example.pharmacy.model.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MarDTORequest {
    int MARID;
    Long drugId;
    Patient patient;
    int nurseId;
    String Dose;
    LocalDateTime ScheduledTime;
    LocalDateTime AdministeredTime;
    MARStaus status;
}
