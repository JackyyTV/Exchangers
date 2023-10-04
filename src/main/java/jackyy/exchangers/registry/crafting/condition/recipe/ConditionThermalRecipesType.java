package jackyy.exchangers.registry.crafting.condition.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionThermalRecipesType(String value) implements ICondition {

    public static final Codec<ConditionThermalRecipesType> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.STRING.fieldOf("value").forGetter(ConditionThermalRecipesType::value)).apply(b, ConditionThermalRecipesType::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.thermalRecipesType.get().equals(value);
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public String value() {
        return this.value;
    }

}
