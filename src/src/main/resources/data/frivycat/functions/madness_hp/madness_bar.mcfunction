execute as @e[tag=boss] store result bossbar minecraft:boss_hp value run scoreboard players get @s boss_hp
bossbar set minecraft:boss_hp style notched_10
execute as @e[tag=boss] store result bossbar minecraft:boss_hp max run scoreboard players get @s boss_hp_total
execute unless entity @e[tag=boss] run bossbar remove minecraft:boss_hp
execute if entity @e[tag=boss] run bossbar add minecraft:boss_hp [{"text":"Madness Level"}]

execute as @e[tag=boss] store result score @s boss_hp run data get entity @s Health
execute as @e[tag=boss] store result score @s boss_hp_total run data get entity @s Attributes[1].Base

execute as @e[tag=boss] store result score @s boss_hp_half run scoreboard players get @s boss_hp_total
execute as @e[tag=boss] run scoreboard players operation @s boss_hp_half /= half boss_hp_half
execute as @e[tag=boss] store result score @s boss_hp_quarter run scoreboard players get @s boss_hp_total
execute as @e[tag=boss] run scoreboard players operation @s boss_hp_quarter /= quarter boss_hp_quarter

execute as @e[tag=boss] if score @s boss_hp > @s boss_hp_half run bossbar set minecraft:boss_hp color purple
execute as @e[tag=boss] if score @s boss_hp <= @s boss_hp_half if score @s boss_hp > @s boss_hp_quarter run bossbar set minecraft:boss_hp color yellow
execute as @e[tag=boss] if score @s boss_hp <= @s boss_hp_quarter run bossbar set minecraft:boss_hp color red

execute if entity @e[tag=boss] run bossbar set minecraft:boss_hp players @a