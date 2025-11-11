package yuratexi.item;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class Item_suspicious_substance extends Item {
    public Item_suspicious_substance(Settings settings){
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("itemTooltip.test-mod.suspicious_substance").formatted(Formatting.GOLD));
        textConsumer.accept(Text.translatable("itemTooltip.test-mod.suspicious_substance2").formatted(Formatting.BLUE));
    }
}
