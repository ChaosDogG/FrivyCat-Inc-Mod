execute as @e[tag=boss] if score hp boss_hp > half boss_hp_half run bossbar set minecraft:boss_hp color purple
execute as @e[tag=boss] if score hp boss_hp <= half boss_hp_half if score hp boss_hp > quarter boss_hp_quarter run bossbar set minecraft:boss_hp color yellow
execute as @e[tag=boss] if score hp boss_hp <= quarter boss_hp_quarter run bossbar set minecraft:boss_hp color red