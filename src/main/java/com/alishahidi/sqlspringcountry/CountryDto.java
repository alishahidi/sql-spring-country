package com.alishahidi.sqlspringcountry;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryDto {
    String id;
    String code;
    String name;
    String en_name;

}
