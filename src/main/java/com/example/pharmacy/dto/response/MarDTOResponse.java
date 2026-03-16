package com.example.pharmacy.dto.response;

import com.example.pharmacy.model.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MarDTOResponse {
    int MARID;
    Long drugId;
    Patient patient;
    int nurseId;
    String Dose;
    LocalDateTime ScheduledTime;
    LocalDateTime AdministeredTime;
    MARStaus status;
}
