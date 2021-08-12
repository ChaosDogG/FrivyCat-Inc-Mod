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

dummies = [
    "a",
    "b",
    "c"
]

blocks = "{{\n  \"type\": \"minecraft:block\",\n  \"pools\": [\n    {{\n      \"rolls\": 1,\n      \"entries\": [\n        {{\n          \"type\": \"minecraft:item\",\n          \"name\": \"frivycat:{t}\"\n        }}\n      ],\n      \"conditions\": [\n        {{\n          \"condition\": \"minecraft:survives_explosion\"\n        }}\n      ]\n    }}\n  ]\n}}"

for gem in gems:
    name = gem + "_block.json"
    content = blocks.format(t = gem + "_block");
    file = open(name, "w")
    file.write(content)
    file.close()

for dummy in dummies:
    name = "dummy_" + dummy + ".json"
    content = blocks.format(t = "dummy_" + dummy);
    file = open(name, "w")
    file.write(content)
    file.close()
print("Done")
