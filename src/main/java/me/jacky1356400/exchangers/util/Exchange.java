package me.jacky1356400.exchangers.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class Exchange {

	public BlockPos pos;
	public IBlockState state;

	public Exchange(BlockPos pos, IBlockState state) {
		this.pos = pos;
		this.state = state;
	}

}