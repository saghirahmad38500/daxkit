package io.cyangate.daxkit.controllers.excel.rwc;

import io.cyangate.daxkit.controllers.BaseController;
import io.cyangate.daxkit.dto.inputdto.excel.rwc.RWCExcelInputDTO;
import io.cyangate.daxkit.dto.outputdto.excel.rwc.RWCExcelOutputDTO;
import io.cyangate.daxkit.mappers.excel.rwc.RWCExcelDTOMapper;
import io.cyangate.daxkit.validators.excel.RWCExcelValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/excel", produces = MediaType.APPLICATION_JSON_VALUE)
public class RWCExcelController extends BaseController<RWCExcelInputDTO, RWCExcelOutputDTO> {

    public RWCExcelController() {
        super(new RWCExcelDTOMapper(), new RWCExcelValidator());
    }

    @Operation(summary = "Makes Excel Rows for Given Bynder Assets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RWCExcelOutputDTO.class)) })})
    @PostMapping(path = "/rwc-bynder-rows", produces = MediaType.APPLICATION_JSON_VALUE)
    public RWCExcelOutputDTO makeExcelRequestForBynderAssets(@Validated @RequestBody List<RWCExcelInputDTO> rwcExcelInputDTOs) {

        return super.convertListToDTO(rwcExcelInputDTOs);

    }
}