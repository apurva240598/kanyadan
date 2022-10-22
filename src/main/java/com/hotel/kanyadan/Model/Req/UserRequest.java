package com.hotel.kanyadan.Model.Req;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserRequest {
    private String username;
    private String password;
}
