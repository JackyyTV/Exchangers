package jackyy.exchangers.registry.crafting.condition.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionSpecialModule(boolean enabled) implements ICondition {

    public static final Codec<ConditionSpecialModule> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.BOOL.fieldOf("enabled").forGetter(ConditionSpecialModule::enabled)).apply(b, ConditionSpecialModule::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.specialModule.get() == enabled;
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public boolean enabled() {
        return this.enabled;
    }

}
