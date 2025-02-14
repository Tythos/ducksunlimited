package net.tythos.ducksunlimited;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;

import java.util.List;
import net.minecraft.text.Text;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.sound.SoundCategory;

public class CounterItem extends Item {
    public CounterItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.contains(ModComponents.CLICK_COUNT_COMPONENT)) {
            int count = stack.get(ModComponents.CLICK_COUNT_COMPONENT);
            tooltip.add(Text.translatable("item.ducksunlimited.counter.info", count).formatted(Formatting.GOLD));
        }
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        MyCustomComponent comp = stack.get(ModComponents.MY_CUSTOM_COMPONENT);
        if (comp != null) {
            float temp = comp.temperature();
            boolean burnt = comp.burnt();
            stack.set(ModComponents.MY_CUSTOM_COMPONENT, new MyCustomComponent(temp, burnt));
        }
        if (stack.contains(ModComponents.MY_CUSTOM_COMPONENT)) {
            if (!world.isClient()) {
                int count = stack.getOrDefault(ModComponents.CLICK_COUNT_COMPONENT, 0);
                stack.set(ModComponents.CLICK_COUNT_COMPONENT, ++count);
            }
        }
        stack.remove(ModComponents.MY_CUSTOM_COMPONENT);
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!entity.getWorld().isClient()) {
            entity.playSound(SoundEvents.ENTITY_PILLAGER_AMBIENT, 2f, 0.7f);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            context.getWorld().playSound(null, context.getBlockPos(), SoundEvents.BLOCK_COPPER_PLACE,
                    SoundCategory.PLAYERS, 1f, 1f);
        }
        return super.useOnBlock(context);
    }
}
