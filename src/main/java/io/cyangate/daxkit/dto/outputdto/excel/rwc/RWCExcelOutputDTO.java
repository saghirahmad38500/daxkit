package io.cyangate.daxkit.dto.outputdto.excel.rwc;

import io.cyangate.daxkit.dto.outputdto.BaseOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RWCExcelOutputDTO extends BaseOutputDTO {

    public ArrayList<ArrayList<String>> values;

}
