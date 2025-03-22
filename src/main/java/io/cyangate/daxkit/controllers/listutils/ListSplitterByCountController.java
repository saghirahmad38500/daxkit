package io.cyangate.daxkit.controllers.listutils;

import io.cyangate.daxkit.controllers.BaseController;
import io.cyangate.daxkit.dto.inputdto.ListToSubListsInputDTO;
import io.cyangate.daxkit.dto.outputdto.ListToSubListsOutputDTO;
import io.cyangate.daxkit.mappers.ListDTOMappers.SplitByCountDTOMapper;
import io.cyangate.daxkit.validators.ListValidators.ListToSubListsValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/lists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListSplitterByCountController extends BaseController<ListToSubListsInputDTO, ListToSubListsOutputDTO> {

    public ListSplitterByCountController() {
        super(new SplitByCountDTOMapper(), new ListToSubListsValidator());
    }

    @Operation(summary = "Split list into given number of sub lists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ListToSubListsOutputDTO.class)) })})
    @PostMapping(path = "/split-to-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListToSubListsOutputDTO splitListByCount(@Validated @RequestBody ListToSubListsInputDTO listToSubListsDTO) {

       return super.convertToDTO(listToSubListsDTO);

    }

}

