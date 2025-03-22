package io.cyangate.daxkit.dto.inputdto.excel.rwc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.cyangate.daxkit.dto.inputdto.BaseInputDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RWCExcelInputDTO extends BaseInputDTO {

     String description;
     String id;
     String copyright;
     List<String> tags;
     String type;
     String idHash;
     Integer height;
     String datePublished;
     Integer fileSize;
     String brandId;
     String name;
     List<String> extension;
     String userCreated;
     String dateCreated;
     Integer isPublic;
     List<String> propertyOptions;
     String orientation;
     String dateModified;
     Integer width;
     Integer watermarked;
     Integer limited;
     Integer archive;
     List<String> property_Department;
     List<String> property_PH1;
     List<String> property_PH2;
     List<String> property_PH3;
     List<String> property_Usage_Rights;
     List<String> property_Image_Positioning;
     List<String> property_Asset_Type;
     List<String> property_Distribution_Method;
     List<String> property_Brand;
     List<String> property_SKU;
     @JsonProperty("property_Asset_Sub-Type")
     List<String> property_Asset_Sub_Type;
     List<String> property_File_Type;
     String original;
     ThumbnailsDTO thumbnails;

}
