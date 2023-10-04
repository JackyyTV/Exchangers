package jackyy.exchangers.registry.crafting.condition.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionImmersiveEngineeringModule(boolean enabled) implements ICondition {

    public static final Codec<ConditionImmersiveEngineeringModule> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.BOOL.fieldOf("enabled").forGetter(ConditionImmersiveEngineeringModule::enabled)).apply(b, ConditionImmersiveEngineeringModule::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() == enabled;
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public boolean enabled() {
        return this.enabled;
    }

}
