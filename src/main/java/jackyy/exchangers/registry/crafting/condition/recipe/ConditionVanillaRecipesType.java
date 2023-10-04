package jackyy.exchangers.registry.crafting.condition.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionVanillaRecipesType(String value) implements ICondition {

    public static final Codec<ConditionVanillaRecipesType> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.STRING.fieldOf("value").forGetter(ConditionVanillaRecipesType::value)).apply(b, ConditionVanillaRecipesType::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.vanillaRecipesType.get().equals(value);
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public String value() {
        return this.value;
    }

}
