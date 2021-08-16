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

recipe = "{{\n    \"type\": \"minecraft:crafting_shapeless\",\n    \"ingredients\": [\n        {{\n            \"item\": \"minecraft:stone\"\n        }},\n        {{\n        \"item\": \"frivycat:{g}\"\n      }},\n    {{\n    \"item\": \"frivycat:{g}\"\n    }}\n    ],\n    \"result\": {{\n    \"item\": \"frivycat:{g}_ore\",\n    \"count\": 1\n    }},\n    \"group\": \"ores\"\n}}"

for gem in gems:
    name = gem + "_ore.json"
    content = recipe.format(g = gem);
    file = open(name, "w")
    file.write(content)
    file.close()

print("Done")