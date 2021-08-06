execute as @e[type=villager,nbt={VillagerData:{profession:"minecraft:nitwit"}},distance=..5] run data merge entity @s {VillagerData:{profession:none},Offers:{}}
