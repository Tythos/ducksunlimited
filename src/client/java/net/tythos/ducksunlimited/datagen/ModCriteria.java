package net.tythos.ducksunlimited.datagen;

import net.minecraft.advancement.criterion.Criteria;

public class ModCriteria {
    public static final UseToolCriterion USE_TOOL = Criteria.register("ducksunlimited:use_tool",
            new UseToolCriterion());
    // public static final ParameterizedUseToolCriterion PARAMETERIZED_USE_TOOL =
    // Criteria
    // .register("ducksunlimited:parameterized_use_tool", new
    // ParameterizedUseToolCriterion());

    public static void init() {
    }
}
