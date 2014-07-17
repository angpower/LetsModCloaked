package com.angpower.letsmodcloaked.world.gen;

import com.angpower.letsmodcloaked.block.BlockLMC;
import com.angpower.letsmodcloaked.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class LMCBaseWorldGenerator implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId){
            case 0 :
                // Generate our surface world
                generateSurface(world, random, chunkX*16, chunkZ*16);
            case -1 :
                // Generate our surface world
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 1 :
                // Generate our surface world
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        //this.addOreSpawn(ModBlocks.orewhatever, world , random, x=blockXpos, z=blockZpos, maxX, maxZ, maxVeinSize,
        //change to Spawn ,minY, maxY
        this.addOreSpawn(ModBlocks.copper_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 30, 38, 90);
        this.addOreSpawn(ModBlocks.tin_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 48, 100);
        this.addOreSpawn(ModBlocks.vanadium_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 30, 10, 100);//10 10 20
        this.addOreSpawn(ModBlocks.manganese_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 50, 70);
        this.addOreSpawn(ModBlocks.rhodium_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
        this.addOreSpawn(ModBlocks.peridium_ore, world, random, x, z, 16, 16, 4+random.nextInt(6), 10, 30, 80);
    }

    private void generateNether(World world, Random random, int x, int z) {
        //auto generated ore's in the nether
    }
    private void generateEnd(World world, Random random, int x, int z) {
        //auto generated ore's in the end
    }

    private void addOreSpawn(BlockLMC blockLMC, World world, Random random, int blockXPos, int blockzPos, int maxX, int maxZ, int maxVeinSize, int changeToSpawn, int minY, int maxY)
    {
        for(int  i = 0; i < changeToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockzPos + random.nextInt(maxZ);
            (new WorldGenMinable(blockLMC, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

} // end of class
