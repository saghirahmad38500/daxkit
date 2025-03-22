package io.cyangate.daxkit.dto.inputdto.excel.rwc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailsDTO {

     @JsonProperty("1000x1000_WebPNG")
     String webPng;
     @JsonProperty("1000x1000_WebJPG")
     String webJpg;
     @JsonProperty("43_BrandWebsite")
     String brandWebsite_43;
     @JsonProperty("Customer_2000x2000_300DPI")
     String customerImage_2000;
}
