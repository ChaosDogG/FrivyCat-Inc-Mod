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

ores = "{{\n    \"type\": \"minecraft:block\",\n    \"pools\": [\n    {{\n    \"rolls\": 1,\n\"entries\": [\n    {{\n    \"type\": \"minecraft:alternatives\",\n\"children\": [\n    {{\n    \"type\": \"minecraft:item\",\n\"name\": \"frivycat:{gem}_ore\",\n\"conditions\": [\n    {{\n    \"condition\": \"minecraft:match_tool\",\n\"predicate\": {{\n    \"enchantments\": [\n    {{\n    \"enchantment\": \"minecraft:silk_touch\",\n\"levels\": {{\n    \"min\": 1\n}}\n}}\n]\n}}\n}}\n]\n}},\n{{\n    \"type\": \"minecraft:item\",\n\"name\": \"frivycat:{gem}\",\n\"functions\": [\n    {{\n    \"function\": \"minecraft:apply_bonus\",\n\"enchantment\": \"minecraft:fortune\",\n\"formula\": \"minecraft:ore_drops\"\n}},\n{{\n    \"function\": \"minecraft:explosion_decay\"\n}}\n]\n}}\n]\n}}\n]\n}}\n]\n}}"

for gem in gems:
    name = gem + "_ore.json"
    content = ores.format(gem = gem);
    file = open(name, "w")
    file.write(content)
    file.close()
print("Done")