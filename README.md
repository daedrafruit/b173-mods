```  
git clone git@github.com:MCPHackers/RetroMCP-Java.git  
cd RetroMCP-Java 
./gradlew build  
  
cd ..  
git clone git@github.com:daedrafruit/b173-mods.git
cd b173-mods
<java-8> -jar ../RetroMCP-Java/build/libs/RetroMCP-CLI-all.jar  
  
setup b1.7.3  
decompile  
exit  
  
git restore .  
```  

BlockBackport  
-uu Block  
-ew ChunkCache  
-hk CraftingManager (also includes leather for books)  
-fd World  
-ys BlockStep  
-bk BlockLeaves (apple drop)  
+lang  
  
 Fix Sounds + Names  
 -uu Block  
 -ys BlockStep (for cobble slab name)  
 +lang for names  
  
 -cv RenderBlocks (fencegate)  
 -BlockFenceGate (fencegate)  
 -BlockTrapDoorIron  
 -au ItemPickaxe (toolfix)  
 -ta ItemAxe (toolfix)  
 -bb RenderItem (bigitemfix)  
  
Fix Sounds  
-uu Block  
-fo BlockJukebox  
-pt BlockNote  
-ve BlockBed  
  
ToolFix  
-au ItemPickaxe  
-wc ItemSpade  
-ta ItemAxe  
  
Fix Bookshelf Drops  
-uu Block  
-hb BlockBookshelf  
  
Reduce Mining Delay  
-uu Block  
-os PlayerControllerSP  
  
Fix Big Dropped Items  
-bb RenderItem  
  
Floating Fence  
-uu Block  
-jw BlockFence  
  
Pressure Plate Fence  
-uu Block  
-bv BlockPressurePlate  
  
Leather for book recipe  
-hk CraftingManager  
  
FoggyWeather  
-px EntityRenderer  
  
Far Lands Jitter  
-uu Block  
-tg RenderList  
  
Far Lands Blocks  
-uu Block  
-gk BlockSand  
  
Skin Fix  
-uu Block  
-dc EntityPlayerSP  
-gs EntityPlayer  
-xz EntityOtherPlayerMP  
-ModRetrieveSkin  
  
Floating trap door  
-uu Block  
-oq BlockTrapDoor  
  
Crash Slab Fix (incompatible with TMI)  
-uu Block  
-id GuiContainer  
  
Music Dics  
-uu Block  
-gb EntityCreeper  
-gm Item  
-n RenderGlobal (only for artist names, can be removed safely)  

Water Flow (Whirlpool) Fix  
-uu Block  
-om BlockFlowing  

Gold Tools Silk Touch  
-uu Block  
-au ItemPickaxe  
-bl ItemShears  
-ta ItemAxe  
-wc ItemSpade  
-nk BlockIce  
-ru BlockTallGrass  
-wp BlockGrass  
-ItemTallGrass  

Stair Drop Fix (separate from silk touch, kept independently toggleable)  
-uu Block  
-ss BlockStairs  

Cobweb Drop + Recipe  
-uu Block  
-hk CraftingManager  

Saddle Drop  
-uu Block  
-wh EntityPig  

Golden Apple Recipe (toggle only, recipe exists in base game)  
-uu Block  
-hk CraftingManager  

Sponge Recipe  
-uu Block  
-hk CraftingManager  

Gold Sword Fire Harvest (also unlocks base game chainmail recipe)  
-uu Block  
-fd World  

Mod Config (shared config file for all of the above)  
-ModConfig  

ABC List  
-au ItemPickaxe  
-bb RenderItem  
-bk BlockLeaves  
-bl ItemShears  
-bv BlockPressurePlate  
-cv RenderBlocks  
-dc EntityPlayerSP  
-ew ChunkCache  
-fd World  
-fo BlockJukeBox  
-gb EntityCreeper  
-gk BlockSand  
-gm Item  
-gs EntityPlayer  
-hb BlockBookshelf  
-hk CraftingManager  
-id GuiContainer  
-jw BlockFence  
-n RenderGlobal  
-nk BlockIce  
-om BlockFlowing  
-oq BlockTrapDoor  
-os PlayerControllerSP  
-pt BlockNote  
-px EntityRenderer  
-ru BlockTallGrass  
-ss BlockStairs  
-ta ItemAxe  
-tg RenderList  
-uu Block  
-ve BlockBed  
-wc ItemSpade  
-wh EntityPig  
-wp BlockGrass  
-xz EntityOtherPlayerMP  
-ys BlockStep  
-BlockFenceGate  
-BlockTrapDoorIron  
-ItemTallGrass  
-ModConfig  
-ModRetrieveSkin  
