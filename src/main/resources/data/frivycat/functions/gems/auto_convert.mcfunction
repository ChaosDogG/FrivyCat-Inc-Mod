execute as @e[type=item_frame,nbt={Item:{id:"minecraft:emerald",Count:1b,tag:{CustomModelData:1}}}] run tp @e[type=zombie_villager,distance=10..50] @s
execute as @e[type=zombie_villager,distance=..10] run data merge entity @s {ConversionTime:0}