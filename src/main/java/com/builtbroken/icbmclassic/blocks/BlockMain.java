package com.builtbroken.icbmclassic.blocks;

import com.builtbroken.icbmclassic.creativeTabs.CreativeTabsMain;
import com.builtbroken.icbmclassic.lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/** Written By Herobrine11892 **/

public class BlockMain {
	
	public static void mainRegistry ()
	{
		initializeBlock();
		registerItem();
	}
	//Miscellanious Blocks
	public static Block ReinfGlass;
	public static Block Concrete;
	public static Block ComConcrete;
	public static Block ReinfConcrete;
	public static Block Camouflage;
	public static Block ProxDetector;
	public static Block GlassButton;
	public static Block GlassPressurePlate;	
	//End Of Miscellanious Blocks
	
	//Ores
	public static Block SulfurOre;
	//End Of Ores
	
	//Special Blocks
	public static Block RadarStation;
	public static Block EMPTower;
	public static Block MissileCoordinator;
	//End Of Special Blocks
	
	//Launchers
	public static Block LaunchCruisive;
	//Tier 1
	public static Block LaunchPlatT1;
	public static Block LaunchCtrlT1;
	public static Block LaunchSuppFrameT1;
	//Tier 2
	public static Block LaunchPlatT2;
	public static Block LaunchCtrlT2;
	public static Block LaunchSuppFrameT2;
	//Tier 3
	public static Block LaunchPlatT3;
	public static Block LaunchCtrlT3;
	public static Block LaunchSuppFrameT3;
	//End Of Launchers
	
	//Explosives
	public static Block SMine;
	//Tier 1 
	public static Block ConExplosives;
	public static Block RepExplosives;
	public static Block SharpExplosives;
	public static Block IncExplosives;
	public static Block DebExplosives;
	public static Block ChemExplosives;
	public static Block AnvExplosives;
	public static Block AttrExplosives;
	//Tier 2
	public static Block FragExplosives;
	public static Block ContExplosives;
	public static Block SonicExplosives;
	public static Block BrExplosives;
	public static Block RejExplosives;
	public static Block ThermExplosives;
	//Tier 3
	public static Block NukeExplosives;
	public static Block EMPExplosives;
	public static Block ExoExplosives;
	public static Block EndoExplosives;
	public static Block AntiGExplosives;
	public static Block EndExplosives;
	public static Block HypExplosives;
	//Tier 4
	public static Block AntimatterExplosives;
	public static Block RedMatterExplosives;
	//End Of Explosives
	
	public static void initializeBlock ()
	{
		    //Miscellanious Blocks
			ReinfGlass = new ReinforcedGlass(Material.ground).setBlockName("ReinfGlass").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":ReinfGlass");
			Concrete = new Concrete(Material.ground).setBlockName("Concrete").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":concrete");
			ComConcrete = new CompactConcrete(Material.ground).setBlockName("CompactConcrete").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":concreteCompact");
			ReinfConcrete = new ReinforcedConcrete(Material.ground).setBlockName("ReinforcedConcrete").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":concreteReinforced");
			Camouflage = new Camouflage(Material.ground).setBlockName("Camouflage").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":camouflage");
			ProxDetector = new ProximityDetector(Material.ground).setBlockName("ProximityDetector").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			GlassButton = new GlassButton().setBlockName("GlassButton").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			GlassPressurePlate = new GlassPressurePlate("BlockPressurePlate", Material.circuits, BlockPressurePlate.Sensitivity.everything ).setBlockName("GlassPressurePlate").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//End Of Miscellanious Blocks
			
			//Ores
			SulfurOre = new SulfurOre(Material.ground).setBlockName("SulfurOre").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName(RefStrings.MODID + ":SulfurOre");
			//End Of Ores
			
			//Special Blocks
			RadarStation = new RadarStation(Material.ground).setBlockName("RadarStation").setCreativeTab(CreativeTabsMain.CreativeTabICBM).setBlockTextureName("radar");
			EMPTower = new EMPTower(Material.ground).setBlockName("EMPTower").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//NO MODEL FOUND FOR IT YET MissileCoordinator = new MissileCoordinator(Material.ground).setBlockName("MissileCoorsinator").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//End Of Special Blocks
			
			//Launchers
			//LaunchCruisive = new CruisiveMissileLauncher(Material.ground).setBlockName("LaunchCruisive").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 1
			//LaunchPlatT1 = new LauncherPlatformTier1(Material.ground).setBlockName("LaunchPlatT1").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchCtrlT1 = new LauncherControllerTier1(Material.ground).setBlockName("LaunchCtrlT1").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchSuppFrameT1 = new LauncherSupportFrameTier1(Material.ground).setBlockName("LaunchSuppFrameT1").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 2
			//LaunchPlatT2 = new LauncherPlatformTier2(Material.ground).setBlockName("LaunchPlatT2").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchCtrlT2 = new LauncherControllerTier2(Material.ground).setBlockName("LaunchCtrlT2").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchSuppFrameT2 = new LauncherSupportFrameTier2(Material.ground).setBlockName("LaunchSuppFrameT2").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 3
			//LaunchPlatT3 = new LauncherPlatformTier3(Material.ground).setBlockName("LaunchPlatT3").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchCtrlT3 = new LauncherControllerTier3(Material.ground).setBlockName("LaunchCtrlT3").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//LaunchSuppFrameT3 = new LauncherSupportFrameTier3(Material.ground).setBlockName("LaunchSuppFrameT3").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//End Of Launchers
			
			//Explosives
			//SMine = new SMine(Material.ground).setBlockName("SMine").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 1
			ConExplosives = new CondensedExplosives(Material.tnt).setBlockName("ConExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			RepExplosives = new RepulsiveExplosives(Material.tnt).setBlockName("RepExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			SharpExplosives = new SharpelExplosives(Material.tnt).setBlockName("SharpExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			IncExplosives = new IncediaryExplosives(Material.tnt).setBlockName("IncExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			DebExplosives = new DebilitationExplosives(Material.tnt).setBlockName("DebExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			ChemExplosives = new ChemicalExplosives(Material.tnt).setBlockName("ChemExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			AnvExplosives = new AnvilExplosives(Material.tnt).setBlockName("AnvExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			AttrExplosives = new AttractiveExplosives(Material.tnt).setBlockName("AttrExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 2
			FragExplosives = new FragmentationExplosives(Material.tnt).setBlockName("FragExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			ContExplosives = new ContagiousExplosives(Material.tnt).setBlockName("ContExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			SonicExplosives = new SonicExplosives(Material.tnt).setBlockName("SonicExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			BrExplosives = new BreachingExplosives(Material.tnt).setBlockName("BrExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			RejExplosives = new RejuvenationExplosives(Material.tnt).setBlockName("RejExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			ThermExplosives = new ThermobaticExplosives(Material.tnt).setBlockName("ThermExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 3 
			NukeExplosives = new NuclearExplosives(Material.tnt).setBlockName("NukeExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			EMPExplosives = new EMPExplosives(Material.tnt).setBlockName("EMPExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			ExoExplosives = new ExothermicExplosives(Material.tnt).setBlockName("ExoExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			EndoExplosives = new EndothermicExplosives(Material.tnt).setBlockName("EndoExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			AntiGExplosives = new AntiGravitationalExplosives(Material.tnt).setBlockName("AntiGExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			EndExplosives = new EnderExplosives(Material.tnt).setBlockName("EndExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			HypExplosives = new HypersonicExplosives(Material.tnt).setBlockName("HypExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//Tier 4
			AntimatterExplosives = new AntimatterExplosives(Material.tnt).setBlockName("AntimatterExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			RedMatterExplosives = new RedMatterExplosives(Material.tnt).setBlockName("RedMatterExplosives").setCreativeTab(CreativeTabsMain.CreativeTabICBM);
			//End Of Explosives
	}
	
	public static void registerItem ()
	{
	    //Miscellanious Blocks
		GameRegistry.registerBlock(ReinfGlass, ReinfGlass.getUnlocalizedName());
		GameRegistry.registerBlock(Concrete, Concrete.getUnlocalizedName());
		GameRegistry.registerBlock(ComConcrete, ComConcrete.getUnlocalizedName());
		GameRegistry.registerBlock(ReinfConcrete, ReinfConcrete.getUnlocalizedName());
		GameRegistry.registerBlock(Camouflage, Camouflage.getUnlocalizedName());
		GameRegistry.registerBlock(ProxDetector, ProxDetector.getUnlocalizedName());
		GameRegistry.registerBlock(GlassButton, GlassButton.getUnlocalizedName());
		GameRegistry.registerBlock(GlassPressurePlate, GlassPressurePlate.getUnlocalizedName());
		//End Of Miscellanious Blocks
		
		//Ores
		GameRegistry.registerBlock(SulfurOre, SulfurOre.getUnlocalizedName());
		//End Of Ores
		
		//Special Blocks
		GameRegistry.registerBlock(RadarStation, RadarStation.getUnlocalizedName());
		GameRegistry.registerBlock(EMPTower, EMPTower.getUnlocalizedName());
		//NO MODEL FOUND FOR IT YET GameRegistry.registerBlock(MissileCoordinator, MissileCoordinator.getUnlocalizedName());
		//End Of Special Blocks
		
		//Launchers
		//GameRegistry.registerBlock(LaunchCruisive, LaunchCruisive.getUnlocalizedName());
		//Tier 1
		//GameRegistry.registerBlock(LaunchPlatT1, LaunchPlatT1.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchCtrlT1, LaunchCtrlT1.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchSuppFrameT1, LaunchSuppFrameT1.getUnlocalizedName());
		//Tier 2
		//GameRegistry.registerBlock(LaunchPlatT2, LaunchPlatT2.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchCtrlT2, LaunchCtrlT2.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchSuppFrameT2, LaunchSuppFrameT2.getUnlocalizedName());
		//Tier 3
		//GameRegistry.registerBlock(LaunchPlatT3, LaunchPlatT3.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchCtrlT3, LaunchCtrlT3.getUnlocalizedName());
		//GameRegistry.registerBlock(LaunchSuppFrameT3, LaunchSuppFrameT3.getUnlocalizedName());
		//End Of Launchers
		
		//Explosives
		//GameRegistry.registerBlock(SMine, SMine.getUnlocalizedName());
		//Tier 1
		GameRegistry.registerBlock(ConExplosives, ConExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(RepExplosives, RepExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(SharpExplosives, SharpExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(IncExplosives, IncExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(DebExplosives, DebExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(ChemExplosives, ChemExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(AnvExplosives, AnvExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(AttrExplosives, AttrExplosives.getUnlocalizedName());
		//Tier 2
		GameRegistry.registerBlock(FragExplosives, FragExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(ContExplosives, ContExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(SonicExplosives, SonicExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(BrExplosives, BrExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(RejExplosives, RejExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(ThermExplosives, ThermExplosives.getUnlocalizedName());
		//Tier 3
		GameRegistry.registerBlock(NukeExplosives, NukeExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(EMPExplosives, EMPExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(ExoExplosives, ExoExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(EndoExplosives, EndoExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(AntiGExplosives, AntiGExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(EndExplosives, EndExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(HypExplosives, HypExplosives.getUnlocalizedName());
		//Tier 4
		GameRegistry.registerBlock(AntimatterExplosives, AntimatterExplosives.getUnlocalizedName());
		GameRegistry.registerBlock(RedMatterExplosives, RedMatterExplosives.getUnlocalizedName());
		//End Of Explosives
	}
	
	

}
