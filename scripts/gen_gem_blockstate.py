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

blockstate_temp_block = "{{\n    \"variants\": {{\n    \"\": {{\n        \"model\": \"frivycat:block/{g}_block\"\n    }}\n  }}\n}}"

blockstate_temp_ore = "{{\n    \"variants\": {{\n    \"\": {{\n        \"model\": \"frivycat:block/{g}_ore\"\n    }}\n  }}\n}}"

for gem in blocks:
    name = gem + "_block.json"
    content = blockstate_temp_block.format(g = gem);
    file = open(name, "w")
    file.write(content)
    file.close()

for gem in ores:
    name = gem + "_ore.json"
    content = blockstate_temp_ore.format(g = gem);
    file = open(name, "w")
    file.write(content)
    file.close()

print("Done")