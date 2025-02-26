package net.tythos.ducksunlimited.datagen;

import net.minecraft.predicate.entity.LootContextPredicate;
import java.util.Optional;
import net.minecraft.advancement.criterion.AbstractCriterion;
import com.mojang.serialization.Codec;
import net.minecraft.server.network.ServerPlayerEntity;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class UseToolCriterion extends AbstractCriterion<UseToolCriterion.Conditions> {
    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public void trigger(ServerPlayerEntity player, int totalTimes) {
        trigger(player, conditions -> conditions.requirementsMet(totalTimes));
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate, int requiredTimes)
            implements AbstractCriterion.Conditions {
        public static Codec<UseToolCriterion.Conditions> CODEC = RecordCodecBuilder.create(instance -> instance
                .group(LootContextPredicate.CODEC.optionalFieldOf("player").forGetter(Conditions::player),
                        Codec.INT.fieldOf("requiredItems").forGetter(Conditions::requiredTimes))
                .apply(instance, Conditions::new));

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet(int totalTimes) {
            return totalTimes > requiredTimes;
        }
    }
}
