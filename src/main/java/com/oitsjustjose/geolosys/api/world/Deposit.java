package com.oitsjustjose.geolosys.api.world;

import com.oitsjustjose.geolosys.common.utils.Utils;
import net.minecraft.block.BlockState;

import java.util.List;

public class Deposit implements IDeposit
{
    private BlockState oreBlock;
    private BlockState sampleBlock;
    private int yMin;
    private int yMax;
    private int size;
    private int chance;
    private String[] dimensionBlacklist;
    private List<BlockState> blockStateMatchers;
    private float density;

    public Deposit(BlockState oreBlock, BlockState sampleBlock, int yMin, int yMax, int size, int chance,
            String[] dimensionBlacklist, List<BlockState> blockStateMatchers, float density)
    {
        this.oreBlock = oreBlock;
        this.sampleBlock = sampleBlock;
        this.yMin = yMin;
        this.yMax = yMax;
        this.size = size;
        this.chance = chance;
        this.dimensionBlacklist = dimensionBlacklist;
        this.blockStateMatchers = blockStateMatchers;
        this.density = density;
    }

    public BlockState getOre()
    {
        return this.oreBlock;
    }

    public BlockState getSample()
    {
        return this.sampleBlock;
    }

    public int getYMin()
    {
        return this.yMin;
    }

    public int getYMax()
    {
        return this.yMax;
    }

    public int getChance()
    {
        return this.chance;
    }

    public int getSize()
    {
        return this.size;
    }

    public String[] getDimensionBlacklist()
    {
        return this.dimensionBlacklist;
    }

    public boolean canReplace(BlockState state)
    {
        if (this.blockStateMatchers == null)
        {
            return true;
        }
        for (BlockState s : this.blockStateMatchers)
        {
            if (Utils.doStatesMatch(s, state))
            {
                return true;
            }
        }
        return false;
    }

    public List<BlockState> getBlockStateMatchers()
    {
        return this.blockStateMatchers;
    }

    public boolean oreMatches(BlockState other)
    {
        return Utils.doStatesMatch(this.oreBlock, other);
    }

    public boolean sampleMatches(BlockState other)
    {
        return Utils.doStatesMatch(this.sampleBlock, other);
    }

    public float getDensity()
    {
        return this.density;
    }

    public String getFriendlyName()
    {
        return Utils.blockStateToName(this.getOre());
    }
}