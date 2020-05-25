package net.minecraft.src;

import net.minecraft.client.Minecraft;
import java.io.File;

public class mod_Vinyl extends BaseMod {
	
	public static Item PVCItem = (new Item(5000)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/pvc.png")).setItemName("PVCItem");
	public static Item BlankRecord = (new Item(5001)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/blankRecord.png")).setItemName("BlankRecord");
	public static Item CardboardPackage = (new Item(5002)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/cardboardPackage.png")).setItemName("CardboardPackage");
	public static Item PackedRecord = (new ItemPackedRecord(5003)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/packedRecord.png")).setItemName("PackedRecord");
	public static Item CompoundBow = (new ItemCompoundBow(5004)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/compoundBow.png")).setItemName("CompoundBow");
	public static Item ReinforcedString = (new Item(5005)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/reinforcedString.png")).setItemName("ReinforcedString");
	public static Item SharpStick = (new ItemSword(5006, EnumToolMaterial.WOOD)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/sharpStick.png")).setItemName("SharpStick");
	public static Item CreeperWhistle = (new ItemCreeperWhistle(5007)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/creeperWhistle.png")).setItemName("CreeperWhistle");
	public static Item CreeperEssence = (new Item(5008)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/creeperEssence.png")).setItemName("CreeperEssence");
	public static Item AppleJuice = (new ItemJuice(5009,5)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/appleJuice.png")).setItemName("AppleJuice");
	public static Item LightningRod = (new ItemLightningRod(5010)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/lightningRod.png")).setItemName("LightningRod");
	public static Item DischargeCoil = (new Item(5011)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/dischargeCoil.png")).setItemName("DischargeCoil");
	public static Item RationHeater = (new Item(5012)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/rationHeater.png")).setItemName("RationHeater");
	public static Item MREItem = (new ItemFood(5013,20,false)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/itemMre.png")).setItemName("MREItem");
	public static Item MagnesiumDust = (new Item(5014)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/magnesiumDust.png")).setItemName("MagnesiumDust");
	public static Item FireStarter = (new ItemFirestarter(5015)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/fireStarter.png")).setItemName("FireStarter");
	
	
	public static final Block BlockCrate = (new BlockCustomChest(101,ModLoader.addOverride("/terrain.png", "/Vinyl/blockCrate.png"), Material.wood).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("BlockCrate"));
	static int cobbleTop = ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenTop.png");
	static int cobbleBottom = ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenBottom.png");
	public static final Block BlockCobbleGenT1 = (new BlockCobbleGen(102,ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenT1.png"), Material.iron, 1,cobbleTop,cobbleBottom).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockCobbleGenT1"));
	public static final Block BlockCobbleGenT2 = (new BlockCobbleGen(103,ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenT2.png"), Material.iron, 2,cobbleTop,cobbleBottom).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockCobbleGenT2"));
	public static final Block BlockCobbleGenT3 = (new BlockCobbleGen(104,ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenT3.png"), Material.iron, 3,cobbleTop,cobbleBottom).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockCobbleGenT3"));
	public static final Block BlockCobbleGenT4 = (new BlockCobbleGen(105,ModLoader.addOverride("/terrain.png", "/Vinyl/blockCobbleGenT4.png"), Material.iron, 4,cobbleTop,cobbleBottom).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockCobbleGenT4"));
	public static final Block BlockDeepStorage = (new BlockDeepStorage(106,ModLoader.addOverride("/terrain.png", "/Vinyl/deepStorageUnit.png"), Material.iron,ModLoader.addOverride("/terrain.png", "/Vinyl/deepStorageUnitTop.png"),ModLoader.addOverride("/terrain.png", "/Vinyl/deepStorageUnitBottom.png")).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockDeepStorage"));
	public static final Block BlockMachine = (new BlockCustom(107,ModLoader.addOverride("/terrain.png", "/Vinyl/blockMachine.png"), Material.iron).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockMachine"));
	public static final Block BlockRainbowBrick = (new BlockCustom(108,ModLoader.addOverride("/terrain.png", "/Vinyl/blockRainbowBrick.png"), Material.rock).setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setBlockName("BlockRainbowBrick"));
	public static final Block BlockIndustrialExtractor = (new BlockIndustrialExtractor(115,ModLoader.addOverride("/terrain.png", "/Vinyl/blockExtractor.png"), Material.iron,cobbleTop,cobbleBottom).setHardness(2.5F).setStepSound(Block.soundMetalFootstep).setBlockName("BlockIndustrialExtractor"));

	public static Item OreWheatDiamond = (new Item(5016)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/diamondWheat.png")).setItemName("OreWheatDiamond");
	public static Item OreWheatIron = (new Item(5017)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/ironWheat.png")).setItemName("OreWheatIron");
	public static Item OreWheatRedstone = (new Item(5018)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/redstoneWheat.png")).setItemName("OreWheatRedstone");
	public static Item OreWheatCoal = (new Item(5019)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/coalWheat.png")).setItemName("OreWheatCoal");
	public static Item OreWheatGold = (new Item(5020)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/goldWheat.png")).setItemName("OreWheatGold");
	public static Item OreWheatLapis = (new Item(5021)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/lapisWheat.png")).setItemName("OreWheatLapis");
	public static Item OreGrower = (new ItemOreGrower(5022)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/oreGrower.png")).setItemName("OreGrower");
	public static Item AutoHoe = (new ItemAutoHoe(5029)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/autoHoe.png")).setItemName("AutoHoe");
	public static Item GlowstoneCell = (new Item(5030)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/glowstoneCell.png")).setItemName("GlowstoneCell");
	public static Item SeedBase = (new Item(5031)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/seedBase.png")).setItemName("SeedBase");
	public static Item PDAItem = (new ItemPDA(5032)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/itemPDA.png")).setItemName("PDAItem");
	public static Item RedstoneCell = (new Item(5033)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/redstoneCell.png")).setItemName("RedstoneCell");
	public static Item DiamondHammer = (new ItemHammer(5034, EnumToolMaterial.EMERALD)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/diamondHammer.png")).setItemName("DiamondHammer");
	public static Item StoneHammer = (new ItemHammer(5035, EnumToolMaterial.STONE)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/stoneHammer.png")).setItemName("StoneHammer");
	public static Item IronHammer = (new ItemHammer(5036, EnumToolMaterial.IRON)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/ironHammer.png")).setItemName("IronHammer");
	public static Item GoldHammer = (new ItemHammer(5037, EnumToolMaterial.GOLD)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/goldHammer.png")).setItemName("GoldHammer");
	public static Item BonePickaxe = (new ItemPickaxe(5038, EnumToolMaterial.IRON)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/pickaxeBone.png")).setItemName("BonePickaxe");
	public static Item DriedLeather = (new Item(5039)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/driedLeather.png")).setItemName("DriedLeather");

	public static final Block BlockOreCropsDiamond = (new BlockOreCrops(109,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/diamond/wheat_stage_7.png"), "diamond").setBlockName("BlockOreCropsDiamond"));
	public static final Block BlockOreCropsIron = (new BlockOreCrops(110,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/iron/wheat_stage_7.png"), "iron").setBlockName("BlockOreCropsIron"));
	public static final Block BlockOreCropsRedstone = (new BlockOreCrops(111,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/redstone/wheat_stage_7.png"), "redstone").setBlockName("BlockOreCropsRedstone"));
	public static final Block BlockOreCropsCoal = (new BlockOreCrops(112,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/coal/wheat_stage_7.png"), "coal").setBlockName("BlockOreCropsCoal"));
	public static final Block BlockOreCropsGold = (new BlockOreCrops(113,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/gold/wheat_stage_7.png"), "gold").setBlockName("BlockOreCropsGold"));
	public static final Block BlockOreCropsLapis = (new BlockOreCrops(114,ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_7.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_0.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_1.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_2.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_3.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_4.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_5.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_6.png"),
			ModLoader.addOverride("/terrain.png", "/Vinyl/OreWheat/lapis/wheat_stage_7.png"), "lapis").setBlockName("BlockOreCropsLapis"));
	
	public static Item OreSeedsDiamond = (new ItemOreSeeds(5023, BlockOreCropsDiamond.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/diamondSeeds.png")).setItemName("OreSeedsDiamond");
	public static Item OreSeedsIron = (new ItemOreSeeds(5024, BlockOreCropsIron.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/ironSeeds.png")).setItemName("OreSeedsIron");
	public static Item OreSeedsRedstone = (new ItemOreSeeds(5025, BlockOreCropsRedstone.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/redstoneSeeds.png")).setItemName("OreSeedsRedstone");
	public static Item OreSeedsCoal = (new ItemOreSeeds(5026, BlockOreCropsCoal.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/coalSeeds.png")).setItemName("OreSeedsCoal");
	public static Item OreSeedsGold = (new ItemOreSeeds(5027, BlockOreCropsGold.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/goldSeeds.png")).setItemName("OreSeedsGold");
	public static Item OreSeedsLapis = (new ItemOreSeeds(5028, BlockOreCropsLapis.blockID)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/lapisSeeds.png")).setItemName("OreSeedsLapis");

	
	
	public static Item RecordBeach = (new ItemRecordCustom(5041,"On the Beach At Night","Curtis Schweitzer")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordBeach.png")).setItemName("RecordBeach");
	public static Item RecordBrush = (new ItemRecordCustom(5042,"Stickerbrush Symphony","David Wise")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordBrush.png")).setItemName("RecordBrush");
	public static Item RecordDog = (new ItemRecordCustom(5043,"dog","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordDog.png")).setItemName("RecordDog");
	public static Item RecordBlocks = (new ItemRecordCustom(5044,"blocks","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordBlocks.png")).setItemName("RecordBlocks");
	public static Item RecordChirp = (new ItemRecordCustom(5045,"chirp","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordChirp.png")).setItemName("RecordChirp");
	public static Item RecordFar = (new ItemRecordCustom(5046,"far","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordFar.png")).setItemName("RecordFar");
	public static Item RecordMall = (new ItemRecordCustom(5047,"mall","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordMall.png")).setItemName("RecordMall");
	public static Item RecordMellohi = (new ItemRecordCustom(5048,"mellohi","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordMellohi.png")).setItemName("RecordMellohi");
	public static Item RecordStal = (new ItemRecordCustom(5049,"stal","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordStal.png")).setItemName("RecordStal");
	public static Item RecordStrad = (new ItemRecordCustom(5050,"strad","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordStrad.png")).setItemName("RecordStrad");
	public static Item RecordWard = (new ItemRecordCustom(5051,"ward","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordWard.png")).setItemName("RecordWard");
	public static Item Record11 = (new ItemRecordCustom(5052,"11","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/record11.png")).setItemName("Record11");
	public static Item RecordWait = (new ItemRecordCustom(5053,"wait","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordWait.png")).setItemName("RecordWait");
	public static Item RecordE1M1 = (new ItemRecordCustom(5054,"At Doom's Gate","Bobby Prince")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordE1M1.png")).setItemName("RecordE1M1");
	public static Item RecordPepsi = (new ItemRecordCustom(5055,"Skylar Spence","SAINT PEPSI")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordPepsi.png")).setItemName("RecordPepsi");
	public static Item RecordOverworld = (new ItemRecordCustom(5056,"Overworld Day","Scott Lloyd Shelly")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordOverworld.png")).setItemName("RecordOverworld");
	public static Item RecordNyan = (new ItemRecordCustom(5057,"Nyan Cat","Nyan Cat")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordNyan.png")).setItemName("RecordNyan");
	public static Item RecordHey = (new ItemRecordCustom(5058,"HEYYEYAAEYAAAEYAEYAA","Slackcircus")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordHey.png")).setItemName("RecordHey");
	public static Item RecordJazz = (new ItemRecordCustom(5059,"Decoupage","Stan Kenton & His Orchestra")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordJazz.png")).setItemName("RecordJazz");
	public static Item RecordLofi = (new ItemRecordCustom(5060,"Minecraft Lo-Fi","Tyler Eller")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordLofi.png")).setItemName("RecordLofi");
	public static Item RecordPigstep = (new ItemRecordCustom(5061,"Pigstep","Lena Raine")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordPigstep.png")).setItemName("RecordPigstep");
	public static Item RecordSweden = (new ItemRecordCustom(5062,"Sweden","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordSweden.png")).setItemName("RecordSweden");
	public static Item RecordSubwoofer = (new ItemRecordCustom(5063,"Subwoofer Lullaby","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordSubwoofer.png")).setItemName("RecordSubwoofer");
	public static Item RecordRiccochet = (new ItemRecordCustom(5064,"Droopy likes riccochet","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordRiccochet.png")).setItemName("RecordRiccochet");
	public static Item RecordFace = (new ItemRecordCustom(5065,"Droopy likes your face","C418")).setIconIndex(ModLoader.addOverride("/gui/items.png", "/Vinyl/recordFace.png")).setItemName("RecordFace");

	public static Item[] Records = {
			RecordBeach,
			RecordBrush,
			RecordDog,
			RecordBlocks,
			RecordChirp,
			RecordFar,
			RecordMall,
			RecordMellohi,
			RecordStal,
			RecordStrad,
			RecordWard,
			Record11,
			RecordWait,
			RecordE1M1,
			RecordPepsi,
			RecordOverworld,
			RecordNyan,
			RecordHey,
			RecordJazz,
			RecordLofi,
			RecordPigstep,
			RecordSweden,
			RecordSubwoofer,
			RecordRiccochet,
			RecordFace,
			Item.record13,
			Item.recordCat
		};
	
	public String Version() {
		return "VinylCraft v1.3";
	}
	
	public Minecraft getMinecraftInstance() {
		Minecraft mc = ModLoader.getMinecraftInstance();
		return mc;
    }
	
	Minecraft mc1 = ModLoader.getMinecraftInstance();
	
	public mod_Vinyl() {
		
		ModLoader.AddName(PVCItem, "Polyvinyl Chloride (C2H3Cl)");
		ModLoader.AddName(BlankRecord, "Unpressed Vinyl");
		ModLoader.AddName(CardboardPackage, "Cardboard Package");
		ModLoader.AddName(PackedRecord, "Packed Record");
		ModLoader.AddName(CompoundBow, "Compound Bow");
		ModLoader.AddName(ReinforcedString, "Reinforced String");
		ModLoader.AddName(SharpStick, "Sharpened Stick");
		ModLoader.AddName(CreeperWhistle, "Creeper Whistle");
		ModLoader.AddName(CreeperEssence, "Creeper Essence");
		ModLoader.AddName(AppleJuice, "Apple Juice");
		ModLoader.AddName(LightningRod, "Lightning Rod");
		ModLoader.AddName(DischargeCoil, "Discharge Coil");
		ModLoader.AddName(RationHeater, "Flameless Ration Heater");
		ModLoader.AddName(MREItem, "Meal Ready-to-Eat");
		ModLoader.AddName(MagnesiumDust, "Magnesium Powder");
		ModLoader.AddName(FireStarter, "Magnesium Fire Starter");
		ModLoader.AddName(OreSeedsDiamond, "Diamond Seeds");
		ModLoader.AddName(OreSeedsIron, "Iron Seeds");
		ModLoader.AddName(OreSeedsRedstone, "Redstone Seeds");
		ModLoader.AddName(OreSeedsCoal, "Coal Seeds");
		ModLoader.AddName(OreSeedsGold, "Gold Seeds");
		ModLoader.AddName(OreSeedsLapis, "Lapis Seeds");
		ModLoader.AddName(OreWheatCoal, "Coal Wheat");
		ModLoader.AddName(OreWheatIron, "Iron Wheat");
		ModLoader.AddName(OreWheatDiamond, "Diamond Wheat");
		ModLoader.AddName(OreWheatRedstone, "Redstone Wheat");
		ModLoader.AddName(OreWheatLapis, "Lapis Wheat");
		ModLoader.AddName(OreWheatGold, "Gold Wheat");
		ModLoader.AddName(OreGrower, "Stone Meal");
		ModLoader.AddName(AutoHoe, "Auto-Hoe");
		ModLoader.AddName(GlowstoneCell, "Glowstone-Energized Cell");
		ModLoader.AddName(SeedBase, "Ore Seed Base");
		ModLoader.AddName(PDAItem, "§ePersonal Digital Assistant");
		ModLoader.AddName(RedstoneCell, "Redstone-Energized Cell");
		ModLoader.AddName(DiamondHammer, "Diamond Hammer");
		ModLoader.AddName(IronHammer, "Iron Hammer");
		ModLoader.AddName(StoneHammer, "Stone Hammer");
		ModLoader.AddName(GoldHammer, "Gold Hammer");
		ModLoader.AddName(BonePickaxe, "Bone Pickaxe");
		ModLoader.AddName(DriedLeather, "Dried Leather");
		
		ModLoader.RegisterBlock(BlockCrate);
		ModLoader.RegisterBlock(BlockCobbleGenT1);
		ModLoader.RegisterBlock(BlockCobbleGenT2);
		ModLoader.RegisterBlock(BlockCobbleGenT3);
		ModLoader.RegisterBlock(BlockCobbleGenT4);
		ModLoader.RegisterBlock(BlockDeepStorage);
		ModLoader.RegisterBlock(BlockMachine);
		ModLoader.RegisterBlock(BlockRainbowBrick);
		ModLoader.RegisterBlock(BlockOreCropsDiamond);
		ModLoader.RegisterBlock(BlockOreCropsIron);
		ModLoader.RegisterBlock(BlockOreCropsRedstone);
		ModLoader.RegisterBlock(BlockOreCropsCoal);
		ModLoader.RegisterBlock(BlockOreCropsLapis);
		ModLoader.RegisterBlock(BlockOreCropsGold);
		ModLoader.RegisterBlock(BlockIndustrialExtractor);
		ModLoader.RegisterTileEntity(TileEntityCrate.class, "CustomCrate");
		ModLoader.RegisterTileEntity(TileEntityCobbleGen.class, "CobbleGen");
		ModLoader.RegisterTileEntity(TileEntityDeepStorage.class, "DeepStorage");
		ModLoader.RegisterTileEntity(TileEntityIndustrialExtractor.class, "IndustrialExtractor");
		
		ModLoader.AddName(BlockCrate, "Storage Crate");
		ModLoader.AddName(BlockCobbleGenT1, "Cobblestone Generator (§bTier 1§r)");
		ModLoader.AddName(BlockCobbleGenT2, "Cobblestone Generator (§aTier 2§r)");
		ModLoader.AddName(BlockCobbleGenT3, "Cobblestone Generator (§eTier 3§r)");
		ModLoader.AddName(BlockCobbleGenT4, "Cobblestone Generator (§dTier 4§r)");
		ModLoader.AddName(BlockDeepStorage, "§dDeep Storage Unit");
		ModLoader.AddName(BlockMachine, "Machine Casing");
		ModLoader.AddName(BlockRainbowBrick, "§4R§ca§6i§en§2b§ao§bw§3 §1B§9r§di§4c§ck");
		ModLoader.AddName(BlockIndustrialExtractor, "Industrial Extractor");
		
		
		ModLoader.AddName(RecordBeach, "On the Beach at Night");
		ModLoader.AddName(RecordBrush, "Stickerbrush Symphony");
		ModLoader.AddName(RecordDog, "Dog");
		ModLoader.AddName(RecordBlocks, "Blocks");
		ModLoader.AddName(RecordChirp, "Chirp");
		ModLoader.AddName(RecordFar, "Far");
		ModLoader.AddName(RecordMall, "Mall");
		ModLoader.AddName(RecordMellohi, "Mellohi");
		ModLoader.AddName(RecordStal, "Stal");
		ModLoader.AddName(RecordStrad, "Strad");
		ModLoader.AddName(RecordWard, "Ward");
		ModLoader.AddName(Record11, "11");
		ModLoader.AddName(RecordWait, "Wait");
		ModLoader.AddName(RecordE1M1, "At Doom's Gate");
		ModLoader.AddName(RecordPepsi, "Skylar Spence");
		ModLoader.AddName(RecordOverworld, "Overworld Day");
		ModLoader.AddName(RecordNyan, "Nyan Cat");
		ModLoader.AddName(RecordHey, "HEYYEYAAEYAAAEYAEYAA");
		ModLoader.AddName(RecordJazz, "Decoupage");
		ModLoader.AddName(RecordLofi, "Minecraft Lo-Fi");
		ModLoader.AddName(RecordPigstep, "Pigstep");
		ModLoader.AddName(RecordSweden, "Sweden");
		ModLoader.AddName(RecordSubwoofer, "Subwoofer Lullaby");
		ModLoader.AddName(RecordRiccochet, "Droopy likes riccochet");
		ModLoader.AddName(RecordFace, "Droopy likes your face");
		ModLoader.AddRecipe(new ItemStack(BlankRecord, 1), new Object[] {"IVI", "V V", "IVI", Character.valueOf('I'), Item.ingotIron, Character.valueOf('V'), PVCItem});
		ModLoader.AddRecipe(new ItemStack(CardboardPackage, 1), new Object[] {"PPP", "PWP", "PPP", Character.valueOf('P'), Item.paper, Character.valueOf('W'), Item.bucketWater});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordBeach, 1), new Object[] {BlankRecord, Block.sand});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordBrush, 1), new Object[] {BlankRecord, Block.leaves});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordDog, 1), new Object[] {BlankRecord, Item.bone});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordBlocks, 1), new Object[] {BlankRecord, Block.brick});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordChirp, 1), new Object[] {BlankRecord, Item.egg});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordFar, 1), new Object[] {BlankRecord, Item.compass});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordMall, 1), new Object[] {BlankRecord, Block.chest});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordMellohi, 1), new Object[] {BlankRecord, Block.plantRed});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordStal, 1), new Object[] {BlankRecord, Item.ingotGold});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordStrad, 1), new Object[] {BlankRecord, Item.seeds});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordWard, 1), new Object[] {BlankRecord, Item.lightStoneDust});
		ModLoader.AddShapelessRecipe(new ItemStack(Record11, 1), new Object[] {BlankRecord, Item.flintAndSteel});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordWait, 1), new Object[] {BlankRecord, Block.cactus});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordE1M1, 1), new Object[] {BlankRecord, Block.netherrack});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordPepsi, 1), new Object[] {BlankRecord, Item.sugar});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordOverworld, 1), new Object[] {BlankRecord, Block.sapling});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordNyan, 1), new Object[] {BlankRecord, Item.cake});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordHey, 1), new Object[] {BlankRecord, Item.diamond});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordJazz, 1), new Object[] {BlankRecord, Block.musicBlock});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordLofi, 1), new Object[] {BlankRecord, Block.plantYellow});
		ModLoader.AddShapelessRecipe(new ItemStack(RecordPigstep, 1), new Object[] {BlankRecord, Item.porkCooked});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.record13, 1), new Object[] {BlankRecord, Item.ingotGold});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.recordCat, 1), new Object[] {BlankRecord, Item.fishRaw});
		
		ModLoader.AddShapelessRecipe(new ItemStack(PVCItem, 2), new Object[] {Item.slimeBall, Item.coal, Block.sand});
		ModLoader.AddShapelessRecipe(new ItemStack(PackedRecord, 1), new Object[] {CardboardPackage, BlankRecord, Item.ingotGold, Item.paper});
		ModLoader.AddRecipe(new ItemStack(CompoundBow, 1), new Object[] {" IS", "I S", " IS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), ReinforcedString});
		ModLoader.AddRecipe(new ItemStack(ReinforcedString, 3), new Object[] {"III", "SSS", "III", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.silk});
		ModLoader.AddRecipe(new ItemStack(SharpStick, 1), new Object[] {" S ", " S ", " S ", Character.valueOf('S'), Item.stick});
		ModLoader.AddRecipe(new ItemStack(CreeperWhistle, 1), new Object[] {"OO ", "MEM", " OM", Character.valueOf('O'), Block.obsidian, Character.valueOf('M'), Block.cobblestoneMossy, Character.valueOf('E'), CreeperEssence});
		ModLoader.AddRecipe(new ItemStack(DischargeCoil, 1), new Object[] {"RRR", "IDI", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), Item.diamond});
		ModLoader.AddRecipe(new ItemStack(LightningRod, 1), new Object[] {" I ", "DID", "IBI", Character.valueOf('B'), Block.button, Character.valueOf('D'), DischargeCoil, Character.valueOf('I'), Item.ingotIron});
		ModLoader.AddShapelessRecipe(new ItemStack(CreeperEssence, 1), new Object[] {Item.gunpowder, Item.lightStoneDust});
		ModLoader.AddShapelessRecipe(new ItemStack(AppleJuice, 1), new Object[] {Item.appleRed, Item.sugar, Item.bucketWater});
		ModLoader.AddShapelessRecipe(new ItemStack(RationHeater, 1), new Object[] {MagnesiumDust, Item.paper});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.porkCooked, 1), new Object[] {RationHeater, Item.porkRaw, Item.bucketWater});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.fishCooked, 1), new Object[] {RationHeater, Item.fishRaw, Item.bucketWater});
		ModLoader.AddShapelessRecipe(new ItemStack(MREItem, 1), new Object[] {Item.porkRaw, RationHeater, Item.cookie, Item.bread, Item.bread, Item.bowlSoup, Item.bucketWater});
		ModLoader.AddShapelessRecipe(new ItemStack(FireStarter, 1), new Object[] {MagnesiumDust, MagnesiumDust, MagnesiumDust, MagnesiumDust, MagnesiumDust, MagnesiumDust, Item.ingotIron, Item.flint});
		ModLoader.AddShapelessRecipe(new ItemStack(MagnesiumDust, 2), new Object[] {Item.ingotIron, Item.flint});
		
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsDiamond, 1), new Object[] {SeedBase, Item.diamond});
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsIron, 1), new Object[] {SeedBase, Item.ingotIron});
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsGold, 1), new Object[] {SeedBase, Item.ingotGold});
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsCoal, 1), new Object[] {SeedBase, Item.coal});
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsLapis, 1), new Object[] {SeedBase, new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.AddShapelessRecipe(new ItemStack(OreSeedsRedstone, 1), new Object[] {SeedBase, Item.redstone});
		ModLoader.AddShapelessRecipe(new ItemStack(DiamondHammer, 64), new Object[] {Block.dirt});
		ModLoader.AddShapelessRecipe(new ItemStack(Item.stick, 64), new Object[] {Block.sand, Block.dirt});
		ModLoader.AddShapelessRecipe(new ItemStack(PDAItem, 1), new Object[] {Block.dirt, Block.dirt});
		ModLoader.AddShapelessRecipe(new ItemStack(Block.stone, 1), new Object[] {Block.cobblestone, Block.cobblestone, Block.cobblestone, Block.cobblestone});
		ModLoader.AddShapelessRecipe(new ItemStack(OreGrower, 1), new Object[] {Block.stone, Item.ingotIron, new ItemStack(Item.dyePowder, 1, 15)});
		ModLoader.AddShapelessRecipe(new ItemStack(PDAItem, 1), new Object[] {GlowstoneCell, Item.compass, Item.pocketSundial});
		ModLoader.AddRecipe(new ItemStack(Item.diamond, 1), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatDiamond}); 
		ModLoader.AddRecipe(new ItemStack(Item.ingotIron, 1), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatIron});
		ModLoader.AddRecipe(new ItemStack(Item.redstone, 3), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatRedstone});
		ModLoader.AddRecipe(new ItemStack(Item.coal, 1), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatCoal});
		ModLoader.AddRecipe(new ItemStack(Item.ingotGold, 1), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatGold});
		ModLoader.AddRecipe(new ItemStack(Item.dyePowder, 3, 4), new Object[] {"   ", "WWW", "   ", Character.valueOf('W'), OreWheatLapis});
		ModLoader.AddRecipe(new ItemStack(AutoHoe, 1), new Object[] {" H ", "IPI", "IBI", Character.valueOf('H'), Item.hoeDiamond, Character.valueOf('I'), Item.ingotIron, Character.valueOf('P'), Block.pistonBase, Character.valueOf('B'), RedstoneCell});
		ModLoader.AddRecipe(new ItemStack(GlowstoneCell, 1), new Object[] {" I ", "IGI", " I ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('G'), Item.lightStoneDust});
		ModLoader.AddRecipe(new ItemStack(RedstoneCell, 1), new Object[] {" I ", "IRI", " I ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('R'), Item.redstone});
		ModLoader.AddRecipe(new ItemStack(SeedBase, 1), new Object[] {"SGS", "GDG", "SGS", Character.valueOf('S'), Block.stone, Character.valueOf('G'), Item.lightStoneDust, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.AddRecipe(new ItemStack(DiamondHammer, 1), new Object[] {"DDD", "DDD", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('D'), Item.diamond});
		ModLoader.AddRecipe(new ItemStack(StoneHammer, 1), new Object[] {"BBB", "BBB", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('B'), Block.cobblestone});
		ModLoader.AddRecipe(new ItemStack(IronHammer, 1), new Object[] {"III", "III", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('I'), Item.ingotIron});
		ModLoader.AddRecipe(new ItemStack(GoldHammer, 1), new Object[] {"GGG", "GGG", " S ", Character.valueOf('S'), Item.stick, Character.valueOf('G'), Item.ingotGold});
		ModLoader.AddRecipe(new ItemStack(BonePickaxe, 1), new Object[] {"BBB", " B ", " B ", Character.valueOf('B'), Item.bone});
		ModLoader.AddRecipe(new ItemStack(Item.bootsLeather, 1), new Object[] {"   ", "L L", "L L", Character.valueOf('L'), DriedLeather});
		ModLoader.AddRecipe(new ItemStack(Item.legsLeather, 1), new Object[] {"LLL", "L L", "L L", Character.valueOf('L'), DriedLeather});
		ModLoader.AddRecipe(new ItemStack(Item.plateLeather, 1), new Object[] {"L L", "LLL", "LLL", Character.valueOf('L'), DriedLeather});
		ModLoader.AddRecipe(new ItemStack(Item.helmetLeather, 1), new Object[] {"LLL", "L L", "   ", Character.valueOf('L'), DriedLeather});
		
		ModLoader.AddRecipe(new ItemStack(BlockRainbowBrick, 4), new Object[] {"CRC", "YCG", "CBC", Character.valueOf('C'), Item.coal, Character.valueOf('R'), new ItemStack(Item.dyePowder, 1, 1), Character.valueOf('Y'), new ItemStack(Item.dyePowder, 1, 11), Character.valueOf('G'), new ItemStack(Item.dyePowder, 1, 2), Character.valueOf('B'), new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.AddRecipe(new ItemStack(BlockMachine, 2), new Object[] {"III", "IBI", "III", Character.valueOf('I'), Item.ingotIron, Character.valueOf('B'), Block.stone});
		ModLoader.AddRecipe(new ItemStack(BlockCobbleGenT1, 1), new Object[] {"III", "WBL", "III", Character.valueOf('I'), Item.ingotIron, Character.valueOf('B'), BlockMachine, Character.valueOf('W'), Item.bucketWater, Character.valueOf('L'), Item.bucketLava});
		ModLoader.AddRecipe(new ItemStack(BlockCobbleGenT2, 1), new Object[] {"GGG", "GBG", "GGG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('B'), BlockCobbleGenT1});
		ModLoader.AddRecipe(new ItemStack(BlockCobbleGenT3, 1), new Object[] {"DDD", "DBD", "DDD", Character.valueOf('D'), Item.diamond, Character.valueOf('B'), BlockCobbleGenT2});
		ModLoader.AddRecipe(new ItemStack(BlockCobbleGenT4, 1), new Object[] {"DGD", "GBG", "DGD", Character.valueOf('G'), Block.glowStone, Character.valueOf('D'), Block.blockDiamond, Character.valueOf('B'), BlockCobbleGenT3});
		ModLoader.AddRecipe(new ItemStack(BlockDeepStorage, 1), new Object[] {"DOD", "OBO", "DOD", Character.valueOf('O'), Block.obsidian, Character.valueOf('D'), Item.diamond, Character.valueOf('B'), BlockMachine});
		ModLoader.AddRecipe(new ItemStack(BlockCrate, 1), new Object[] {"WWW", "WCW", "WWW", Character.valueOf('W'), Block.planks, Character.valueOf('C'), Block.chest});
		ModLoader.AddRecipe(new ItemStack(BlockIndustrialExtractor, 1), new Object[] {"GLG", "DMD", "GLG", Character.valueOf('G'), Item.lightStoneDust, Character.valueOf('D'), Item.diamond, Character.valueOf('M'), BlockMachine, Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4)});
		
	}

}




