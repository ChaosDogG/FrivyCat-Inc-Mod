#!/usr/bin/env python3
gems = [
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

recipe = "{{\n  \"type\": \"minecraft:crafting_shaped\",\n  \"pattern\": [\n    \"###\",\n    \"###\",\n    \"###\"\n  ],\n  \"key\": {{\n    \"#\": {{\n      \"item\": \"frivycat:{t}\"\n    }}\n  }},\n  \"result\": {{\n    \"item\": \"frivycat:{t}_block\",\n    \"count\": 1\n  }}"

for gem in gems:
    name = gem + "_block.json"
    content = recipe.format(t = gem);
    file = open(name, "w")
    file.write(content)
    file.close()

print("Done")