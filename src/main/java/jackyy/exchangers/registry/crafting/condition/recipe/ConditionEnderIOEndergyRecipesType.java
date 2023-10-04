package jackyy.exchangers.registry.crafting.condition.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionEnderIOEndergyRecipesType(String value) implements ICondition {

    public static final Codec<ConditionEnderIOEndergyRecipesType> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.STRING.fieldOf("value").forGetter(ConditionEnderIOEndergyRecipesType::value)).apply(b, ConditionEnderIOEndergyRecipesType::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.enderIOEndergyRecipesType.get().equals(value);
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public String value() {
        return this.value;
    }

}
