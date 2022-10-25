package com.hotel.kanyadan.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Document(collection = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private String id;
    private String name;
    private String mobile;
    private LocalDate date;
    private String idType;
    private String idNum;
    private Boolean vehicle;
    private String vehicleType;
    private String vehicleNumber;
    private String roomType;
    private String roomNumber;
    private LocalDate checkIn;
    private String checkOut;
    private Boolean addOnService;
    private int addOnServicePrice;
    private int roomPrice;
    private int totalBill;
}
