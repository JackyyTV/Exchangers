package jackyy.exchangers.registry.crafting.condition.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionEnderIOEndergyModule(boolean enabled) implements ICondition {

    public static final Codec<ConditionEnderIOEndergyModule> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.BOOL.fieldOf("enabled").forGetter(ConditionEnderIOEndergyModule::enabled)).apply(b, ConditionEnderIOEndergyModule::new)
    );

    @Override
    public boolean test(IContext context) {
        //Disabled recipes for now until Ender IO Endergy gets ported
        //return ModConfigs.CONFIG.enderIOEndergyModule.get() == value;
        return false;
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public boolean enabled() {
        return this.enabled;
    }

}
