package com.hotel.kanyadan.Model.Res;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CommonResponse {
    private String message;
    private String statusCode;
}
