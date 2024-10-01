package com.eedo.ZipTe.domain.service.item;

import com.eedo.ZipTe.domain.dto.ItemDto;
import com.eedo.ZipTe.domain.dto.PageRequestDTO;
import com.eedo.ZipTe.domain.dto.PageResponseDTO;
import com.eedo.ZipTe.domain.entity.item.Item;
import com.eedo.ZipTe.domain.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public Long register(ItemDto dto) {
        Item item = dtoToEntity(dto);
        return itemRepository.save(item).getId();
    }

    @Override
    public PageResponseDTO<ItemDto> getList(PageRequestDTO pageRequestDTO) {

        log.info("=====get List =====");
        org.springframework.data.domain.Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1, pageRequestDTO.getSize(), Sort.by("id").descending());

        Page<Item> result = itemRepository.selectList(pageable);
        log.info("result log" + result);

        List<ItemDto> dtoList = result.get().map(arr -> {

            ItemDto dto = entityToDTO(arr);
            return dto;

        }).toList();

        long total = result.getTotalElements();

        return new  PageResponseDTO<ItemDto>(dtoList, pageRequestDTO, total);
    }

    @Override
    public ItemDto getOne(Long id) {
        Optional<Item> result = itemRepository.findById(id);
        Item item = result.orElseThrow();

        return entityToDTO(item);
    }

    @Override
    public Long deleteOne(Long id) {
        Optional<Item> result = itemRepository.findById(id);
        Item item = result.orElseThrow();
        item.deleteOne();

        if (item.isDelFlag()) {
            return -1L;
        }

        return item.getId();
    }


}
