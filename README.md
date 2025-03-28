git clone git@github.com:MCPHackers/RetroMCP-Java.git  
cd RetroMCP-Java 
./gradlew build  
  
cd ..  
git clone git@github.com:daedrafruit/b173-mods.git
cd modcreation
<java-8> -jar ../RetroMCP-Java/build/libs/RetroMCP-CLI-all.jar  
  
setup b1.7.3  
decompile  
exit  
  
git restore .  

