execute as @e[type=iron_golem,distance=..10] run attribute @s generic.max_health base set 150
execute as @e[type=iron_golem,distance=..10] run attribute @s generic.movement_speed base set 0.5
execute as @e[type=iron_golem,distance=..10] run attribute @s generic.attack_damage base set 30

execute as @e[tag=corrupted,distance=..25] run effect give @s glowing 10 1 true