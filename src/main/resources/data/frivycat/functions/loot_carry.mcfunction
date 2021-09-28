execute as @e[type=#frivycat:item_holders,type=!#frivycat:lucky,tag=!loot,tag=!buttered] run data merge entity @s {CanPickUpLoot:1b}
execute as @e[tag=buttered] run data merge entity @s {CanPickUpLoot:0}
tag @e[nbt={CanPickUpLoot:1b},tag=!loot,type=!player,tag=!buttered] add loot
tag @e[tag=buttered] remove loot