package io.cyangate.daxkit.dto.inputdto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListToSubListsInputDTO extends BaseInputDTO {

    List<?> list;
    int chunk;

}
