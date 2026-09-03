```bash 
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

Features:  
- Brick and sandstone stairs, brick slabs  
- Fence gates  
- Wooden buttons (configurable recipe: 2 logs vs. modern 1 plank) and a legacy-vs-modern stone button recipe toggle  
- Iron trapdoors (includes floating toggle, see wooden trapdoor change below)  
- Cobweb recipe (8 string around slime ball)  
- Apple drop from oak leaves (1/200 chance on decay)  
- Golden apple recipe toggle (off by default, to preserve its rarity)  
- Functional Redstone block
- Functional Coal block
- Redstone and Coal blocks use recolored lapis block for beta-like appearance
- ToolFix (expands tools effectiveness to match later versions (furnace, crafting table, etc.)) 
- Configurable bookshelf drops  
- Removes the artificial mining-delay lag after breaking a block (click mining)
- Fixes several dropped items rendering oversized on the ground (cactus, stairs, etc.)
- Fences can be placed without support  
- Pressure plates can be placed on fences  
- Books craft from 3 paper + 1 leather instead of paper alone (gives leather more purpose)
- Corrects bed/jukebox/noteblock sounds (configurable)  
- Updated skin/cape API endpoints  
- Wooden trapdoors remain floating without support (cannot be placed this way)
- Guards against a tooltip crash (notably one that conflicts with TMI)  
- Adds recent music discs to creeper/skeleton kills (3-tier: vanilla (cat/13), classic (c418), or up to relic (classic + pigstep, otherside, 5, relic))  
- Fixes a water source bug (whirlpool)
- Gold tools have silk-touch like effect  
- Stairs drop themselves instead of their base block  
- Pigs drop saddle on death  
- Sponge recipe (4 slime balls around yellow wool)
- Gold sword can pick up fire burning over netherrack, which chainmail-armor recipe craftable  
- Fixes rendering jitter and falling-block glitches at extreme "far lands" coordinates  

Debugging tips:  
in Minecraft.java:  
```java
//press F4 to give item
if(Keyboard.getEventKey() == Keyboard.KEY_F4) {
    // item id, size, damage
    ItemStack stack = new ItemStack(285, 1, 100);
    this.thePlayer.inventorySlots.putStackInSlot(1, stack);
}
```
