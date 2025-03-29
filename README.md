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
+lang

 Fix Sounds + Names
 -uu Block
 -ys BlockStep (for cobble slab name)
 +lang for names

 -cv RenderBlocks (fencegate)
 -BlockFenceGate (fencegate)
 -BlockIronTrapdoor (fencegate)
 -au ItemPickaxe (toolfix)
 -ta ItemAxe (toolfix)
 -bb RenderItem (bigitemfix)

Fix Sounds
-fo BlockJukebox
-pt BlockNote
-ve BlockBed

ToolFix
-au ItemPickaxe
-wc ItemSpade
-ta ItemAxe

Fix Bookshelf Drops
-hb BlockBookshelf

Reduce Mining Delay
-os PlayerControllerSP

Fix Stair Drops
-ss BlockStairs

Fix Big Dropped Items
-bb RenderItem

Floating Fence
-jw BlockFence

Pressure Plate Fence
-bv BlockPressurePlate

Leather for book recipe
-hk CraftingManager

FoggyWeather
-px EntityRenderer

Far Lands Jitter
-tg RenderList

Far Lands Blocks
-gk BlockSand

Skin Fix
-dc EntityPlayerSP
-gs EntityPlayer
-xz EntityOtherPlayerMP
-ModRetrieveSkin

Floating trap door
-oq BlockTrapDoor

Crash Slab Fix (incompatible with TMI)
-id GuiContainer

Music Dics
-gb EntityCreeper
-gm Item
-n RenderGlobal (only for artist names, can be removed safely)

ABC List
-au ItemPickaxe
-bb RenderItem
-bv BlockPressurePlate
-cv RenderBlocks
-dc EntityPlayerSP
-eo BlockStone
-ew ChunkCache
-fd World
-fo BlockJukebox
-gb EntityCreeper
-gk BlockSand
-gm Item
-gs EntityPlayer
-hb BlockbookShelf
-hk CraftingManager
-jq BlockPistonBase?
-jw BlockFence
-oq BlockTrapDoor
-os PlayerControllerSP
-n RenderGlobal
-ot BlockDirt
-pt BlockNote
-px EntityRenderer
-ss BlockStairs
-ta ItemAxe
-tg RenderList
-uu Block
-ve BlockBed?
-wc ItemSpade
-xk PlayerControlerMP
-xz EntityOtherPlayerMP
-ys BlockStep
