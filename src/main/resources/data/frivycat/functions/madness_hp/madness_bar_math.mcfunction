execute unless entity @e[tag=boss] run scoreboard players set hp boss_hp 0

execute as @e[tag=boss] store result score hp boss_hp run scoreboard players get @s boss_hp
execute as @e[tag=boss] run scoreboard players operation hp boss_hp += @s boss_hp

function frivycat:madness_hp/madness_bar_color