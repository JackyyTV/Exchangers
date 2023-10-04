package jackyy.exchangers.registry.crafting.condition.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionEnderIOModule(boolean enabled) implements ICondition {

    public static final Codec<ConditionEnderIOModule> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.BOOL.fieldOf("enabled").forGetter(ConditionEnderIOModule::enabled)).apply(b, ConditionEnderIOModule::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.enderIOModule.get() == enabled;
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public boolean enabled() {
        return this.enabled;
    }

}
