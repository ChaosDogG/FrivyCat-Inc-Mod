execute as @e[tag=boss] store result bossbar minecraft:boss_hp value run scoreboard players get hp boss_hp
bossbar set minecraft:boss_hp style notched_10
execute as @e[tag=boss] store result bossbar minecraft:boss_hp max run scoreboard players get total boss_hp_total

execute unless entity @e[tag=boss] run bossbar remove minecraft:boss_hp
execute if entity @e[tag=boss] run bossbar add minecraft:boss_hp [{"text":"Madness Level"}]

execute if entity @e[tag=boss] run bossbar set minecraft:boss_hp players @a

scoreboard objectives add boss_hp dummy
scoreboard objectives add boss_hp_total dummy
scoreboard players set total boss_hp_total 7200
scoreboard objectives add boss_hp_half dummy
scoreboard players set half boss_hp_half 3600
scoreboard objectives add boss_hp_quarter dummy
scoreboard players set quarter boss_hp_quarter 1800

function frivycat:madness_hp/madness_bar_value