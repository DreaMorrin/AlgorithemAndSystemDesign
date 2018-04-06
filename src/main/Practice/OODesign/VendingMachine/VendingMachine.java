package main.Practice.OODesign.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    Map<Position, Item> container;

    public VendingMachine() {
        container = new HashMap<>();
    }

    public void loadNewFood(Food food, int counts) {
        if (container.containsKey(food.getPosition())) {
            Item item = container.get(food.getPosition());
            item.setCount(item.getCount() + counts);
        } else {
            container.put(food.getPosition(), food);
        }

    }

    public Item getItem(double price, Position position) {
        if (container.containsKey(position)) {
            Item item = container.get(position);
            if (price < item.getPrice() || item.getCount() == 0) {
                return null;
            } else {
                item.setCount(item.getCount() - 1);
                return item;
            }
        }
        return null;
    }
}
