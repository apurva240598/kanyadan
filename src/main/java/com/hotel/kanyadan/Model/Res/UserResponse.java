package com.hotel.kanyadan.Model.Res;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserResponse {
    private String username;
}
