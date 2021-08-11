#!/usr/bin/env python3

blocks = [
    "ruby",
    "sapphire",
    "zircon",
    "garnet",
    "jade",
    "jasper",
    "spinel",
    "topaz",
    "agate"
]

ores = [
    "ruby",
    "sapphire",
    "zircon",
    "garnet",
    "jade",
    "jasper",
    "spinel",
    "topaz",
    "agate"
]

file_content_a = "{{\n    \"parent\": \"minecraft:block/cube_all\",\n    \"textures\": {{\n        \"all\": \"frivycat:block/material/{gem}_block\"\n    }}\n}}"

file_content_b = "{{\n    \"parent\": \"minecraft:block/cube_all\",\n    \"textures\": {{\n        \"all\": \"frivycat:block/ore/{gem}_ore\"\n    }}\n}}"

for gem in blocks:
    content = file_content_a.format(gem = gem);
    file = open(gem + "_block.json", "w")
    file.write(content)
    file.close()

for gem in ores:
    content = file_content_b.format(gem = gem);
    file = open(gem + "_ore.json", "w")
    file.write(content)
    file.close()

print("Done")