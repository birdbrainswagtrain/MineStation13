package net.c0gg.ms13;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon; //YOLO ~Pdan;

public class BlockAsteroid extends Block {
	public static final String[] subTypes = new String[] {"stone", "copper", "iron", "plasma","silver","gold","uranium","diamond","bananas"};
	//public static final String[] fancyNames = new String[] {"Asteroid Stone", "Copper Ore", "Iron Ore", "Plasma Ore","Silver Ore","Gold Ore","Uranium Ore","Diamond Ore","Bananimum Ore"};
	private IIcon[] icons;
	
	public BlockAsteroid(int id) {
		super(Material.rock);
		
		setHardness(1.5f).setResistance(10.0f).setCreativeTab(ModMinestation.tabSpacestation);
		
		LanguageRegistry langReg = LanguageRegistry.instance();
    	langReg.addStringLocalization("tile.ms13:asteroid.stone.name","Asteroid Stone");
    	langReg.addStringLocalization("tile.ms13:asteroid.copper.name","Copper Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.iron.name","Iron Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.plasma.name","Plasma Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.silver.name","Silver Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.gold.name","Gold Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.uranium.name","Uranium Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.diamond.name","Diamond Ore");
    	langReg.addStringLocalization("tile.ms13:asteroid.bananas.name","Bananimum Ore");
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
    {
		icons = new IIcon[subTypes.length];
		for (int i=0;i<subTypes.length;i++) {
			icons[i] = par1IconRegister.registerIcon("ms13:asteroid."+subTypes[i]);
		}
    }
	
	@Override
	public void getSubBlocks(Item id, CreativeTabs creativeTab, List list) //TODO: Maybe should be Block id?
    {
		for (int i=0;i<subTypes.length;i++) {
			list.add(new ItemStack(id,1,i));
		}
    }
	
	@Override
	public int damageDropped(int m)
    {
        return m;
    }
	
	@Override
	public IIcon getIcon(int side, int metadata)
    {
        return icons[metadata];
    }
}