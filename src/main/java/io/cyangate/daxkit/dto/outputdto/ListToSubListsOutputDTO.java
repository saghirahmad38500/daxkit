package io.cyangate.daxkit.dto.outputdto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListToSubListsOutputDTO extends BaseOutputDTO {

    List<List<?>> listOfSubLists;

}
