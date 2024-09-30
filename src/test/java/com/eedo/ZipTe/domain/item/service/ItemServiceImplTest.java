package com.eedo.ZipTe.domain.item.service;

import com.eedo.ZipTe.domain.dto.ItemDto;
import com.eedo.ZipTe.domain.dto.PageResponseDTO;
import com.eedo.ZipTe.domain.entity.item.Item;
import com.eedo.ZipTe.domain.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
class ItemServiceImplTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void register_Item() throws Exception{

        //given
        Item item = Item.builder()
                .name("test")
                .price(10000)
                .stockQuantity(100)
                .pdesc("test")
                .delFlag(false)
                .build();

        //when
        Item save = itemRepository.save(item);

        //then
        Assertions.assertEquals(save.getName(), "test");

    }


    @Test
    public void SearchPage() throws Exception{
        //given

        for (int i = 0; i < 10; i++) {
            Item item = Item.builder()
                    .name("test" + i)
                    .price(Integer.parseInt(i+"0000"))
                    .stockQuantity(i)
                    .pdesc("test")
                    .delFlag(false)
                    .build();

            itemRepository.save(item);
        }

        //when
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        Page<Item> result = itemRepository.selectList(pageable);

        //then
        System.out.println("result = " + result.getContent());
        System.out.println("result = " + result.getTotalElements());
        System.out.println("result = " + result.getTotalPages());
    }

}