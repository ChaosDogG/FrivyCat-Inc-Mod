execute as @e[type=enderman] if predicate frivycat:enderman_water run effect give @s wither 1 2 true
execute as @e[type=enderman] if predicate frivycat:enderman_lava run data merge entity @s {Fire:20}