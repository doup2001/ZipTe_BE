package com.eedo.ZipTe.domain.controller;

import com.eedo.ZipTe.domain.dto.ItemDto;
import com.eedo.ZipTe.domain.dto.PageRequestDTO;
import com.eedo.ZipTe.domain.dto.PageResponseDTO;
import com.eedo.ZipTe.domain.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/item")
@Log4j2
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    public PageResponseDTO<ItemDto> getList(PageRequestDTO pageRequestDTO) {

        PageResponseDTO<ItemDto> responseDTO = itemService.getList(pageRequestDTO);
        log.info("====getList in C ====");
        log.info(responseDTO);

        return responseDTO;
    }

    @PostMapping("")
    public Map<String, Object> registerOne(ItemDto dto) {

        Long register = itemService.register(dto);
        log.info("[dto]:" + dto);

        return Map.of("SUCCESS", register);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOne(@PathVariable Long id) {
        ItemDto dto = itemService.getOne(id);
        log.info(dto);

        return Map.of("SUCCESS", dto);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteOne(@PathVariable Long id) {
        Long result = itemService.deleteOne(id);
        log.info(result);

        return Map.of("DELETE", result);
    }
}
