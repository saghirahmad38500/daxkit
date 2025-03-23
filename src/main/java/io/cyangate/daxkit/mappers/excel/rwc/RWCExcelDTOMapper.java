package io.cyangate.daxkit.mappers.excel.rwc;

import io.cyangate.daxkit.dto.inputdto.excel.rwc.RWCExcelInputDTO;
import io.cyangate.daxkit.dto.outputdto.excel.rwc.RWCExcelOutputDTO;
import io.cyangate.daxkit.mappers.BaseDTOMapper;

import java.util.ArrayList;
import java.util.List;

public class RWCExcelDTOMapper implements BaseDTOMapper<RWCExcelInputDTO, RWCExcelOutputDTO> {

    @Override
    public RWCExcelOutputDTO convertListToDTO(List<RWCExcelInputDTO> inputDTOS){

        ArrayList<ArrayList<String>> rows = new ArrayList<>();

        inputDTOS.stream()
                .map(this::buildRow)
                .forEach(rows::add);

        return new RWCExcelOutputDTO(rows);

    }

    @Override
    public RWCExcelOutputDTO convertToDTO(RWCExcelInputDTO inputDTOS) {

        ArrayList<ArrayList<String>> row = new ArrayList<>();


        ArrayList<String> cellValues = buildRow(inputDTOS);
        row.add(cellValues);

        return new RWCExcelOutputDTO(row);

    }

    private ArrayList<String> buildRow(RWCExcelInputDTO inputDTO){

        ArrayList<String> cellValues = new ArrayList<>();

        String fileName = String.join(".", inputDTO.getName().trim(), inputDTO.getExtension().getFirst());
        String description = inputDTO.getDescription() != null ? inputDTO.getDescription() : "";
        String assetResolution = String.join("x", inputDTO.getWidth().toString(), inputDTO.getHeight().toString());
        String assetType = inputDTO.getProperty_Asset_Type() != null ? String.join(", ", inputDTO.getProperty_Asset_Type()) : "" ;
        String assetSubType = inputDTO.getProperty_Asset_Sub_Type() != null ? String.join(", ", inputDTO.getProperty_Asset_Sub_Type()) : "";
        String brand = inputDTO.getProperty_Brand() != null ? String.join(", ", inputDTO.getProperty_Brand()) : "";
        String assetProductCategory = inputDTO.getProperty_PH1() != null ? String.join(", ", inputDTO.getProperty_PH1()) : "";
        String assetProductSubCategory = inputDTO.getProperty_PH2() != null ? String.join(", ", inputDTO.getProperty_PH2()) : "";
        String assetProductSubCategory2 = inputDTO.getProperty_PH3() != null ? String.join(", ", inputDTO.getProperty_PH3()) : "";
        String usageRights = inputDTO.getProperty_Usage_Rights() != null ? String.join(", ", inputDTO.getProperty_Usage_Rights()) : "";
        String assetSKU = inputDTO.getProperty_SKU() != null ? String.join(", ", inputDTO.getProperty_SKU()) : "";
        String assetFileType = inputDTO.getProperty_File_Type() != null ? String.join(", ", inputDTO.getProperty_File_Type()) : "";
        String assetTags = inputDTO.getTags() != null ? String.join(", ", inputDTO.getTags()) : "";
        String assetAvailableFiles = inputDTO.getProperty_Asset_Sub_Type() != null ?  inputDTO.getProperty_Asset_Sub_Type().contains("Product_Images") ? "ALL" : "Original Only" : "Original Only";
        String assetPublicLink = inputDTO.getProperty_Asset_Sub_Type() != null ? inputDTO.getProperty_Asset_Sub_Type().contains("Product_Images") ? inputDTO.getOriginal() : inputDTO.getThumbnails().getWebJpg() : inputDTO.getOriginal();
        String assetPublicLinkWebPng = inputDTO.getProperty_Asset_Sub_Type() != null ? inputDTO.getProperty_Asset_Sub_Type().contains("Product_Images") ? inputDTO.getOriginal() : inputDTO.getThumbnails().getWebPng() : inputDTO.getOriginal();
        String brandWebsite_43 = inputDTO.getThumbnails().getBrandWebsite_43() != null ? inputDTO.getThumbnails().getBrandWebsite_43() : "";
        String customerImage_2000 = inputDTO.getThumbnails().getCustomerImage_2000() != null ? inputDTO.getThumbnails().getCustomerImage_2000() : "";


        cellValues.add(fileName);
        cellValues.add(inputDTO.getId());
        cellValues.add(description);
        cellValues.add(assetResolution);
        cellValues.add(assetType);
        cellValues.add(assetSubType);
        cellValues.add(brand);
        cellValues.add(assetProductCategory);
        cellValues.add(assetProductSubCategory);
        cellValues.add(assetProductSubCategory2);
        cellValues.add(usageRights);
        cellValues.add(assetSKU);
        cellValues.add(assetFileType);
        cellValues.add(assetTags);
        cellValues.add(assetAvailableFiles);
        cellValues.add(assetPublicLink);
        cellValues.add(assetPublicLinkWebPng);
        cellValues.add(brandWebsite_43);
        cellValues.add(customerImage_2000);

        return cellValues;

    }
}
