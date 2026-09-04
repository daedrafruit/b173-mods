#!/bin/sh
if ! git diff --quiet; then
    echo "Error: Unstaged changes detected, commit or stash them before building."
    exit 1
fi

rm -rf minecraft/reobf minecraft/src
java -jar ../RetroMCP-Java/build/libs/RetroMCP-CLI-all.jar decompile
git restore .
java -jar ../RetroMCP-Java/build/libs/RetroMCP-CLI-all.jar recompile
java -jar ../RetroMCP-Java/build/libs/RetroMCP-CLI-all.jar reobfuscate
cp -r minecraft/resources/* minecraft/reobf
rm -f Parker_mod.zip
cd minecraft/reobf/
zip -r ../../Parker_mod.zip .
cd ../../
