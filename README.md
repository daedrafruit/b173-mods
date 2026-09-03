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
