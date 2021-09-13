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

recipe = "{{\n    \"type\": \"minecraft:crafting_shapeless\",\n\"ingredients\": [\n    {{\n    \"item\": \"frivycat:{t}_block\"\n}}\n],\n\"result\": {{\n\"item\": \"frivycat:{t}\",\n\"count\": 9\n}}\n}}"

for gem in gems:
    name = gem + ".json"
    content = recipe.format(t = gem);
    file = open(name, "w")
    file.write(content)
    file.close()

print("Done")