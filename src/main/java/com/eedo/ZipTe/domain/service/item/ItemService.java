package com.eedo.ZipTe.domain.service.item;

import com.eedo.ZipTe.domain.dto.ItemDto;
import com.eedo.ZipTe.domain.dto.PageRequestDTO;
import com.eedo.ZipTe.domain.dto.PageResponseDTO;
import com.eedo.ZipTe.domain.entity.item.Item;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


public interface ItemService {

    Long register(ItemDto dto);

    PageResponseDTO<ItemDto> getList(PageRequestDTO pageRequestDTO);

    ItemDto getOne(Long id);

    Long deleteOne(Long id);

    default Item dtoToEntity(ItemDto dto) {
        Item item = Item.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .pdesc(dto.getPdesc())
                .delFlag(dto.isDelFlag())
                .build();

        return item;
    }

    default ItemDto entityToDTO(Item item) {
        ItemDto dto = ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .delFlag(item.isDelFlag())
                .pdesc(item.getPdesc())
                .build();

        return dto;
    }
}
