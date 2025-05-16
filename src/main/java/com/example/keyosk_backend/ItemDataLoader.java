package com.example.keyosk_backend;

import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemDataLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public ItemDataLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (itemRepository.count() == 0) { // 이미 메뉴가 있다면 건너뜀
            // 음료 메뉴
            itemRepository.save(new Item("아메리카노", 4500, "drink"));
            itemRepository.save(new Item("카페라뗴", 5000, "drink"));
            itemRepository.save(new Item("바닐라라떼", 5500, "drink"));
            itemRepository.save(new Item("딸기라뗴", 6000, "drink"));
            itemRepository.save(new Item("초코프라페", 6300, "drink"));
            itemRepository.save(new Item("망고라떼", 4800, "drink"));
            itemRepository.save(new Item("카페라떼", 5000, "drink"));
            itemRepository.save(new Item("바나나주스", 5500, "drink"));
            itemRepository.save(new Item("딸기바나나주스", 6000, "drink"));
            itemRepository.save(new Item("딸기주스", 6300, "drink"));
            itemRepository.save(new Item("배주스", 4800, "drink"));

            // 디저트 메뉴
            itemRepository.save(new Item("호두스콘", 5500, "dessert"));
            itemRepository.save(new Item("초코쿠키", 6500, "dessert"));
            itemRepository.save(new Item("유자스콘", 5800, "dessert"));
            itemRepository.save(new Item("기본 스콘", 4200, "dessert"));
            itemRepository.save(new Item("마들렌", 2800, "dessert"));
            itemRepository.save(new Item("초코케이크", 5500, "dessert"));
            itemRepository.save(new Item("당근케이크", 6500, "dessert"));
            itemRepository.save(new Item("마카롱", 5800, "dessert"));
            itemRepository.save(new Item("샌드위치", 4200, "dessert"));
            itemRepository.save(new Item("호두과자", 2800, "dessert"));
        }
    }
}

